package com.hamza.Wazaker.ui.Activites;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hamza.Wazaker.Data.Data_sets.AzkarListDataset;
import com.hamza.Wazaker.Data.Models.AzkarListModel;
import com.hamza.Wazaker.ui.Adapters.AzkarListAdapter;
import com.hamza.wazkar.R;

import java.util.ArrayList;

public class AzkarListActivity extends AppCompatActivity {
     private ArrayList<AzkarListModel> AzkarList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_azkar);

            initAzkarListData();

    }
        private void initAzkarListData() {

            AzkarList = (ArrayList<AzkarListModel>) AzkarListDataset.getAzkarList();
            setAdapter();
        }

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

