package com.app.daeja.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.daeja.Activity.Domain.ParkingInfo;
import com.app.daeja.R;
import com.app.daeja.Thread.CallAndPointThread;
import com.skt.Tmap.TMapView;

import java.util.List;

public class HomeFragment extends Fragment {

    private View view;
    private Context ct;

    //for server
    CallAndPointThread thread;
    List<ParkingInfo> parkingInfos;

    //for tmap
    private LinearLayout linearLayoutTmap;
    private TMapView tMapView;
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
        thread = new CallAndPointThread("쓰래드 클래스 사용", ct, parkingInfos, tMapView);
        thread.start();

        return view;
    }

    private void TMapViewInit(){
        linearLayoutTmap = view.findViewById(R.id.linearLayoutTmap);

        tMapView = new TMapView(ct);
        tMapView.setSKTMapApiKey(tApiKey);
        tMapView.setZoomLevel(14);
        tMapView.setIconVisibility(true);
        tMapView.setMapType(tMapView.MAPTYPE_STANDARD);
        tMapView.setLocationPoint(127.1276, 37.32335);

        linearLayoutTmap.addView(tMapView);
    }
}
