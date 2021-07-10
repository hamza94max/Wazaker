package com.hazem.wazaker.Activites;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hazem.wazaker.Adapters.AzkarListAdapter;
import com.hazem.wazaker.Data_sets.AzkarListDataset;
import com.hazem.wazaker.Models.AzkarModel;
import com.hazem.wazkar.R;

import java.util.ArrayList;


    public class AzkarListActivity extends AppCompatActivity {
     private ArrayList<AzkarModel> AzkarList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_azkar);

            initAzkarListData();

    }
        private void initAzkarListData() {

            AzkarList = (ArrayList<AzkarModel>) AzkarListDataset.getAzkarList();
            setAdapter(); }

        private void setAdapter(){
            RecyclerView recyclerView = findViewById(R.id.AzkarListRecycler);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            AzkarListAdapter azkarListAdapter = new AzkarListAdapter(AzkarList, AzkarListActivity.this);
            recyclerView.setAdapter(azkarListAdapter);

            azkarListAdapter.setListner(e -> {
                int index = (int) e;
                Intent zeker = new Intent(getBaseContext(), ZekerActivity.class);
                zeker.putExtra("index", index);
                startActivity(zeker);
            });
        }
    }

