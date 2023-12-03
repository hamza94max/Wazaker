package com.islamey.hamza.wazaker.ui.FortyHadithFragment;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.islamey.hamza.wazaker.domain.Models.Hadith;
import com.islamey.wazkar.R;

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

        holder.copyButton.setOnClickListener(view -> {
            String zeker = hadiths.get(position).getHadith();

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, zeker);
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            view.getContext().startActivity(shareIntent);
        });
    }

    @Override
    public int getItemCount() {
        return hadiths.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hadithText;
        Button copyButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hadithText = itemView.findViewById(R.id.hadithText);
            copyButton = itemView.findViewById(R.id.copybtn);
        }
    }
}
