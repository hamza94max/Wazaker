package com.example.wazkar.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wazkar.Models.Model_Forty;
import com.example.wazkar.R;

import java.util.List;

public class FortyAdapter extends RecyclerView.Adapter<FortyAdapter.Myviewholder> {

    List<Model_Forty> fortyList;
    Context context;

    public FortyAdapter(List<Model_Forty> fortyList, Context context) {
        this.fortyList = fortyList;
        this.context = context;
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.forty_items, parent, false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
        holder.button.setText(fortyList.get(position).getNamehad());
    }

    @Override
    public int getItemCount() {
        return fortyList.size();
    }


    static class Myviewholder extends RecyclerView.ViewHolder {
        Button button;

        public Myviewholder(View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.buttonforty);


        }
    }
}
