package com.hazem.wazaker.Activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.hazem.wazaker.Adapters.NightAzkarAdapter;
import com.hazem.wazaker.Data_sets.EveningAzkarDataset;
import com.hazem.wazaker.Models.ZekerModel;
import com.hazem.wazkar.R;
import com.hazem.wazkar.databinding.ActivityEvenAzkarBinding;

import java.util.ArrayList;

public class EveningAzkarActivity extends AppCompatActivity {

    ArrayList<ZekerModel> eveningAzkar;
    ActivityEvenAzkarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even_azkar);

        loadEveningdata();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.eveningrecycler.setLayoutManager(layoutManager);
        NightAzkarAdapter adapter = new NightAzkarAdapter(eveningAzkar, getBaseContext());
        binding.eveningrecycler.setLayoutManager(layoutManager);
        binding.eveningrecycler.setAdapter(adapter);
        binding.eveningrecycler.setHasFixedSize(true);
    }

    private void loadEveningdata(){
        eveningAzkar = (ArrayList<ZekerModel>) EveningAzkarDataset.getEveningAzkar();
     }
}
