package com.hamza.Wazaker.ui.Fragments.FortyHadithFragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hamza.Wazaker.Data.Models.Hadith;
import com.hamza.wazkar.R;

import java.util.ArrayList;

public class HadithAdapter extends RecyclerView.Adapter<HadithAdapter.ViewHolder> {

    ArrayList<Hadith> hadiths;

    public HadithAdapter(ArrayList<Hadith> hadiths) {
        this.hadiths = hadiths;
    }

    @NonNull
    @Override
    public HadithAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.forty_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HadithAdapter.ViewHolder holder, int position) {
        holder.hadithText.setText(hadiths.get(position).getHadith());
    }

    @Override
    public int getItemCount() {
        return hadiths.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hadithText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hadithText = itemView.findViewById(R.id.hadithText);
        }
    }
}
