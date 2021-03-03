package com.example.fetchjokesfromapi;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import model.ApiResponse;

public class JokesDetailsActivity extends AppCompatActivity {

    TextView tvUrl, value, tvHeader;
    ApiResponse apiResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_details);

        tvUrl = findViewById(R.id.tvUrl);
        value = findViewById(R.id.value);
        tvHeader = findViewById(R.id.tvHeader);
        tvHeader.setAllCaps(true);


        Intent intent = getIntent();
        if (intent.getExtras() != null){
            apiResponse = (ApiResponse) intent.getSerializableExtra("data");

            String joketvUrl = apiResponse.getUrl();
            String jokevalue = apiResponse.getValue();

            tvUrl.setText(joketvUrl);
            value.setText(jokevalue);

        }

    }
}
