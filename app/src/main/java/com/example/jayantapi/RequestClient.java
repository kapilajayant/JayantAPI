package com.example.jayantapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestClient {

    public static Retrofit retrofit = null;

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://demo8716682.mockable.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
