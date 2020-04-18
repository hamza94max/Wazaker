package com.example.wazkar.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wazkar.Azkar;
import com.example.wazkar.R;
import com.example.wazkar.Models.ListItem;

import java.util.ArrayList;
import java.util.List;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder>  {


    public  static String btnid ;


    public class ViewHolder extends RecyclerView.ViewHolder  {
        RelativeLayout relativeLayout ;
        Button button;
        public ViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.buttonn);
            relativeLayout=itemView.findViewById(R.id.Azakarxml);



        }}
    private Context context;
    private List<ListItem> items;

    public RecAdapter(ArrayList<ListItem> items, Context context) {
        this.context = context;
        this.items = items;

    }

    @Override
    public RecAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.buttonss, parent, false);
       final ViewHolder myviewholder = new ViewHolder(v );


       myviewholder.button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               btnid = myviewholder.button.getText().toString();

               Intent intent = new Intent(context, Azkar.class);
               context.startActivity(intent);



           }
       });




        return myviewholder ;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        ListItem p = items.get(position);
        holder.button.setText(p.getName());
       
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



}

