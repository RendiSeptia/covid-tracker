package com.rendi.covidtrackerapp.network;

import com.rendi.covidtrackerapp.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("v2/all")
    Call<MainModel> getData();
}
