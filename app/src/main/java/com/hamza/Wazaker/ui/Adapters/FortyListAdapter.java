package com.hamza.Wazaker.ui.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hamza.Wazaker.Data.Models.AzkarListModel;
import com.hamza.Wazaker.ui.listeners.ItemListner;
import com.hamza.wazkar.R;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;

public class FortyListAdapter extends RecyclerView.Adapter<FortyListAdapter.Myviewholder> {


    private ItemListner listner;
    private final List<AzkarListModel> fortyList;

    public FortyListAdapter(ArrayList<AzkarListModel> fortyList, AccessControlContext context) {
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
        AzkarListModel p = fortyList.get(position);
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
