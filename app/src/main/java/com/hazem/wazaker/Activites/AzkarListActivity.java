package com.hazem.wazaker.Activites;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hazem.wazaker.Adapters.AzkarAdapter;
import com.hazem.wazaker.Models.Rec_azkar_items;
import com.hazem.wazkar.R;
import java.util.ArrayList;


    public class AzkarListActivity extends AppCompatActivity {
        private ArrayList<com.hazem.wazaker.Models.Rec_azkar_items> Azkar_titles;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_azkar);

            initData();





    }

        private void initData() {

            Azkar_titles = new ArrayList<>();
            Azkar_titles.add(new Rec_azkar_items("أذكار المسجد"));
            Azkar_titles.add(new Rec_azkar_items("أذكار بعد الصلاة "));
            Azkar_titles.add(new Rec_azkar_items("أذكار الأذان "));
            Azkar_titles.add(new Rec_azkar_items("أذكار الوضوء"));
            Azkar_titles.add(new Rec_azkar_items("الأدعيـة القرآنية"));
            Azkar_titles.add(new Rec_azkar_items("الأدعية النبوية "));
            Azkar_titles.add(new Rec_azkar_items("أذكار الطعام"));
            Azkar_titles.add(new Rec_azkar_items("أذكار المنزل"));
            Azkar_titles.add(new Rec_azkar_items("أذكار النوم"));
            Azkar_titles.add(new Rec_azkar_items("أذكار الإستيقاظ من النوم"));
            Azkar_titles.add(new Rec_azkar_items("أذكار عظيمة"));
            Azkar_titles.add(new Rec_azkar_items("دعاء السفر"));
            Azkar_titles.add(new Rec_azkar_items("دعاء ختم القرآن الكريم"));
            Azkar_titles.add(new Rec_azkar_items("فضل الدعاء"));
            Azkar_titles.add(new Rec_azkar_items("فضل تلاوة القرآن الكريم"));
            Azkar_titles.add(new Rec_azkar_items("فضل الأذكار"));
            Azkar_titles.add(new Rec_azkar_items("الرقية الشرعية"));
            Azkar_titles.add(new Rec_azkar_items("أدعية للمتوفّي"));
             setAdapter(); }

        private void setAdapter(){
            RecyclerView recyclerView = findViewById(R.id.rvAzkar);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            AzkarAdapter adapter = new AzkarAdapter(Azkar_titles, AzkarListActivity.this);
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);

            adapter.setListner(e -> {
                int index = (int) e;
                Intent zeker = new Intent(getBaseContext(), ZekerActivity.class);
                zeker.putExtra("index", index);
                startActivity(zeker);
            });

        }



    }















