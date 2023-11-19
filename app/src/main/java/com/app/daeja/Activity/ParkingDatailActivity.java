package com.app.daeja.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.app.daeja.R;

public class ParkingDatailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_datail);

//        init();

//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");
//        String subName = intent.getStringExtra("subName");
//        String address = intent.getStringExtra("address");
//        String tel = intent.getStringExtra("tel");

//        tv_park_name.setText(name);
//        tv_addr.setText(address);
//        telTxt.setText(tel);
//        img_path.setOnClickListener(v -> {
//            String curLoc = getCurloc();
//            histories.add(new History(curLoc, name));
//        });

    }

//    private String getCurloc() {
//        try {
//            final String address = new TMapData().convertGpsToAddress(recomendActivity.getCur_lat(), recomendActivity.getCur_lng());
//            return address;
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//        return "default";
//    }
//
//    private void init() {
//        tv_loc_name = findViewById(R.id.tv_loc_name);
//        tv_sub_name = findViewById(R.id.tv_sub_name);
//        tv_addr = findViewById(R.id.tv_addr);
//        telTxt = findViewById(R.id.telTxt);
//        img_path = findViewById(R.id.img_path);
//    }

}