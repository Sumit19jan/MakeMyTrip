package com.example.makemytrip.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.makemytrip.R;
import com.example.makemytrip.adapter.InterestAdapter;
import com.example.makemytrip.adapter.MountainAdapter;
import com.example.makemytrip.adapter.TripAdapter;
import com.example.makemytrip.adapter.WanderAdapter;
import com.example.makemytrip.apiClient.ApiClient;
import com.example.makemytrip.network.Network;
import com.example.makemytrip.response.HotelDTO;
import com.example.makemytrip.response.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TripIdeasFragment extends Fragment {

    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private RecyclerView recyclerView4;
    private RecyclerView recyclerView6;
    private List<HotelDTO> hotelDTOS = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trip_ideas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        callAPI1();
    }

    private void callAPI1() {
        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        apiClient.getHotelResponse().enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                if (response.body() != null) {
                    hotelDTOS = response.body().getHotel();
                    setRecyler();
                }
            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {

            }
        });
    }

    private void setRecyler() {
        TripAdapter tripAdapter = new TripAdapter(hotelDTOS);
        MountainAdapter mountainAdapter = new MountainAdapter(hotelDTOS);
        WanderAdapter wanderAdapter = new WanderAdapter(hotelDTOS);
        InterestAdapter interestAdapter = new InterestAdapter(hotelDTOS);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView2.setLayoutManager(linearLayoutManager1);
        recyclerView3.setLayoutManager(linearLayoutManager2);
        recyclerView4.setLayoutManager(linearLayoutManager3);
        recyclerView6.setLayoutManager(gridLayoutManager);
        recyclerView1.setAdapter(tripAdapter);
        recyclerView2.setAdapter(mountainAdapter);
        recyclerView3.setAdapter(wanderAdapter);
        recyclerView4.setAdapter(interestAdapter);
        recyclerView6.setAdapter(tripAdapter);
    }

    private void initViews(View view) {
        recyclerView1 = view.findViewById(R.id.recycler1_TripIdeasFragment);
        recyclerView2 = view.findViewById(R.id.recycler2_TripIdeasFragment);
        recyclerView3 = view.findViewById(R.id.recycler3_TripIdeasFragment);
        recyclerView4 = view.findViewById(R.id.recycler4_TripIdeasFragment);
        recyclerView6 = view.findViewById(R.id.recycler6_TripIdeasFragment);
    }
}