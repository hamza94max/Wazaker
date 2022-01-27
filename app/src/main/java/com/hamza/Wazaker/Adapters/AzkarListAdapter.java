package com.hamza.Wazaker.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hamza.Wazaker.Activites.AzkarListActivity;
import com.hamza.Wazaker.Models.AzkarListModel;
import com.hamza.Wazaker.listeners.ItemListner;
import com.hamza.wazkar.R;

import java.util.List;

public class AzkarListAdapter extends RecyclerView.Adapter<AzkarListAdapter.ViewHolder> {


    private ItemListner listner;
    private final List<AzkarListModel> azkar_modelList;

    public AzkarListAdapter(List<AzkarListModel> items, AzkarListActivity azkarListActivity) {
        this.azkar_modelList = items;
    }

    public void setListner(ItemListner listner) {
        this.listner = listner;
    }

    @Override
    public AzkarListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.simple_cell, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,  int position) {

        AzkarListModel azkarListModel = azkar_modelList.get(position);
        holder.title.setText(azkarListModel.getName());
       
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

