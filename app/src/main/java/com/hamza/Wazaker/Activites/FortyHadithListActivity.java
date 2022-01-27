package com.hamza.Wazaker.Activites;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hamza.Wazaker.Adapters.FortyListAdapter;
import com.hamza.Wazaker.Data_sets.FortyListDataset;
import com.hamza.Wazaker.Models.AzkarListModel;
import com.hamza.wazkar.R;
import com.hamza.wazkar.databinding.ActivityFortylistBinding;

import java.util.ArrayList;
import java.util.List;

public class FortyHadithListActivity extends AppCompatActivity {

    ActivityFortylistBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortylist);

        LoadFortyHadithData();
    }

    private void LoadFortyHadithData() {
        List<AzkarListModel> hadithlist = FortyListDataset.getFortylist();
        FortyListAdapter fortyAdapter = new FortyListAdapter((ArrayList<AzkarListModel>) hadithlist, getContext());

        binding.hadithrecycler.setAdapter(fortyAdapter);

        fortyAdapter.setListner(itemf -> {
            int index = (int) itemf;
            Intent forty = new Intent(getBaseContext(), FortyHadithActivity.class);
            forty.putExtra("index", index);
            startActivity(forty);
        });
    }
}
