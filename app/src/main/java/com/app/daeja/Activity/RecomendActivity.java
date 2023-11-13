package com.app.daeja.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.daeja.Activity.Domain.ParkingInfo;
import com.app.daeja.Adapter.ParkingInfoAdapter;
import com.app.daeja.R;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class RecomendActivity extends AppCompatActivity {

    Thread thread;
    Call<List<ParkingInfo>> call;

    protected RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private LinearLayout linearLayoutTmap;
    private List<ParkingInfo> parkingInfos;
    private TMapView tMapView;
    private double cur_lat = 37.4849732;
    private double cur_lng = 126.9012370;
    private static final String tApiKey = "KbtV6K1LiCa2kYZ2ieDhU3pxBBS5A5gA5CL5O3el";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomend);

        tMapViewInit();

        callServer();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tMapView.removeAllMarkerItem();
        pointPin();
        tMapView.setLocationPoint(37.48395, 126.9010);
        recyclerVieParking();
    }

    private void pointPin() {

        for(int i = 0; i < parkingInfos.size(); i++){
            TMapMarkerItem tMapMarkerItem = new TMapMarkerItem();
            TMapPoint tMapPoint = new TMapPoint(parkingInfos.get(i).getLAT(), parkingInfos.get(i).getLNG());
            String markerId;
            Bitmap bitmap;

            //marker setting
            if(parkingInfos.get(i).get주차혼잡도().equals("많음")){
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_green);
            }else if (parkingInfos.get(i).get주차혼잡도().equals("보통")){
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_yellow);
            }else if (parkingInfos.get(i).get주차혼잡도().equals("적음")){
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_red);
            }else{
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_gray);
            }

            tMapMarkerItem.setIcon(bitmap);
            tMapMarkerItem.setPosition(0.5f, 1.0f); // 마커의 중심점을 중앙, 하단으로 설정
            tMapMarkerItem.setTMapPoint( tMapPoint );
            tMapMarkerItem.setName(parkingInfos.get(i).getPARKING_NAME()); // 마커의 타이틀 지정
            tMapMarkerItem.setCanShowCallout(true); // 풍선뷰
            tMapMarkerItem.setCalloutTitle(parkingInfos.get(i).getPARKING_NAME());
            tMapMarkerItem.setCalloutSubTitle(parkingInfos.get(i).get현재_주차_차량수() + "/" + parkingInfos.get(i).get총_주차면());
            tMapMarkerItem.setCalloutLeftImage(bitmap);
            //tMapMarkerItem.setCalloutRightButtonImage(bitmap);
            tMapMarkerItem.setEnableClustering(true);
            markerId = "marker: " + parkingInfos.get(i).getPARKING_NAME();

            //add mark to maps
            tMapView.addMarkerItem(markerId, tMapMarkerItem);
        }
    }

    private void callServer() {
        parkingInfos = new ArrayList<>();
        parkingInfos.add(new ParkingInfo(1, "구로디지털 단지역", "주소입니다.", "노상주차장", "시간제 주차장", "TEL:010", true, 180, 90, "업데이트 시간", "유료", "야간 무료개방", "09:00", "18:00", "09:00", "16:00", "12:00", "18:00", "무료", "무료", 0, 1500, 60, 100, "60", 60000, 37.48497, 126.9012, "", "", false, "보통"));
        parkingInfos.add(new ParkingInfo(2, "올리브 모텔", "주소입니다.", "노상주차장", "시간제 주차장", "MOTEL:010", true, 34, 34, "업데이트 시간", "유료", "야간 개방 x", "09:00", "18:00", "09:00", "16:00", "12:00", "18:00", "무료", "무료", 100000, 10000, 5, 1000, "60", 60000, 37.48395, 126.9010, "", "", false, "적음"));
        parkingInfos.add(new ParkingInfo(3, "나이스파크 주차장", "주소입니다.", "노상주차장", "시간제 주차장", "MOTEL:010", true, 60, 10, "업데이트 시간", "유료", "야간 개방 x", "09:00", "18:00", "09:00", "16:00", "12:00", "18:00", "무료", "무료", 100000, 2000, 60, 150, "60", 60000, 37.48578, 126.9017, "", "", false, "많음"));
//        call = retrofit.getApiService().staticFindNearbyLocations();
//        call.enqueue(new Callback<List<ParkingInfo>>() {
//            @Override
//            public void onResponse(Call<List<ParkingInfo>> call, Response<List<ParkingInfo>> response) {
//                List<ParkingInfo> resultList = response.body();
//                for (ParkingInfo parkingInfo : resultList) {
//                    parkingInfos.add(parkingInfo);
//                }
//            }
//            @Override
//            public void onFailure(Call<List<ParkingInfo>> call, Throwable t) {
//                // 오류 처리
//            }
//        });
    };

    private void tMapViewInit() {
        linearLayoutTmap = findViewById(R.id.linearLayoutTmap);

        tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey(tApiKey);
        tMapView.setZoomLevel(16);
        tMapView.setIconVisibility(true);
        tMapView.setMapType(tMapView.MAPTYPE_STANDARD);
        tMapView.setLocationPoint(cur_lng, cur_lat);
        tMapView.setCenterPoint(cur_lng, cur_lat);

        linearLayoutTmap.addView(tMapView);
    }

    private void recyclerVieParking() {
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView = findViewById(R.id.view);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<ParkingInfo> parkingInfoArrayList = new ArrayList<>();

        for(int i = 0; i < parkingInfos.size(); i++) {
            parkingInfoArrayList.add(parkingInfos.get(i));
        }

        adapter = new ParkingInfoAdapter(parkingInfoArrayList);
        recyclerView.setAdapter(adapter);
    }
}