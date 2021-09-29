package com.example.makemytrip.apiClient;

import com.example.makemytrip.response.FlightResponseDTO;
import com.example.makemytrip.response.OfferResponseDTO;
import com.example.makemytrip.response.ResponseDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClient {

    @GET("Sumit19jan/ced8c956cddf46b48b865dac577e0289/raw/12df743b7f402507ea45cc7fc34aa9d4fa1acfb5/hotel_json")
    Call<ResponseDTO> getHotelResponse();

    @GET("Sumit19jan/198820137e591df00376b76ac046a13b/raw/fd730eb6f9464ce3bd919468a4156996a86f1228/flightGist")
    Call<List<FlightResponseDTO>> getFlightResponse();

    @GET("Sumit19jan/6cbbf39ed036e9bafd507236a0eaa581/raw/670e0378e12597219102aeac659af374766081ed/offersApi")
    Call<List<OfferResponseDTO>> getOffers();
}
