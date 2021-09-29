package com.example.makemytrip.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.makemytrip.R;
import com.example.makemytrip.adapter.FlightAdapter;
import com.example.makemytrip.apiClient.ApiClient;
import com.example.makemytrip.network.Network;
import com.example.makemytrip.response.FlightResponseDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaunchFlightActivity extends AppCompatActivity {

    private List<FlightResponseDTO> flightResponseDTOS = new ArrayList<>();
    private FlightAdapter flightAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_flight);
        recyclerView = findViewById(R.id.recyclerView_LaunchFlightActivity);
        callAPI();
    }

    private void callAPI() {
        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        apiClient.getFlightResponse().enqueue(new Callback<List<FlightResponseDTO>>() {
            @Override
            public void onResponse(Call<List<FlightResponseDTO>> call, Response<List<FlightResponseDTO>> response) {
                if (response.body() != null) {
                    flightResponseDTOS = response.body();
                    setRecycler();
                }
            }

            @Override
            public void onFailure(Call<List<FlightResponseDTO>> call, Throwable t) {

            }
        });
    }

    private void setRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        flightAdapter = new FlightAdapter(flightResponseDTOS);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(flightAdapter);
    }
}