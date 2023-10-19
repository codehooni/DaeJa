package com.app.daeja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.skt.Tmap.TMapView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayoutTmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        TMapView tMapView = new TMapView(this);

        tMapView.setSKTMapApiKey( "KbtV6K1LiCa2kYZ2ieDhU3pxBBS5A5gA5CL5O3el" );
        linearLayoutTmap.addView( tMapView );
    }
}