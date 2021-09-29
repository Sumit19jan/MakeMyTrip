package com.example.makemytrip.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makemytrip.R;
import com.example.makemytrip.response.HotelDTO;
import com.example.makemytrip.viewHolder.TripIdeaOneViewHolder;
import com.example.makemytrip.viewHolder.WanderViewHolder;

import java.util.List;

public class WanderAdapter extends RecyclerView.Adapter<WanderViewHolder> {

    private List<HotelDTO> hotelDTOS;

    public WanderAdapter(List<HotelDTO> hotelDTOS) {
        this.hotelDTOS = hotelDTOS;
    }

    @NonNull
    @Override
    public WanderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_idea_traveller, parent, false);
        return new WanderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WanderViewHolder holder, int position) {
        HotelDTO hotelDTO = hotelDTOS.get(position);
        holder.setDataWander(hotelDTO);
    }

    @Override
    public int getItemCount() {
        return hotelDTOS.size();
    }
}
