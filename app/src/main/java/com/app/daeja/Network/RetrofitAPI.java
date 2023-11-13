package com.app.daeja.Network;

import com.app.daeja.Activity.Domain.ParkingInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @GET("response/{parking_code}")
    Call<ParkingInfo> test_api_get(@Path("parking_code") String parking_code);

//    @GET("response")
    @GET("response")
    Call<List<ParkingInfo>> test_api_get_all();

    @GET("near")
    Call<List<ParkingInfo>> staticFindNearbyLocations();
}