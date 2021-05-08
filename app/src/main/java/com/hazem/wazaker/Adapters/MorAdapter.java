package com.hazem.wazaker.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.hazem.wazaker.Models.ZekeritemModel;
import com.hazem.wazkar.R;
import java.util.ArrayList;
import at.markushi.ui.CircleButton;

public class MorAdapter extends RecyclerView.Adapter<MorAdapter.HViewholder> {


    private ArrayList<ZekeritemModel> model = new ArrayList<>();





    public MorAdapter(ArrayList<ZekeritemModel> models,Context context) {
        this.model = models;
    }
    @Override
    public HViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.morr_items, parent, false);


        return new HViewholder(v);
    }




    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MorAdapter.HViewholder holder, int position) {

        holder.zekertext.setText(model.get(position).getZeker());
        holder.copybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zeker = model.get(position).getZeker();
               /*
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip =  ClipData.newPlainText("Text", zekerItems.get(viewPager.getCurrentItem()));
                clipboard.setPrimaryClip(clip);
               */
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, zeker);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                v.getContext().startActivity(shareIntent);
            }
        });


        final ZekeritemModel item = model.get(position);
        final int[] count = {item.getCurrentCount()};
        final Boolean[] ch = {item.getChecked()};
        holder.checkBox.setChecked(ch[0]);
        holder.plustext.setText(Integer.toString(count[0]));


        holder.plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count[0]++;
                item.setCurrentCount(count[0]);
                holder.plustext.setText(Integer.toString(count[0]));
                if (count[0] >=model.get(position).getCounter()){
                    ch[0] =true;
                    item.setChecked(ch[0]);
                    holder.checkBox.setChecked(ch[0]);
                }
            }});}



    @Override
    public int getItemCount() {
        return model.size();
    }

     static class HViewholder extends RecyclerView.ViewHolder {
      TextView zekertext , plustext;
      Button copybtn;
      CircleButton plusbtn;
      CheckBox checkBox;



         HViewholder(View itemView) {
            super(itemView);
            zekertext=itemView.findViewById(R.id.zekertext);
            copybtn=itemView.findViewById(R.id.copybtn);
            plusbtn=itemView.findViewById(R.id.pluss);
            plustext=itemView.findViewById(R.id.plustext);
            checkBox=itemView.findViewById(R.id.checkk);
        }
    }
}
