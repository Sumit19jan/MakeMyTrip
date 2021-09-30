package com.example.makemytrip.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.makemytrip.R;
import com.example.makemytrip.response.ViewPagerModel;
import com.example.makemytrip.viewHolder.ViewPagerViewHolder;

import java.util.ArrayList;

public class ViewPagerLoginAdapter extends RecyclerView.Adapter<ViewPagerViewHolder> {

    private ArrayList<ViewPagerModel> viewPagerModels;

    public ViewPagerLoginAdapter(ArrayList<ViewPagerModel> viewPagerModels) {
        this.viewPagerModels = viewPagerModels;
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_viewpager,parent,false);
        return new ViewPagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        ViewPagerModel viewPagerModel = viewPagerModels.get(position);
        holder.setData(viewPagerModel);
    }

    @Override
    public int getItemCount() {
        return viewPagerModels.size();
    }
}
