package com.example.wazkar.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wazkar.Models.FortyItem;
import com.example.wazkar.R;
import com.example.wazkar.listeners.ItemListner;

import java.util.List;

public class FortyAdapter extends RecyclerView.Adapter<FortyAdapter.Myviewholder> {

    List<FortyItem> fortyList;
    Context context;

    ItemListner listner;

    public FortyAdapter(List<FortyItem> fortyList, Context context) {
        this.fortyList = fortyList;
        this.context = context;
    }


    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.simple_cell, parent, false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
        holder.title.setText(fortyList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return fortyList.size();
    }

    public void setListner(ItemListner listner) {
        this.listner = listner;
    }

    class Myviewholder extends RecyclerView.ViewHolder {
        TextView title;

        public Myviewholder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            itemView.setOnClickListener((e) -> {
                listner.onItemCLicked(fortyList.get(getAdapterPosition()));
            });

        }
    }
}
