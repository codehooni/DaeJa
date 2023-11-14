package com.app.daeja.Fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.daeja.Activity.Domain.ParkingInfo;
import com.app.daeja.Network.retrofit;
import com.app.daeja.R;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private View view;
    private Context ct;

    //for server
    Thread thread;
    boolean isThread;
    Call<List<ParkingInfo>> call;
    List<ParkingInfo> parkingInfos;

    //for tmap
    private LinearLayout linearLayoutTmap;
    private TMapView tMapView;
    private double cur_lat = 37.4849732;
    private double cur_lng = 126.9012370;
    private static final String tApiKey = "KbtV6K1LiCa2kYZ2ieDhU3pxBBS5A5gA5CL5O3el";


    //util
    Button btn;
    Button btn2;
    Button btn3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        ct = container.getContext();

        TMapViewInit();

        //thread
        btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(v -> {
            //Create Thread
            isThread = true;
            thread = new Thread(() -> {
                while(isThread){
                    handler.sendEmptyMessage(0);
                    callServer();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            thread.start();
        });

        btn2 = (Button) view.findViewById(R.id.btn2);
        btn2.setOnClickListener(v -> {
            isThread = false;
            tMapView.removeAllMarkerItem();
            pointPin();
        });

        btn3 = view.findViewById(R.id.btn3);
        btn3.setOnClickListener(v ->{
            tMapView.removeAllMarkerItem();
        });


        return view;
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
        parkingInfos.add(new ParkingInfo(1, 1, "구로디지털 단지역", "주소입니다.", "노외주차장", "시간제 주차장", "TEL:010", true, 180, 90, "업데이트 시간", "유료", "야간 무료개방", "09:00", "18:00", "09:00", "16:00", "12:00", "18:00", "무료", "무료", 0, "1500", "60", "", "60", 60000, 37.48497, 126.9012, "", "", false, "보통"));

        call = retrofit.getApiService().test_api_get_all();
        call.enqueue(new Callback<List<ParkingInfo>>() {
            @Override
            public void onResponse(Call<List<ParkingInfo>> call, Response<List<ParkingInfo>> response) {
                List<ParkingInfo> resultList = response.body();
//                for (ParkingInfo parkingInfo : resultList) {
//                    parkingInfos.add(parkingInfo);
//                }
            }
            @Override
            public void onFailure(Call<List<ParkingInfo>> call, Throwable t) {
                // 오류 처리
            }
        });
    };

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            Toast.makeText(ct, "receive by server", Toast.LENGTH_SHORT).show();
        }
    };

    private void TMapViewInit(){
        linearLayoutTmap = view.findViewById(R.id.linearLayoutTmap);

        tMapView = new TMapView(ct);
        tMapView.setSKTMapApiKey(tApiKey);
        tMapView.setZoomLevel(14);
        tMapView.setIconVisibility(true);
        tMapView.setMapType(tMapView.MAPTYPE_STANDARD);
        tMapView.setLocationPoint(126.9005, 37.48113 );
        tMapView.setCenterPoint(cur_lng, cur_lat);


        linearLayoutTmap.addView(tMapView);
    }
}
