package com.app.daeja.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.daeja.Activity.Domain.ParkingInfo;
import com.app.daeja.Network.TestDomain;
import com.app.daeja.Network.retrofit;
import com.app.daeja.R;
import com.skt.Tmap.TMapView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import retrofit2.Response;


public class HomeFragment extends Fragment {
    TextView textview;

    private View view;
    private Context ct;

    //for server
    private Thread thread;
    private boolean isThread = false;
    Call<TestDomain> call;
    List<ParkingInfo> parkingInfos;

    //for tmap
    private LinearLayout linearLayoutTmap;
    private TMapView tMapView;
    private static final String tApiKey = "KbtV6K1LiCa2kYZ2ieDhU3pxBBS5A5gA5CL5O3el";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        ct = container.getContext();

        ArrayList<Integer> lineData = new ArrayList<>();
        lineData.add(1000);
        lineData.add(1100);
        lineData.add(1200);
        lineData.add(1100);

//        ParkingInfo parkingInfo = new ParkingInfo(12,"1234", "서울시 공영", "주차 잔여공간 많음", 80, 10, "150원/5분", 37.32335, 127.1276, lineData);
//        List<ParkingInfo> parkingInfos = new ArrayList<>();
//        parkingInfos.add(parkingInfo);
//        Log.e(parkingInfos.get(0).toString(), "sa\n\n\n\n\n\n\n\nf");

        //server
        //Create Thread
//        isThread = true;
//        thread = new Thread(){
//            public void run(){
//                while(!isThread){
//                    try {
//                        sleep(10000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    handler.sendEmptyMessage(0);
//
//                    callServer();
//                }
//            }
//        };
//        thread.start();

//        //create markers
//        TMapMarkerItem markerItem1 = new TMapMarkerItem();
//        TMapPoint tMapPoint1 = new TMapPoint((double)parkingInfos.get(0).getLatitude(), (double)parkingInfos.get(0).getLongitude());
//
//        //marker setting
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_red);
//        markerItem1.setIcon(bitmap);
//        markerItem1.setPosition(0.5f, 1.0f); // 마커의 중심점을 중앙, 하단으로 설정
//        markerItem1.setTMapPoint( tMapPoint1 );
//        markerItem1.setName(parkingInfos.get(0).getParkingNameTxt()); // 마커의 타이틀 지정
//        markerItem1.setCanShowCallout(true); // 풍선뷰
//        markerItem1.setCalloutTitle(parkingInfos.get(0).getParkingNameTxt());
//        markerItem1.setCalloutSubTitle((int)parkingInfos.get(0).getCurrentParking() + "/" + (int)parkingInfos.get(0).getTotalParking());
//        markerItem1.setCalloutLeftImage(bitmap);
//        //markerItem1.setCalloutRightButtonImage(bitmap);
//        //markerItem1.setEnableClustering(true);

//        try {
//            callServer();
//        } catch (JSONException e) {
//            throw new RuntimeException(e);
//        }


        //Todo[] todos = RestAssured.get("https://jsonplaceholder.typicode.com/todos").as(Todo[].class);




        //tmapview
        linearLayoutTmap = (LinearLayout) view.findViewById(R.id.linearLayoutTmap);

        tMapView = new TMapView(ct);
        tMapView.setSKTMapApiKey(tApiKey);
        tMapView.setZoomLevel(16);
        tMapView.setIconVisibility(true);
        tMapView.setMapType(tMapView.MAPTYPE_STANDARD);
        tMapView.setLocationPoint(127.1276, 37.32335);
        //add mark  maps
        //tMapView.addMarkerItem("markerItem1", markerItem1);

        linearLayoutTmap.addView(tMapView);

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }



    private void callServer() throws JSONException {
        textview = view.findViewById(R.id.hello);

        parkingInfos = new ArrayList<>();
        call = retrofit.getApiService().test_api_get();
        call.enqueue(new Callback<TestDomain>() {
            //콜백 받는 부분
            @Override
            public void onResponse(Call<TestDomain> call, Response<TestDomain> response) {
//                StringBuffer stringBuffer = new StringBuffer();
//                Gson gson = new Gson();
//                String jsonString = gson.toJson(response.body());
//                stringBuffer.append(jsonString);
//                String str = jsonString.toString();
                JSONArray jsonArray;
                try {
                    jsonArray = new JSONArray(response);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                JSONObject subJsonObject;
                try {
                    subJsonObject = jsonArray.getJSONObject(0);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                try {
                    textview.setText(subJsonObject.getString("asfd"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                //Map‹String, Object> emp1 = (Map‹String, Object>) allEmp.get(0);



//                OkHttpClient client = new OkHttpClient();
//                Request request = new Request.Builder().url("https://jsonplaceholder.typicode.com/").build();
////https://jsonplaceholder.typicode.com/todos
//                Type type = new TypeToken<ArrayList<TestDomain>>(){}.getType();
//                ArrayList<TestDomain> testDomains = gson.fromJson(str, type);

//                for (TestDomain parkingInfo: testDomains) {
//                    Integer total = (int) parkingInfo.getCapacity();
//                    Integer current = (int) parkingInfo.getCurParking();
//                    parkingInfos.add(new ParkingInfo(
//                            parkingInfo.getId(),
//                            parkingInfo.getParkingCode(),
//                            parkingInfo.getParkingName(),
//                            "",
//                            total,
//                            current,
//                            "",
//                            parkingInfo.getLat(),
//                            parkingInfo.getLng(),
//                            null
//                    ));
//                }
            };

            @Override
            public void onFailure(Call<TestDomain> call, Throwable t) {
//                System.out.println("onFailure");
//                Log.d(TAG, "onFailure "+t.getMessage());
            }
        });
    };

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            Toast.makeText(ct, "receive by server", Toast.LENGTH_SHORT).show();
        }
    };

}
