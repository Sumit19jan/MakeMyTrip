package com.example.makemytrip.viewHolder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.makemytrip.R;
import com.example.makemytrip.response.HotelDTO;

public class WelcomeViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvImage;
    public WelcomeViewHolder(@NonNull View itemView) {
        super(itemView);
        mIvImage = itemView.findViewById(R.id.iv_image_offers);
    }

    public void setData(HotelDTO data) {
        Glide.with(mIvImage).load(data.getHotelImageUrl()).into(mIvImage);
    }
}
