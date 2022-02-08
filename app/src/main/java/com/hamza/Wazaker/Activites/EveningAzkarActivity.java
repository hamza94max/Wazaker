package com.hamza.Wazaker.Activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.hamza.Wazaker.Adapters.NightAzkarAdapter;
import com.hamza.Wazaker.Data_sets.EveningAzkarDataset;
import com.hamza.Wazaker.Models.ZekerModel;
import com.hamza.wazkar.R;
import com.hamza.wazkar.databinding.ActivityEvenAzkarBinding;

import java.util.ArrayList;

public class EveningAzkarActivity extends AppCompatActivity {

    ArrayList<ZekerModel> eveningAzkar;
    ActivityEvenAzkarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even_azkar);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_even_azkar);

        getEveningdata();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.eveningrecycler.setLayoutManager(layoutManager);
        NightAzkarAdapter adapter = new NightAzkarAdapter(eveningAzkar, getBaseContext());
        binding.eveningrecycler.setLayoutManager(layoutManager);
        binding.eveningrecycler.setAdapter(adapter);
        binding.eveningrecycler.setHasFixedSize(true);
    }

    private void getEveningdata() {
        eveningAzkar = (ArrayList<ZekerModel>) EveningAzkarDataset.getEveningAzkar();
    }
}
