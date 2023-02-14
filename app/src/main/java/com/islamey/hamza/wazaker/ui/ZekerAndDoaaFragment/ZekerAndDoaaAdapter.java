package com.islamey.hamza.wazaker.ui.ZekerAndDoaaFragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.islamey.hamza.wazaker.data.Models.AzkarListModel;
import com.islamey.wazkar.R;

import java.util.ArrayList;

public class ZekerAndDoaaAdapter extends RecyclerView.Adapter<ZekerAndDoaaAdapter.ViewHolder> {

    private final ArrayList<AzkarListModel> azkarListModels;

    public ZekerAndDoaaAdapter(ArrayList<AzkarListModel> azkarListModels) {
        this.azkarListModels = azkarListModels;
    }

    @NonNull
    @Override
    public ZekerAndDoaaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.forty_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZekerAndDoaaAdapter.ViewHolder holder, int position) {
        holder.zekerText.setText(azkarListModels.get(position).getName());

        holder.copyButton.setOnClickListener(view -> {
            String zeker = azkarListModels.get(position).getName();

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
        return azkarListModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView zekerText;
        Button copyButton;

        public ViewHolder(View itemview) {
            super(itemview);

            zekerText = itemview.findViewById(R.id.hadithText);
            copyButton = itemView.findViewById(R.id.copybtn);
        }
    }
}
