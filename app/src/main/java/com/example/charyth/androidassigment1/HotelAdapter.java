package com.example.charyth.androidassigment1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by charyth on 8/22/2019.
 */

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.PlanetViewHolder> {

    ArrayList<String> planetList;

    public HotelAdapter(ArrayList<String> planetList, Context context) {
        this.planetList = planetList;
    }

    @Override
    public PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        PlanetViewHolder viewHolder=new PlanetViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HotelAdapter.PlanetViewHolder holder, int position) {
        holder.textName.setText(planetList.get(position));
        holder.text.setText(planetList.get(position));
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    public static class PlanetViewHolder extends RecyclerView.ViewHolder{

        protected TextView textName;
        protected TextView text;

        public PlanetViewHolder(View itemView) {
            super(itemView);
          textName  = (TextView) itemView.findViewById(R.id.row_layout_name);
            text= (TextView) itemView.findViewById(R.id.row_layout_id);
        }
    }
}
