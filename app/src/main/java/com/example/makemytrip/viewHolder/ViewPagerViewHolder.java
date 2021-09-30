package com.example.makemytrip.viewHolder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makemytrip.R;
import com.example.makemytrip.response.ViewPagerModel;

public class ViewPagerViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIv;

    public ViewPagerViewHolder(@NonNull View itemView) {
        super(itemView);
        mIv = itemView.findViewById(R.id.iv);
    }

    public void setData(ViewPagerModel data) {
        mIv.setImageResource(data.getImageId());
    }
}
