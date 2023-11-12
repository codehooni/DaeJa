package com.app.daeja.Network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
    //@GET("response/{name}")
    @GET("comments")

    //Call<TestDomain> test_api_get(@Path("id") String id);
    //Call<TestDomain> test_api_get(@Path("name") String id);
    Call<TestDomain> test_api_get();
}