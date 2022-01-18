package com.hazem.wazaker.Activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.hazem.wazaker.Adapters.MorningAzkarAdapter;
import com.hazem.wazaker.Data_sets.MorningAzkarDataset;
import com.hazem.wazaker.Models.ZekerModel;
import com.hazem.wazkar.R;
import com.hazem.wazkar.databinding.ActivityMorAzkarBinding;

import java.util.ArrayList;

public class MorningAzkarActivity extends AppCompatActivity {

    ArrayList<ZekerModel> morningAzkar;
    ActivityMorAzkarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mor_azkar);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mor_azkar);

        LoadMorningAzkar();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.morRecyclerview.setLayoutManager(layoutManager);

        MorningAzkarAdapter adapter = new MorningAzkarAdapter(morningAzkar, getBaseContext());
        binding.morRecyclerview.setLayoutManager(layoutManager);
        binding.morRecyclerview.setAdapter(adapter);
    }

    private void LoadMorningAzkar(){
        morningAzkar = (ArrayList<ZekerModel>) MorningAzkarDataset.getMorningAzkar();
    }
}

