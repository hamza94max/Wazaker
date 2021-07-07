package com.hazem.wazaker.Activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hazem.wazaker.Adapters.NightAzkarAdapter;
import com.hazem.wazaker.Data_sets.EveningAzkarDataset;
import com.hazem.wazaker.Models.ZekerModel;
import com.hazem.wazkar.R;

import java.util.ArrayList;

public class EveningAzkar extends AppCompatActivity {

    ArrayList<ZekerModel> eveningAzkar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night_azkar);


        RecyclerView recyclerView = findViewById(R.id.eveningrecycler);

        loadEveningdata();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        NightAzkarAdapter adapter = new NightAzkarAdapter(eveningAzkar,getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    private void loadEveningdata(){
        eveningAzkar = (ArrayList<ZekerModel>) EveningAzkarDataset.getEveningAzkar();
     }
}
