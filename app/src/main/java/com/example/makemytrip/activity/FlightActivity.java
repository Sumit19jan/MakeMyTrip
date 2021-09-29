package com.example.makemytrip.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.makemytrip.R;

public class FlightActivity extends AppCompatActivity {

    private Button mBtnSearchFlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);
        mBtnSearchFlight = findViewById(R.id.btnSearchFlight);
        mBtnSearchFlight.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlightActivity.this, LaunchFlightActivity.class);
                startActivity(intent);
            }
        });
    }
}