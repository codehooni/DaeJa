package com.app.daeja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

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

import com.app.daeja.network.TestDomain;
import com.app.daeja.network.retrofit;
import com.app.daeja.ui.history.HistoryActivity;
import com.app.daeja.ui.setting.SettingActivity;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

import static android.content.ContentValues.TAG;

import static java.lang.Thread.sleep;

import android.util.Log;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawerView;
    private ImageView img_reset;
    private LinearLayout linearLayoutTmap;
    TMapView tMapView;
    private static final String tApiKey = "KbtV6K1LiCa2kYZ2ieDhU3pxBBS5A5gA5CL5O3el";
    Call <TestDomain> call;
    TextView textView;

    //요청 받을 변수
    int id;
    String parkingCode;
    String parkingName;
    int capacity;
    int curParking;
    double lat;
    double lng;

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

        ImageView img_recomend = (ImageView) findViewById(R.id.img_reset);
        img_recomend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "not be implemented", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView img_search = (ImageView) findViewById(R.id.img_search);
        img_search.setOnClickListener(new View.OnClickListener() {
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

        // 변경점
        call = retrofit.getApiService().test_api_get("26");
        call.enqueue(new Callback<TestDomain>() {
            //콜백 받는 부분
            @Override
            public void onResponse(Call<TestDomain> call, Response<TestDomain> response) {
                System.out.println("onResponse");
                TestDomain result = response.body();

                id = result.getId();
                parkingCode = result.getParkingCode();
                parkingName = result.getParkingName();
                capacity = (int) result.getCapacity();
                curParking = (int) result.getCurParking();
                lat = result.getLat();
                lng = result.getLng();

            }

            @Override
            public void onFailure(Call<TestDomain> call, Throwable t) {
                System.out.println("onFailure");
                Log.d(TAG, "onFailure "+t.getMessage());
            }
        });

        //tmap-related parts
        linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);

        img_reset = (ImageView) findViewById(R.id.img_reset);
        img_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        id = 26;
        parkingCode = "ㅇㅇ";
        parkingName = "단국대학교 야외 주차장";
        capacity = (int) 80;
        curParking = (int) 55;
        //37.32335, 127.1276
        lat = 37.32335;
        lng = 127.1276;

        //create markers
        TMapMarkerItem markerItem1 = new TMapMarkerItem();
        TMapPoint tMapPoint1 = new TMapPoint(lat, lng); // 단국대학교 핀

        //marker setting
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.destination);
        markerItem1.setIcon(bitmap);
        markerItem1.setPosition(0.5f, 1.0f); // 마커의 중심점을 중앙, 하단으로 설정
        markerItem1.setTMapPoint( tMapPoint1 );
        markerItem1.setName(parkingName); // 마커의 타이틀 지정
        markerItem1.setCanShowCallout(true); // 풍선뷰
        markerItem1.setCalloutTitle(parkingName);
        markerItem1.setCalloutSubTitle( curParking + "/" + capacity);
        markerItem1.setCalloutLeftImage(bitmap);
        //markerItem1.setCalloutRightButtonImage(bitmap);
        //markerItem1.setEnableClustering(true);


        // 변경점



        //tMapView setting
        tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey( tApiKey );
        tMapView.setZoomLevel(16);
        tMapView.setLocationPoint(lng, lat);
        //add mark  maps
        //tMapView.addMarkerItem("markerItem1", markerItem1); // 지도에 마커 추가

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

