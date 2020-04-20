package com.hazem.wazaker.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.hazem.wazaker.Adapters.FortyAdapter;
import com.hazem.wazaker.activities.FortyActivity;
import com.hazem.wazaker.Models.FortyItem;
import com.hazem.wazkar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * use Fragment as Suffix to Indicate its type :  Forrty --> FortyyFragment
 */
public class FortyyFragment extends Fragment {

    private List<FortyItem> fortyList;


    public FortyyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
    }

    private void loadData() {
        fortyList = new ArrayList<>();
        fortyList.add(new FortyItem("الحديث الأول "));
        fortyList.add(new FortyItem("الحديث الثاني "));
        fortyList.add(new FortyItem("الحديث الثالث "));
        fortyList.add(new FortyItem("الحديث الرابع "));
        fortyList.add(new FortyItem("الحديث الخامس "));
        fortyList.add(new FortyItem("الحديث السادس "));
        fortyList.add(new FortyItem("الحديث السابع "));
        fortyList.add(new FortyItem("الحديث الثامن "));
        fortyList.add(new FortyItem("الحديث التاسع "));
        fortyList.add(new FortyItem("الحديث العاشر "));
        fortyList.add(new FortyItem("الحديث الحادي عشر "));
        fortyList.add(new FortyItem("الحديث الثاني عشر "));
        fortyList.add(new FortyItem("الحديث الثالث عشر"));
        fortyList.add(new FortyItem("الحديث الرابع عشر "));
        fortyList.add(new FortyItem("الحديث الخامس عشر"));
        fortyList.add(new FortyItem("الحديث السادس عشر"));
        fortyList.add(new FortyItem("الحديث السابع عشر"));
        fortyList.add(new FortyItem("الحديث الثامن عشر"));
        fortyList.add(new FortyItem("الحديث التاسع عشر"));
        fortyList.add(new FortyItem("الحديث العشرون "));
        fortyList.add(new FortyItem("الحديث الحادي والعشرون"));
        fortyList.add(new FortyItem("الحديث الثاني والعشرون "));
        fortyList.add(new FortyItem("الحديث الثالث والعشرون"));
        fortyList.add(new FortyItem("الحديث الرابع والعشرون"));
        fortyList.add(new FortyItem("الحديث الخامس والعشرون"));
        fortyList.add(new FortyItem("الحديث السادس والعشرون"));
        fortyList.add(new FortyItem("الحديث السابع والعشرون"));
        fortyList.add(new FortyItem("الحديث الثامن والعشرون"));
        fortyList.add(new FortyItem("الحديث التاسع والعشرون"));
        fortyList.add(new FortyItem("الحديث الثلاثون "));
        fortyList.add(new FortyItem("الحديث الحادي والثلاثون "));
        fortyList.add(new FortyItem("الحديث الثاني والثلاثون"));
        fortyList.add(new FortyItem("الحديث الثالث والثلاثون"));
        fortyList.add(new FortyItem("الحديث الرابع والثلاثون"));
        fortyList.add(new FortyItem("الحديث الخامس والثلاثون"));
        fortyList.add(new FortyItem("الحديث السادس والثلاثون"));
        fortyList.add(new FortyItem("الحديث السابع والثلاثون"));
        fortyList.add(new FortyItem("الحديث الثامن والثلاثون"));
        fortyList.add(new FortyItem("الحديث التاسع والثلاثون"));
        fortyList.add(new FortyItem("الحديث الأربعون "));
        fortyList.add(new FortyItem("الحديث الحادي و الأربعون "));
        fortyList.add(new FortyItem("الحديث الثاني و الأربعون "));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fortyy, container, false);
       RecyclerView recyclerforty = view.findViewById(R.id.rvHadith);

        FortyAdapter fortyAdapter = new FortyAdapter( (ArrayList<FortyItem>) fortyList, getContext());

        recyclerforty.setAdapter(fortyAdapter);
        recyclerforty.setHasFixedSize(true);
    // recyclerforty.addItemDecoration(new DividerItemDecoration(getContext() , DividerItemDecoration.VERTICAL));

        fortyAdapter.setListner(itemf -> {
            int index = (int) itemf;
            Intent forty = new Intent(getActivity(), FortyActivity.class);
            forty.putExtra("index", index);
            startActivity(forty);
        });

        return view;

    }


}