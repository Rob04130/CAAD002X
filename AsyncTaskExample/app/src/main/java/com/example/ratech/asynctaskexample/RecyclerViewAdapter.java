package com.example.ratech.asynctaskexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by aboro on 04/05/2018.
 */

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> arrayList;

    public RecyclerViewAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView pokemonName;

        ViewHolder(View view) {
            super(view);
            pokemonName = (TextView) view.findViewById(R.id.pokemonName);
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.pokemonName.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
