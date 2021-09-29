package com.example.makemytrip.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makemytrip.R;
import com.example.makemytrip.response.HotelDTO;
import com.example.makemytrip.viewHolder.InterestOneViewHolder;
import com.example.makemytrip.viewHolder.TripIdeaOneViewHolder;

import java.util.List;

public class InterestAdapter extends RecyclerView.Adapter<InterestOneViewHolder> {

    private List<HotelDTO> hotelDTOS;

    public InterestAdapter(List<HotelDTO> hotelDTOS) {
        this.hotelDTOS = hotelDTOS;
    }

    @NonNull
    @Override
    public InterestOneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_idea_traveller, parent, false);
        return new InterestOneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InterestOneViewHolder holder, int position) {
        HotelDTO hotelDTO = hotelDTOS.get(position);
        holder.setDataInterest(hotelDTO);
    }

    @Override
    public int getItemCount() {
        return hotelDTOS.size();
    }
}
