package com.hamza.Wazaker.ui.Activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.hamza.Wazaker.Data.Data_sets.MorningAzkarDataset;
import com.hamza.Wazaker.Data.Models.ZekerModel;
import com.hamza.Wazaker.ui.Adapters.MorningAzkarAdapter;
import com.hamza.wazkar.R;
import com.hamza.wazkar.databinding.ActivityMorAzkarBinding;

import java.util.ArrayList;

public class MorningAzkarActivity extends AppCompatActivity {

    ArrayList<ZekerModel> morningAzkar;
    ActivityMorAzkarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mor_azkar);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mor_azkar);

        getMorningAzkar();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.morRecyclerview.setLayoutManager(layoutManager);

        MorningAzkarAdapter adapter = new MorningAzkarAdapter(morningAzkar, getBaseContext());
        binding.morRecyclerview.setLayoutManager(layoutManager);
        binding.morRecyclerview.setAdapter(adapter);
    }

    private void getMorningAzkar() {
        morningAzkar = (ArrayList<ZekerModel>) MorningAzkarDataset.getMorningAzkar();
    }
}

