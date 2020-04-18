package com.example.wazkar.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wazkar.Adapters.FortyAdapter;
import com.example.wazkar.Models.Model_Forty;
import com.example.wazkar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * use Fragment as Suffix to Indicate its type :  Forrty --> FortyyFragment
 */
public class FortyyFragment extends Fragment {
    RecyclerView recyclerforty;
    List<Model_Forty> fortyList;
    FortyAdapter fortyAdapter;

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
        fortyList.add(new Model_Forty("الحديث الأول "));
        fortyList.add(new Model_Forty("الحديث الثاني "));
        fortyList.add(new Model_Forty("الحديث الثالث "));
        fortyList.add(new Model_Forty("الحديث الرابع "));
        fortyList.add(new Model_Forty("الحديث الخامس "));
        fortyList.add(new Model_Forty("الحديث السادس "));
        fortyList.add(new Model_Forty("الحديث السابع "));
        fortyList.add(new Model_Forty("الحديث الثامن "));
        fortyList.add(new Model_Forty("الحديث التاسع "));
        fortyList.add(new Model_Forty("الحديث العاشر "));
        fortyList.add(new Model_Forty("الحديث الحادي عشر "));
        fortyList.add(new Model_Forty("الحديث الثاني عشر "));
        fortyList.add(new Model_Forty("الحديث الثالث عشر"));
        fortyList.add(new Model_Forty("الحديث الرابع عشر "));
        fortyList.add(new Model_Forty("الحديث الخامس عشر"));
        fortyList.add(new Model_Forty("الحديث السادس عشر"));
        fortyList.add(new Model_Forty("الحديث السابع عشر"));
        fortyList.add(new Model_Forty("الحديث الثامن عشر"));
        fortyList.add(new Model_Forty("الحديث التاسع عشر"));
        fortyList.add(new Model_Forty("الحديث العشرون "));
        fortyList.add(new Model_Forty("الحديث الحادي والعشرون"));
        fortyList.add(new Model_Forty("الحديث الثاني والعشرون "));
        fortyList.add(new Model_Forty("الحديث الثالث والعشرون"));
        fortyList.add(new Model_Forty("الحديث الرابع والعشرون"));
        fortyList.add(new Model_Forty("الحديث الخامس والعشرون"));
        fortyList.add(new Model_Forty("الحديث السادس والعشرون"));
        fortyList.add(new Model_Forty("الحديث السابع والعشرون"));
        fortyList.add(new Model_Forty("الحديث الثامن والعشرون"));
        fortyList.add(new Model_Forty("الحديث التاسع والعشرون"));
        fortyList.add(new Model_Forty("الحديث الثلاثون "));
        fortyList.add(new Model_Forty("الحديث الحادي والثلاثون "));
        fortyList.add(new Model_Forty("الحديث الثاني والثلاثون"));
        fortyList.add(new Model_Forty("الحديث الثالث والثلاثون"));
        fortyList.add(new Model_Forty("الحديث الرابع والثلاثون"));
        fortyList.add(new Model_Forty("الحديث الخامس والثلاثون"));
        fortyList.add(new Model_Forty("الحديث السادس والثلاثون"));
        fortyList.add(new Model_Forty("الحديث السابع والثلاثون"));
        fortyList.add(new Model_Forty("الحديث الثامن والثلاثون"));
        fortyList.add(new Model_Forty("الحديث التاسع والثلاثون"));
        fortyList.add(new Model_Forty("الحديث الأربعون "));
        fortyList.add(new Model_Forty("الحديث الحادي و الأربعون "));
        fortyList.add(new Model_Forty("الحديث الثاني و الأربعون "));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fortyy, container, false);
        recyclerforty = view.findViewById(R.id.recff);

        fortyAdapter = new FortyAdapter(fortyList, getContext());

        recyclerforty.setAdapter(fortyAdapter);
        recyclerforty.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerforty.setHasFixedSize(true);

        return view;


    }


}