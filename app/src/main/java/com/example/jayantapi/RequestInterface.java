package com.example.jayantapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface{

    @GET("cardData")
    Call<List<Example>> getJSON();

}