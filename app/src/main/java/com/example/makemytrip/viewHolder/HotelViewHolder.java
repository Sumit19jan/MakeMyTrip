package com.example.makemytrip.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.makemytrip.R;
import com.example.makemytrip.response.HotelDTO;

public class HotelViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvStar;
    private TextView mTvAddress;
    private TextView mTvPrice;
    private ImageView mIvHotelImage;

    public HotelViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvStar = itemView.findViewById(R.id.tvStart);
        mTvAddress = itemView.findViewById(R.id.tvAddress);
        mTvPrice = itemView.findViewById(R.id.tvPrice);
        mIvHotelImage = itemView.findViewById(R.id.ivHotelImage);
    }

    public void setData(HotelDTO data) {

        mTvStar.setText(data.getStar() + "");
        mTvPrice.setText(data.getPrice() + "");
        mTvAddress.setText(data.getAddress());
        Glide.with(mIvHotelImage).load(data.getHotelImageUrl()).into(mIvHotelImage);
    }
}
