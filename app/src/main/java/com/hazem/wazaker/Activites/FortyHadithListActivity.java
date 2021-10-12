package com.hazem.wazaker.Activites;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.hazem.wazaker.Adapters.FortyListAdapter;
import com.hazem.wazaker.Data_sets.FortyListDataset;
import com.hazem.wazaker.Models.AzkarListModel;
import com.hazem.wazkar.R;

import java.util.ArrayList;
import java.util.List;

public class FortyHadithListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortylist);

        LoadFortyHadithData();
    }

    private void LoadFortyHadithData() {
        List<AzkarListModel> hadithlist = FortyListDataset.getFortylist();

        RecyclerView Hadithrecycler = findViewById(R.id.hadithrecycler);

        FortyListAdapter fortyAdapter = new FortyListAdapter( (ArrayList<AzkarListModel>) hadithlist, getContext());

        Hadithrecycler.setAdapter(fortyAdapter);

        fortyAdapter.setListner(itemf -> {
            int index = (int) itemf;
            Intent forty = new Intent(getBaseContext(), FortyHadithActivity.class);
            forty.putExtra("index", index);
            startActivity(forty);
        });
    }}
