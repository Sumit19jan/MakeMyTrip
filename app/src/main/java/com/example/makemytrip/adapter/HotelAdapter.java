package com.example.makemytrip.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makemytrip.R;
import com.example.makemytrip.response.HotelDTO;
import com.example.makemytrip.viewHolder.HotelViewHolder;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelViewHolder> {

    private List<HotelDTO> hotelDTOS;

    public HotelAdapter(List<HotelDTO> hotelDTOS) {
        this.hotelDTOS = hotelDTOS;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_hotel,parent,false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        HotelDTO hotelDTO = hotelDTOS.get(position);
        holder.setData(hotelDTO);
    }

    @Override
    public int getItemCount() {
        return hotelDTOS.size();
    }
}
