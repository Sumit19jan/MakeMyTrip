package com.example.makemytrip.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.makemytrip.R;
import com.example.makemytrip.adapter.CabsAdapter;
import com.example.makemytrip.adapter.FlightImageAdapter;
import com.example.makemytrip.adapter.HotelAdapter;
import com.example.makemytrip.adapter.TraindingAdapter;
import com.example.makemytrip.adapter.TrainsAdapter;
import com.example.makemytrip.adapter.VillaAdapter;
import com.example.makemytrip.apiClient.ApiClient;
import com.example.makemytrip.network.Network;
import com.example.makemytrip.response.HotelDTO;
import com.example.makemytrip.response.OfferResponseDTO;
import com.example.makemytrip.response.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OffersFragment extends Fragment implements View.OnClickListener {

    private Button mBtnWelcome;
    private Button mBtnTrending;
    private Button mBtnFlight;
    private Button mBtnHotel;
    private Button mBtnVilla;
    private Button mBtnCabs;
    private Button mBtnTrains;
    private RecyclerView recyclerView;
    private List<HotelDTO> hotelDTOS = new ArrayList<>();
    private List<OfferResponseDTO> offerResponseDTOS = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_OffersFragment);
        callAPI();
        initViews(view);
    }

    private void initViews(View view) {
        mBtnWelcome = view.findViewById(R.id.btnWelcome_OffersFragment);
        mBtnTrending = view.findViewById(R.id.btnTrending_OffersFragment);
        mBtnFlight = view.findViewById(R.id.btnFlight_OffersFragment);
        mBtnHotel = view.findViewById(R.id.btnHotels_OffersFragment);
        mBtnVilla = view.findViewById(R.id.btnVillas_OffersFragment);
        mBtnCabs = view.findViewById(R.id.btnCabs_OffersFragment);
        mBtnTrains = view.findViewById(R.id.btnTrains_OffersFragment);

        mBtnWelcome.setOnClickListener(this::onClick);
        mBtnTrending.setOnClickListener(this::onClick);
        mBtnFlight.setOnClickListener(this::onClick);
        mBtnHotel.setOnClickListener(this::onClick);
        mBtnVilla.setOnClickListener(this::onClick);
        mBtnCabs.setOnClickListener(this::onClick);
        mBtnTrains.setOnClickListener(this::onClick);
    }

    public void callAPIHotel() {
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
        HotelAdapter hotelAdapter = new HotelAdapter(hotelDTOS);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(hotelAdapter);
    }

    public void callAPI() {
        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        apiClient.getOffers().enqueue(new Callback<List<OfferResponseDTO>>() {
            @Override
            public void onResponse(Call<List<OfferResponseDTO>> call, Response<List<OfferResponseDTO>> response) {
                if (response.body() != null) {
                    offerResponseDTOS = response.body();
                    setOfferRecycler();
                }
            }

            @Override
            public void onFailure(Call<List<OfferResponseDTO>> call, Throwable t) {

            }
        });
    }

    private void setOfferRecycler() {
        TraindingAdapter traindingAdapter = new TraindingAdapter(offerResponseDTOS);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(traindingAdapter);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnWelcome_OffersFragment:
                callAPIHotel();
                break;
            case R.id.btnTrending_OffersFragment:
                callAPI();
                break;
            case R.id.btnFlight_OffersFragment:
                callAPIFlight();
                break;
            case R.id.btnHotels_OffersFragment:
                callAPIHotel();
                break;
            case R.id.btnVillas_OffersFragment:
                callAPIVillas();
                break;
            case R.id.btnTrains_OffersFragment:
                callAPITrains();
                break;
            case R.id.btnCabs_OffersFragment:
                callAPICabs();
        }
    }

    private void callAPICabs() {
        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        apiClient.getOffers().enqueue(new Callback<List<OfferResponseDTO>>() {
            @Override
            public void onResponse(Call<List<OfferResponseDTO>> call, Response<List<OfferResponseDTO>> response) {
                if (response.body() != null) {
                    offerResponseDTOS = response.body();
                    setOfferCabsRecycler();
                }
            }

            @Override
            public void onFailure(Call<List<OfferResponseDTO>> call, Throwable t) {

            }
        });
    }

    private void setOfferCabsRecycler() {
        CabsAdapter flightImageAdapter = new CabsAdapter(offerResponseDTOS);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(flightImageAdapter);
    }

    private void callAPITrains() {
        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        apiClient.getOffers().enqueue(new Callback<List<OfferResponseDTO>>() {
            @Override
            public void onResponse(Call<List<OfferResponseDTO>> call, Response<List<OfferResponseDTO>> response) {
                if (response.body() != null) {
                    offerResponseDTOS = response.body();
                    setOfferTrainsRecycler();
                }
            }

            @Override
            public void onFailure(Call<List<OfferResponseDTO>> call, Throwable t) {

            }
        });
    }

    private void setOfferTrainsRecycler() {
        TrainsAdapter flightImageAdapter = new TrainsAdapter(offerResponseDTOS);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(flightImageAdapter);
    }



    private void callAPIVillas() {
        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        apiClient.getOffers().enqueue(new Callback<List<OfferResponseDTO>>() {
            @Override
            public void onResponse(Call<List<OfferResponseDTO>> call, Response<List<OfferResponseDTO>> response) {
                if (response.body() != null) {
                    offerResponseDTOS = response.body();
                    setOfferVillasRecycler();
                }
            }

            @Override
            public void onFailure(Call<List<OfferResponseDTO>> call, Throwable t) {

            }
        });
    }

    private void setOfferVillasRecycler() {
        VillaAdapter flightImageAdapter = new VillaAdapter(offerResponseDTOS);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(flightImageAdapter);
    }

    private void callAPIFlight() {
        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        apiClient.getOffers().enqueue(new Callback<List<OfferResponseDTO>>() {
            @Override
            public void onResponse(Call<List<OfferResponseDTO>> call, Response<List<OfferResponseDTO>> response) {
                if (response.body() != null) {
                    offerResponseDTOS = response.body();
                    setOfferFlightRecycler();
                }
            }

            @Override
            public void onFailure(Call<List<OfferResponseDTO>> call, Throwable t) {

            }
        });
    }

    private void setOfferFlightRecycler() {
        FlightImageAdapter flightImageAdapter = new FlightImageAdapter(offerResponseDTOS);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(flightImageAdapter);
    }
}