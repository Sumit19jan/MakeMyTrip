package com.example.makemytrip.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makemytrip.R;
import com.example.makemytrip.response.OfferResponseDTO;
import com.example.makemytrip.viewHolder.CabsViewHolder;
import com.example.makemytrip.viewHolder.TrainViewHolder;

import java.util.List;

public class CabsAdapter extends RecyclerView.Adapter<CabsViewHolder> {

    private List<OfferResponseDTO> offerResponseDTOS;

    public CabsAdapter(List<OfferResponseDTO> offerResponseDTOS) {
        this.offerResponseDTOS = offerResponseDTOS;
    }

    @NonNull
    @Override
    public CabsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_item_layout, parent, false);
        return new CabsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CabsViewHolder holder, int position) {
        OfferResponseDTO offerResponseDTO = offerResponseDTOS.get(position);
        holder.setData(offerResponseDTO);
    }

    @Override
    public int getItemCount() {
        return offerResponseDTOS.size();
    }
}
