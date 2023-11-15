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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.daeja.Activity.Domain.ParkingInfo;
import com.app.daeja.Network.retrofit;
import com.app.daeja.R;
import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;
import com.skt.Tmap.poi_item.TMapPOIItem;

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
    ImageView img_search;
    EditText search_barEt;
    String str_search;

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
                    callServer();
                    handler.sendEmptyMessage(0);
                    tMapView.removeAllMarkerItem();
                    pointPin();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    handler.sendEmptyMessage(0);
                    pointPin();
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

        img_search = view.findViewById(R.id.img_search);
        search_barEt = view.findViewById(R.id.search_barEt);
        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_search = search_barEt.getText().toString();
                tMapView.removeAllMarkerItem();

                ArrayList<String> poiKeywords = new ArrayList<>();
                poiKeywords.add(str_search);

                searchPOI(poiKeywords);

                pointPin();
            }
        });



        return view;
    }

    private Bitmap createMarkerIcon(int image)  // 이미지 크기조정
    {
        Bitmap bitmap = BitmapFactory.decodeResource(ct.getApplicationContext().getResources(),
                image);
        bitmap = Bitmap.createScaledBitmap(bitmap, 100, 100,false);

        return bitmap;
    }

    private void setMultiMarkers(ArrayList<TMapPoint> Point, ArrayList<String> Name,
                                 ArrayList<String> Address)
    {
        for( int i = 0; i < Point.size(); i++ )
        {
            Bitmap bitmapIcon = createMarkerIcon(R.drawable.ic_green);

            TMapMarkerItem tMapMarkerItem = new TMapMarkerItem();
            tMapMarkerItem.setIcon(bitmapIcon);

            tMapMarkerItem.setTMapPoint(Point.get(i));

            tMapView.addMarkerItem("markerItem" + i, tMapMarkerItem);
            //setBalloonView(tMapMarkerItem, Name.get(i), Address.get(i));

        }
    }

    private void searchPOI(ArrayList<String> arrPOI)
    {
        final TMapData tMapData = new TMapData();
        final ArrayList<TMapPoint> Point = new ArrayList<>();
        final ArrayList<String> Name = new ArrayList<>();
        final ArrayList<String> Address = new ArrayList<>();

        for(int i = 0; i < arrPOI.size(); i++ )
        {
            tMapData.findTitlePOI(arrPOI.get(i), new TMapData.FindTitlePOIListenerCallback()
            {
                @Override
                public void onFindTitlePOI(ArrayList<TMapPOIItem> arrayList)
                {
                    for(int j = 0; j < arrayList.size(); j++ )
                    {
                        TMapPOIItem tMapPOIItem = arrayList.get(j);
                        Point.add(tMapPOIItem.getPOIPoint());
                        Name.add(tMapPOIItem.getPOIName());
                        Address.add(tMapPOIItem.upperAddrName + " " +
                                tMapPOIItem.middleAddrName + " " + tMapPOIItem.lowerAddrName);
                    }
                    setMultiMarkers(Point, Name, Address);
                }
            });
        }
    }

    private void pointPin() {

        for(int i = 0; i < parkingInfos.size(); i++){
            TMapMarkerItem tMapMarkerItem = new TMapMarkerItem();
            TMapPoint tMapPoint = new TMapPoint(parkingInfos.get(i).getLat(), parkingInfos.get(i).getLng());
            String markerId;
            Bitmap bitmap;

            //marker setting
            if(parkingInfos.get(i).getColor().equals("많음")){
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_green);
            }else if (parkingInfos.get(i).getColor().equals("보통")){
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_yellow);
            }else if (parkingInfos.get(i).getColor().equals("적음")){
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
            tMapMarkerItem.setCalloutSubTitle(parkingInfos.get(i).getCur_PARKING() + "/" + parkingInfos.get(i).getCapacity());
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

        call = retrofit.getApiService().test_api_get_reset();
        call.enqueue(new Callback<List<ParkingInfo>>() {
            @Override
            public void onResponse(Call<List<ParkingInfo>> call, Response<List<ParkingInfo>> response) {
            }
            @Override
            public void onFailure(Call<List<ParkingInfo>> call, Throwable t) {
            }
        });
        try {
            Thread.sleep(30000);
            //Thread.sleep(150000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        call = retrofit.getApiService().test_api_get_all();
        call.enqueue(new Callback<List<ParkingInfo>>() {
            @Override
            public void onResponse(Call<List<ParkingInfo>> call, Response<List<ParkingInfo>> response) {
                List<ParkingInfo> resultList = response.body();

                for (ParkingInfo parkingInfo : resultList) {
                    parkingInfos.add(parkingInfo);
                }
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

    private void setBalloonView(TMapMarkerItem marker, String title, String address)
    {
        marker.setCanShowCallout(true);

        if( marker.getCanShowCallout() )
        {
            marker.setCalloutTitle(title);
            marker.setCalloutSubTitle(address);

            Bitmap bitmap = createMarkerIcon(R.drawable.ic_green);
            marker.setCalloutRightButtonImage(bitmap);
        }
    }
}
