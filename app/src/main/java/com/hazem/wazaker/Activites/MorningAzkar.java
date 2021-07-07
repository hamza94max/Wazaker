package com.hazem.wazaker.Activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hazem.wazaker.Adapters.MorningAzkarAdapter;
import com.hazem.wazaker.Data_sets.MorningAzkarDataset;
import com.hazem.wazaker.Models.ZekerModel;
import com.hazem.wazkar.R;

import java.util.ArrayList;

public class MorningAzkar extends AppCompatActivity {

    ArrayList<ZekerModel> morningAzkar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mor_azkar);

        loadMorningAzkar();

        RecyclerView recyclerView = findViewById(R.id.morrecyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MorningAzkarAdapter adapter = new MorningAzkarAdapter(morningAzkar,getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void loadMorningAzkar(){
        morningAzkar = (ArrayList<ZekerModel>) MorningAzkarDataset.getMorningAzkar();
    }
}

