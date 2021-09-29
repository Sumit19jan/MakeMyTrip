package com.example.makemytrip.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makemytrip.R;
import com.example.makemytrip.response.OfferResponseDTO;
import com.example.makemytrip.viewHolder.TrendingViewHolder;
import com.example.makemytrip.viewHolder.WelcomeViewHolder;

import java.util.List;

public class WelcomeAdapter extends RecyclerView.Adapter<TrendingViewHolder> {

    private List<OfferResponseDTO> offerResponseDTOS;

    public WelcomeAdapter(List<OfferResponseDTO> offerResponseDTOS) {
        this.offerResponseDTOS = offerResponseDTOS;
    }

    @NonNull
    @Override
    public TrendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_item_layout, parent, false);
        return new TrendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingViewHolder holder, int position) {
        OfferResponseDTO offerResponseDTO = offerResponseDTOS.get(position);
        holder.setData(offerResponseDTO);
    }

    @Override
    public int getItemCount() {
        return offerResponseDTOS.size();
    }
}
