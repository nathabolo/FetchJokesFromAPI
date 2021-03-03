package com.example.fetchjokesfromapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import adapter.JokesAdapter;
import client.RetrofitApiClient;
import model.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements JokesAdapter.ClickedItem{

    Toolbar toolbar;
    RecyclerView recyclerView;
    JokesAdapter jokesAdapter;
    TextView tvHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.androidToolBar);
        recyclerView = findViewById(R.id.recyclerview);
        tvHeader = findViewById(R.id.tvHeader);

        tvHeader.setAllCaps(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        jokesAdapter = new JokesAdapter(this::ClickedJokeItem);
        getRandomJokes();
    }

    public void getRandomJokes(){
        Call<ApiResponse> apiResponseList = RetrofitApiClient.getUserService().getAllJokes();
        apiResponseList.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()){
                    ApiResponse apiResponses = response.body();
                    jokesAdapter.provideData(apiResponses);
                    recyclerView.setAdapter(jokesAdapter);
                    Log.e("Call to api successful", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

                Log.e("Call to api failed", t.getLocalizedMessage());
            }
        });

    }

    @Override
    public void ClickedJokeItem(ApiResponse apiResponse) {
        startActivity(new Intent(this, JokesDetailsActivity.class).putExtra("data", apiResponse));
        Log.e("You clicked a joke item", apiResponse.toString());
    }
}
