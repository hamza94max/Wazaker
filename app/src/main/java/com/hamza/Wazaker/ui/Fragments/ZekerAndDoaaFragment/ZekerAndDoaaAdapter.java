package com.hamza.Wazaker.ui.Fragments.ZekerAndDoaaFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hamza.Wazaker.Data.Models.AzkarListModel;
import com.hamza.wazkar.R;

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
    }

    @Override
    public int getItemCount() {
        return azkarListModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView zekerText;

        public ViewHolder(View itemview) {
            super(itemview);

            zekerText = itemview.findViewById(R.id.hadithText);
        }
    }
}
