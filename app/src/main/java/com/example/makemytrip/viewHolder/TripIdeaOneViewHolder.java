package com.example.makemytrip.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.makemytrip.R;
import com.example.makemytrip.response.HotelDTO;

public class TripIdeaOneViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvImage;
    private TextView mTvPlace;
    private TextView mTvName;

    public TripIdeaOneViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvImage = itemView.findViewById(R.id.image_TripIdea);
        mTvPlace = itemView.findViewById(R.id.location_TripIdea);
        mTvName = itemView.findViewById(R.id.Name_TripIdea);
    }

    public void setData(HotelDTO data) {
        Glide.with(mIvImage).load(data.getStoriesimage()).into(mIvImage);
        mTvPlace.setText(data.getAddress());
        mTvName.setText(data.getName1());
    }


    public void setDataWander(HotelDTO data) {
        Glide.with(mIvImage).load(data.getWanderlustimage()).into(mIvImage);
        mTvPlace.setText(data.getWanderlustplace());
    }

    public void setDataInterest(HotelDTO data) {
        Glide.with(mIvImage).load(data.getInterestimage()).into(mIvImage);
        mTvPlace.setText(data.getInterestplace());
    }
}
