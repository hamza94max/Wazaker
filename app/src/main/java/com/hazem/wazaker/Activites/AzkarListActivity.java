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
        private ArrayList<com.hazem.wazaker.Models.Rec_azkar_items> Rec_azkar_items;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_azkar);

            initData();





    }

        private void initData() {

             Rec_azkar_items = new ArrayList<>();
             Rec_azkar_items.add(new Rec_azkar_items("أذكار المسجد"));
             Rec_azkar_items.add(new Rec_azkar_items("أذكار بعد الصلاة "));
             Rec_azkar_items.add(new Rec_azkar_items("أذكار الأذان "));
             Rec_azkar_items.add(new Rec_azkar_items("أذكار الوضوء"));
             Rec_azkar_items.add(new Rec_azkar_items("الأدعيـة القرآنية"));
             Rec_azkar_items.add(new Rec_azkar_items("الأدعية النبوية "));
             Rec_azkar_items.add(new Rec_azkar_items("أذكار الطعام"));
             Rec_azkar_items.add(new Rec_azkar_items("أذكار المنزل"));
             Rec_azkar_items.add(new Rec_azkar_items("أذكار النوم"));
             Rec_azkar_items.add(new Rec_azkar_items("أذكار الإستيقاظ من النوم"));
             Rec_azkar_items.add(new Rec_azkar_items("أذكار عظيمة"));
             Rec_azkar_items.add(new Rec_azkar_items("دعاء السفر"));
             Rec_azkar_items.add(new Rec_azkar_items("دعاء ختم القرآن الكريم"));
             Rec_azkar_items.add(new Rec_azkar_items("فضل الدعاء"));
             Rec_azkar_items.add(new Rec_azkar_items("فضل تلاوة القرآن الكريم"));
             Rec_azkar_items.add(new Rec_azkar_items("فضل الأذكار"));
             Rec_azkar_items.add(new Rec_azkar_items("الرقية الشرعية"));
             Rec_azkar_items.add(new Rec_azkar_items("أدعية للمتوفّي"));
             setAdapter(); }

        private void setAdapter(){
            RecyclerView recyclerView = findViewById(R.id.rvAzkar);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            AzkarAdapter adapter = new AzkarAdapter(Rec_azkar_items, AzkarListActivity.this);
            recyclerView.setAdapter(adapter);
            adapter.setListner(e -> {
                int index = (int) e;
                Intent zeker = new Intent(getBaseContext(), ZekerActivity.class);
                zeker.putExtra("index", index);
                startActivity(zeker);
            });

        }



    }















