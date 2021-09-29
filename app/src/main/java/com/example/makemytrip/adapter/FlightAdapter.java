package com.example.makemytrip.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makemytrip.R;
import com.example.makemytrip.response.FlightResponseDTO;
import com.example.makemytrip.viewHolder.FlightViewHolder;

import java.util.List;

public class FlightAdapter extends RecyclerView.Adapter<FlightViewHolder> {
    private List<FlightResponseDTO> flightResponseDTOS;

    public FlightAdapter(List<FlightResponseDTO> flightResponseDTOS) {
        this.flightResponseDTOS = flightResponseDTOS;
    }

    @NonNull
    @Override
    public FlightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_item_layout,parent,false);
        return new FlightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightViewHolder holder, int position) {
        FlightResponseDTO flightResponseDTO = flightResponseDTOS.get(position);
        holder.setData(flightResponseDTO);
    }

    @Override
    public int getItemCount() {
        return flightResponseDTOS.size();
    }
}
