package com.example.makemytrip.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makemytrip.R;
import com.example.makemytrip.response.OfferResponseDTO;
import com.example.makemytrip.viewHolder.FlightImageViewHolder;
import com.example.makemytrip.viewHolder.TrendingViewHolder;

import java.util.List;

public class FlightImageAdapter extends RecyclerView.Adapter<FlightImageViewHolder> {

    private List<OfferResponseDTO> offerResponseDTOS;

    public FlightImageAdapter(List<OfferResponseDTO> offerResponseDTOS) {
        this.offerResponseDTOS = offerResponseDTOS;
    }

    @NonNull
    @Override
    public FlightImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_item_layout, parent, false);
        return new FlightImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightImageViewHolder holder, int position) {
        OfferResponseDTO offerResponseDTO = offerResponseDTOS.get(position);
        holder.setData(offerResponseDTO);
    }

    @Override
    public int getItemCount() {
        return offerResponseDTOS.size();
    }
}
