package com.example.makemytrip.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.makemytrip.R;
import com.example.makemytrip.activity.FlightActivity;
import com.example.makemytrip.activity.HotelAndHomestaysActivity;
import com.example.makemytrip.activity.ViewAllHotelActivity;
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

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private TextView mTvViewAll;
    private List<HotelDTO> hotelDTOS = new ArrayList<>();
    private ImageView mIvHotel;
    private ImageView mIvHomestays;
    private ImageView mIvFlight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        callAPI();
    }

    private void callAPI() {
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
        HotelAdapter hotelAdapter = new HotelAdapter(hotelDTOS);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(hotelAdapter);
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_hotel_homeFragment);
        mTvViewAll = view.findViewById(R.id.tv_ViewAll_HomeFragment);
        mIvHotel = view.findViewById(R.id.iv_Hotel_HomeFragment);
        mIvFlight = view.findViewById(R.id.iv_Flight_HomeFragment);
        mIvHomestays = view.findViewById(R.id.iv_HomeStays_HomeFragment);
        mIvHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HotelAndHomestaysActivity.class);
                startActivity(intent);
            }
        });

        mIvHomestays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HotelAndHomestaysActivity.class);
                startActivity(intent);
            }
        });
        mTvViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ViewAllHotelActivity.class);
                startActivity(intent);
            }
        });
        mIvFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FlightActivity.class);
                startActivity(intent);
            }
        });
    }
}