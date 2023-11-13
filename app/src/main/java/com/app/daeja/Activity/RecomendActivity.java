package com.app.daeja.Activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.daeja.Activity.Domain.ParkingInfo;
import com.app.daeja.Adapter.ParkingInfoAdapter;
import com.app.daeja.R;
import com.app.daeja.Thread.CallAndPointThread;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;
import java.util.List;

public class RecomendActivity extends AppCompatActivity {

    Thread thread;

    protected RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private LinearLayout linearLayoutTmap;
    List<ParkingInfo> parkingInfos;
    TMapView tMapView;
    private static final String tApiKey = "KbtV6K1LiCa2kYZ2ieDhU3pxBBS5A5gA5CL5O3el";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomend);

        tMapViewInit();

        thread = new CallAndPointThread("쓰래드 클래스 사용", this, parkingInfos, tMapView);
        thread.start();

        recyclerVieParking();

    }

    private void tMapViewInit() {
        linearLayoutTmap = findViewById(R.id.linearLayoutTmap);

        tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey(tApiKey);
        tMapView.setZoomLevel(16);
        tMapView.setIconVisibility(true);
        tMapView.setMapType(tMapView.MAPTYPE_STANDARD);
        tMapView.setLocationPoint(127.1276, 37.32335);

        linearLayoutTmap.addView(tMapView);
    }

    private void recyclerVieParking() {
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView = findViewById(R.id.view);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<ParkingInfo> parkingInfoArrayList = new ArrayList<>();

        //parkingInfoArrayList.add(new ParkingInfo(23, "1234124","서울시 공영", "주차 잔여공간 많음", 80, 10, "150원/5분", 234.234, 4234.345, "G"));

        adapter = new ParkingInfoAdapter(parkingInfoArrayList);
        recyclerView.setAdapter(adapter);
    }
}