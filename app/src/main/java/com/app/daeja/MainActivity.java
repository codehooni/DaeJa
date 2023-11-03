package com.app.daeja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.app.daeja.ui.history.HistoryActivity;
import com.app.daeja.ui.setting.SettingActivity;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawerView;
    private LinearLayout linearLayoutTmap;
    TMapView tMapView;
    private static final String tApiKey = "KbtV6K1LiCa2kYZ2ieDhU3pxBBS5A5gA5CL5O3el";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawer);
        Button btn_open = (Button) findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        LinearLayout ll_home = (LinearLayout) findViewById(R.id.ll_home);
        ll_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });

        ImageView img_recomend = (ImageView) findViewById(R.id.img_recomend);
        img_recomend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "not be implemented", Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout ll_history = (LinearLayout) findViewById(R.id.ll_history);
        ll_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout ll_setting = (LinearLayout) findViewById(R.id.ll_setting);
        ll_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout ll_logout = (LinearLayout) findViewById(R.id.ll_logout);
        ll_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "not be implemented", Toast.LENGTH_SHORT).show();
            }
        });


        //tmap-related parts
        linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);

        //create markers
        TMapMarkerItem markerItem1 = new TMapMarkerItem();
        TMapPoint tMapPoint1 = new TMapPoint(37.32160, 127.1267); // 단국대학교 핀

        //marker setting
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.poi_dot);
        markerItem1.setIcon(bitmap);
        markerItem1.setPosition(0.5f, 1.0f); // 마커의 중심점을 중앙, 하단으로 설정
        markerItem1.setTMapPoint( tMapPoint1 );
        markerItem1.setName("단국대학교"); // 마커의 타이틀 지정
        markerItem1.setCanShowCallout(true); // 풍선뷰
        markerItem1.setCalloutTitle("단국대학교");
        markerItem1.setCalloutSubTitle("180 / 200");
        markerItem1.setCalloutLeftImage(bitmap);
        //markerItem1.setCalloutRightButtonImage(bitmap);
        //markerItem1.setEnableClustering(true);

        //tMapView setting
        tMapView = new TMapView(this);
        tMapView.setCenterPoint(127.1267, 37.32160, true); //단국대학교: 37.32166, 127.1267
        tMapView.setSKTMapApiKey( tApiKey );
        tMapView.setZoomLevel(16);
        //add mark  maps
        tMapView.addMarkerItem("markerItem1", markerItem1); // 지도에 마커 추가

        linearLayoutTmap.addView( tMapView );
    }

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

