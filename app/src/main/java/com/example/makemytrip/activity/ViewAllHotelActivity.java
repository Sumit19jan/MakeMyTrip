package com.example.makemytrip.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.makemytrip.R;
import com.example.makemytrip.adapter.HotelAdapter;
import com.example.makemytrip.apiClient.ApiClient;
import com.example.makemytrip.network.Network;
import com.example.makemytrip.response.HotelDTO;
import com.example.makemytrip.response.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewAllHotelActivity extends AppCompatActivity {

    private RecyclerView recyclerView_ViewAllHotelActivity;
    private List<HotelDTO> hotelDTOS = new ArrayList<>();
    private HotelAdapter hotelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_hotel);
        recyclerView_ViewAllHotelActivity = findViewById(R.id.recyclerView_ViewAllHotelActivity);
        buildData();
    }

    private void buildData() {
        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        apiClient.getHotelResponse().enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                if (response.body() != null) {
                    hotelDTOS = response.body().getHotel();
                    setRecycler();
                }
            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {

            }
        });
    }

    private void setRecycler() {
        hotelAdapter = new HotelAdapter(hotelDTOS);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView_ViewAllHotelActivity.setLayoutManager(linearLayoutManager);
        recyclerView_ViewAllHotelActivity.setAdapter(hotelAdapter);
    }
}