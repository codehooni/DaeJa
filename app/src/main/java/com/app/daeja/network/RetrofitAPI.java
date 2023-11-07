package com.app.daeja.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @GET("response/{id}")
    Call<TestDomain> test_api_get(@Path("id") String id);


}
