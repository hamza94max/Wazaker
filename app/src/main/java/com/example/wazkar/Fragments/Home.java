package com.example.wazkar.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.wazkar.Azkar;
import com.example.wazkar.R;
import com.example.wazkar.Adapters.RecAdapter;
import com.example.wazkar.Models.items;

import java.util.ArrayList;
import java.util.List;


public class Home extends Fragment  {

    private RecyclerView rec;
    private RecAdapter RecAdapter;
    public AdapterView.OnItemClickListener onItemClickListener;
   private List<items> items;








    public Home() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_home, container, false);
       rec=v.findViewById(R.id.rec);



        RecAdapter = new RecAdapter((ArrayList<com.example.wazkar.Models.items>) items, getContext());
        rec.setAdapter(RecAdapter);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        rec.setHasFixedSize(true);




        return  v ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


     items =new ArrayList<>();
        // TODO recycle view
        items.add(new items("أذكار الصباح "));
        items.add(new items("أذكار المساء"));
        items.add(new items("أذكار المسجد"));
        items.add(new items("أذكار الأذان "));
        items.add(new items("أذكار بعد الصلاه "));
        items.add(new items("أذكار الوضوء"));
        items.add(new items("الأدعيـة القرآنية"));
        items.add(new items("أدعيه النبويه "));
        items.add(new items("أذكار المنزل"));
        items.add(new items("أذكار الطعام"));
        items.add(new items("أذكار النوم"));
        items.add(new items("أذكار الاستيقاظ من النوم"));
        items.add(new items("دعاء ختم القران الكريم"));
        items.add(new items("فضل الدعاء"));
        items.add(new items("فضل الدعاء"));
        items.add(new items("فضل الأذكار"));
        items.add(new items("الرقيه الشرعيه"));






    }




}