package com.example.makemytrip.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makemytrip.R;
import com.example.makemytrip.response.FlightResponseDTO;

public class FlightViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvFlightName;
    private TextView mTvStartTime;
    private TextView mTvSource;
    private TextView mTvDestination;
    private TextView MtvDestinationTime;
    private TextView mTvPrice;

    public FlightViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvFlightName = itemView.findViewById(R.id.tvFlightName_flight_item_layout);
        mTvStartTime = itemView.findViewById(R.id.tvStartTime_flight_item_layout);
        mTvSource = itemView.findViewById(R.id.tvSource_flight_item_layout);
        mTvDestination = itemView.findViewById(R.id.tvDestination_flight_item_layout);
        MtvDestinationTime = itemView.findViewById(R.id.tvEndTime_flight_item_layout);
        mTvPrice = itemView.findViewById(R.id.tvPrice_flight_item_layout);
    }

    public void setData(FlightResponseDTO data) {
        mTvFlightName.setText(data.getName());
        mTvStartTime.setText(data.getStarttime());
        mTvSource.setText(data.getSource());
        mTvDestination.setText(data.getDestination());
        MtvDestinationTime.setText(data.getEndtime());
        mTvPrice.setText(data.getPrice() + "");
    }
}
