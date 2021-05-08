package com.hazem.wazaker.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hazem.wazaker.Models.Azkar_model;
import com.hazem.wazaker.listeners.ItemListner;
import com.hazem.wazkar.R;

import java.util.List;

public class AzkarAdapter extends RecyclerView.Adapter<AzkarAdapter.ViewHolder> {



    private ItemListner listner;
    private final List<Azkar_model> azkar_modelList;


    public AzkarAdapter( List<Azkar_model> items ) {
        this.azkar_modelList = items;
    }




    public void setListner(ItemListner listner) {
        this.listner = listner;
    }

    @Override
    public AzkarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.simple_cell, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,  int position) {

        Azkar_model azkarModel = azkar_modelList.get(position);
        holder.title.setText(azkarModel.getName());
       
    }

    @Override
    public int getItemCount() {
        return azkar_modelList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            itemView.setOnClickListener((e) -> {
                listner.onItemCLicked(getAdapterPosition());
            });
        }
    }

}

