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

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class FortyAdapter extends RecyclerView.Adapter<FortyAdapter.Myviewholder> {


    private ItemListner listner;
    private List<FortyItem> fortyList;

    public FortyAdapter(ArrayList<FortyItem> fortyList, Context context) {
        this.fortyList=fortyList;
    }
    public void setListner(ItemListner listner) {
        this.listner = listner;
    }




    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.simple_cell, parent, false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
        FortyItem p = fortyList.get(position);
        holder.title.setText(p.getName());
    }

    @Override
    public int getItemCount() {
        return fortyList.size();
    }



    class Myviewholder extends RecyclerView.ViewHolder {
        TextView title;

        public Myviewholder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            itemView.setOnClickListener((e) -> {
                listner.onItemCLicked(getAdapterPosition());
            });

        }
    }
}
