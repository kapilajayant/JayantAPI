package com.example.jayantapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<Example> data;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_rv);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }
    private void loadJSON(){

        RequestInterface request = RequestClient.getClient().create(RequestInterface.class);
        Call<List<Example>> call = request.getJSON();
        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {

                List<Example> example = response.body();

//                String url=model.get(0).getUrl();
//                String name=model.get(0).getName();
//                String location=model.get(0).getLocation();
//                String age=model.get(0).getAge();
//
//
                adapter = new DataAdapter(example);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}
