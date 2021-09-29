package com.example.makemytrip.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.makemytrip.R;
import com.example.makemytrip.response.HotelDTO;

public class MountainViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvImage;
    private TextView mTvPlace;
    private TextView mTvName;

    public MountainViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvImage = itemView.findViewById(R.id.image_TripIdea);
        mTvPlace = itemView.findViewById(R.id.location_TripIdea);
        mTvName = itemView.findViewById(R.id.Name_TripIdea);
    }


    public void setDataMountain(HotelDTO data) {
        Glide.with(mIvImage).load(data.getAdventurousimage()).into(mIvImage);
        mTvPlace.setText(data.getAdventurouplace());
    }
}
