package com.rendi.covidtrackerapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static String BASE_URL = "https://corona.lmao.ninja/";
    private static Retrofit retrofit = null;
    public static ApiEndpoint endpoint(){

        retrofit = new Retrofit.Builder()
                .baseUrl( BASE_URL )
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit.create( ApiEndpoint.class );
    }
}
