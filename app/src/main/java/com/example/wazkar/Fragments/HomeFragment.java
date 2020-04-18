package com.example.wazkar.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wazkar.Adapters.RecAdapter;
import com.example.wazkar.Models.ListItem;
import com.example.wazkar.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    public AdapterView.OnItemClickListener onItemClickListener;
    private RecyclerView rec;
    private RecAdapter RecAdapter;
    private List<ListItem> items;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rec = v.findViewById(R.id.rec);


        RecAdapter = new RecAdapter((ArrayList<ListItem>) items, getContext());
        rec.setAdapter(RecAdapter);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        rec.setHasFixedSize(true);


        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        items = new ArrayList<>();
        // TODO recycle view
        items.add(new ListItem("أذكار الصباح "));
        items.add(new ListItem("أذكار المساء"));
        items.add(new ListItem("أذكار المسجد"));
        items.add(new ListItem("أذكار الأذان "));
        items.add(new ListItem("أذكار بعد الصلاه "));
        items.add(new ListItem("أذكار الوضوء"));
        items.add(new ListItem("الأدعيـة القرآنية"));
        items.add(new ListItem("أدعيه النبويه "));
        items.add(new ListItem("أذكار المنزل"));
        items.add(new ListItem("أذكار الطعام"));
        items.add(new ListItem("أذكار النوم"));
        items.add(new ListItem("أذكار الاستيقاظ من النوم"));
        items.add(new ListItem("دعاء ختم القران الكريم"));
        items.add(new ListItem("فضل الدعاء"));
        items.add(new ListItem("فضل الدعاء"));
        items.add(new ListItem("فضل الأذكار"));
        items.add(new ListItem("الرقيه الشرعيه"));


    }


}