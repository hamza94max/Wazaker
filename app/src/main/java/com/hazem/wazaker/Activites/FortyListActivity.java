package com.hazem.wazaker.Activites;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.hazem.wazaker.Adapters.FortyAdapter;
import com.hazem.wazaker.Models.Rec_azkar_items;
import com.hazem.wazkar.R;
import java.util.ArrayList;
import java.util.List;


import static java.security.AccessController.getContext;

public class FortyListActivity extends AppCompatActivity {
    private List<Rec_azkar_items> fortyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forty);
        loadData();
    }

    private void loadData() {
        fortyList = new ArrayList<>();
        fortyList.add(new Rec_azkar_items("الحديث الأول "+"\n"+"( الأعمال بالنيات )"));
        fortyList.add(new Rec_azkar_items( "الحديث الثاني "+"\n"+"( مراتب الدين )"));
        fortyList.add(new Rec_azkar_items("الحديث الثالث "+"\n"+"( أركان الإسلام )"));
        fortyList.add(new Rec_azkar_items("الحديث الرابع "+"\n"+"( مراحل الخلق )"));
        fortyList.add(new Rec_azkar_items("الحديث الخامس "+"\n"+"( النهي عن الابتداع في الدين )"));
        fortyList.add(new Rec_azkar_items("الحديث السادس "+"\n"+"( البعد عن مواطن الشبهات )"));
        fortyList.add(new Rec_azkar_items("الحديث السابع "+"\n"+"( الدين النصيحه )"));
        fortyList.add(new Rec_azkar_items("الحديث الثامن "+"\n"+"( حرمة دم المسلم وماله )"));
        fortyList.add(new Rec_azkar_items("الحديث التاسع "+"\n"+"( النهي عن كثرة السؤال والتشدد )"));
        fortyList.add(new Rec_azkar_items("الحديث العاشر "+"\n"+"( سبب إجابة الدعاء )"));
        fortyList.add(new Rec_azkar_items("الحديث الحادي عشر "+"\n"+"( اترك ما شككت فيه )"));
        fortyList.add(new Rec_azkar_items("الحديث الثاني عشر "+"\n"+"( الاشتغال بما يفيد )"));
        fortyList.add(new Rec_azkar_items("الحديث الثالث عشر"+"\n"+"( من كمال الإيمان )"));
        fortyList.add(new Rec_azkar_items("الحديث الرابع عشر "+"\n"+"( متى يهدر دم المسلم )"));
        fortyList.add(new Rec_azkar_items("الحديث الخامس عشر"+"\n"+"( اكرام الضيف )"));
        fortyList.add(new Rec_azkar_items("الحديث السادس عشر"+"\n"+"( النهي عن الغضب )"));
        fortyList.add(new Rec_azkar_items("الحديث السابع عشر"+"\n"+"( الرفق بالحيوان )"));
        fortyList.add(new Rec_azkar_items("الحديث الثامن عشر"+"\n"+"( الخلق الحسن )"));
        fortyList.add(new Rec_azkar_items("الحديث التاسع عشر"+"\n"+"( الإيمان بالقضاء والقدر )"));
        fortyList.add(new Rec_azkar_items("الحديث العشرون "+"\n"+"( الحياء من الإيمان )"));
        fortyList.add(new Rec_azkar_items("الحديث الحادي والعشرون"+"\n"+"( الاستقامه بالإسلام )"));
        fortyList.add(new Rec_azkar_items("الحديث الثاني والعشرون "+"\n"+"( الطريق إلى الجنة )"));
        fortyList.add(new Rec_azkar_items("الحديث الثالث والعشرون"+"\n"+"( جوامع الخير )"));
        fortyList.add(new Rec_azkar_items("الحديث الرابع والعشرون"+"\n"+"( من فضل الله على الناس )"));
        fortyList.add(new Rec_azkar_items("الحديث الخامس والعشرون"+"\n"+"( فضل الذكر )"));
        fortyList.add(new Rec_azkar_items("الحديث السادس والعشرون"+"\n"+"( كثرة طرق الخير )"));
        fortyList.add(new Rec_azkar_items("الحديث السابع والعشرون"+"\n"+"( تعريف البر والإثم )"));
        fortyList.add(new Rec_azkar_items("الحديث الثامن والعشرون"+"\n"+"( السمع والطاعة )"));
        fortyList.add(new Rec_azkar_items("الحديث التاسع والعشرون"+"\n"+"( بواب الخير )"));
        fortyList.add(new Rec_azkar_items("الحديث الثلاثون "+"\n"+"( الوقوف عند حدود الشرع )"));
        fortyList.add(new Rec_azkar_items("الحديث الحادي والثلاثون "+"\n"+"( الزهد في الدنيا )"));
        fortyList.add(new Rec_azkar_items("الحديث الثاني والثلاثون"+"\n"+"( لاضرر ولا ضرار )"));
        fortyList.add(new Rec_azkar_items("الحديث الثالث والثلاثون"+"\n"+"( البيّنة على المُدَّعي )"));
        fortyList.add(new Rec_azkar_items("الحديث الرابع والثلاثون"+"\n"+"( تغيير المنكر فريضة )"));
        fortyList.add(new Rec_azkar_items("الحديث الخامس والثلاثون"+"\n"+"( المسلم أخو المسلم )"));
        fortyList.add(new Rec_azkar_items("الحديث السادس والثلاثون"+"\n"+"( قضاء حوائج المسلمين )"));
        fortyList.add(new Rec_azkar_items("الحديث السابع والثلاثون"+"\n"+"( الترغيب في فعل الحسنات )"));
        fortyList.add(new Rec_azkar_items("الحديث الثامن والثلاثون"+"\n"+"( جزاء معادات الأولياء )"));
        fortyList.add(new Rec_azkar_items("الحديث التاسع والثلاثون"+"\n"+"( التجاوز عن الخطأ والنسيان )"));
        fortyList.add(new Rec_azkar_items("الحديث الأربعون "+"\n"+"( كن في الدنيا كأنك غريب )"));
        fortyList.add(new Rec_azkar_items("الحديث الحادي و الأربعون "+"\n"+"( اتباع النبي صلى الله عليه وسلم )"));
        fortyList.add(new Rec_azkar_items("الحديث الثاني و الأربعون "+"\n"+"( سعة مغفرة الله )"));

        RecyclerView recyclerforty = findViewById(R.id.rvHadith);

        FortyAdapter fortyAdapter = new FortyAdapter( (ArrayList<Rec_azkar_items>) fortyList, getContext());

        recyclerforty.setAdapter(fortyAdapter);
        recyclerforty.setHasFixedSize(true);
        // recyclerforty.addItemDecoration(new DividerItemDecoration(getContext() , DividerItemDecoration.VERTICAL));

        fortyAdapter.setListner(itemf -> {
            int index = (int) itemf;
            Intent forty = new Intent(getBaseContext(), FortyActivity.class);
            forty.putExtra("index", index);
            startActivity(forty);
        });
    }}
