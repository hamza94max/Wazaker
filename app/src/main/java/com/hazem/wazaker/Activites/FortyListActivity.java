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
    private List<Rec_azkar_items> Hadith_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forty);
        loadData();
    }

    private void loadData() {
        Hadith_list = new ArrayList<>();
        Hadith_list.add(new Rec_azkar_items("الحديث الأول "+"\n"+"( الأعمال بالنيات )"));
        Hadith_list.add(new Rec_azkar_items( "الحديث الثاني "+"\n"+"( مراتب الدين )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الثالث "+"\n"+"( أركان الإسلام )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الرابع "+"\n"+"( مراحل الخلق )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الخامس "+"\n"+"( النهي عن الابتداع في الدين )"));
        Hadith_list.add(new Rec_azkar_items("الحديث السادس "+"\n"+"( البعد عن مواطن الشبهات )"));
        Hadith_list.add(new Rec_azkar_items("الحديث السابع "+"\n"+"( الدين النصيحة )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الثامن "+"\n"+"( حرمة دم المسلم وماله )"));
        Hadith_list.add(new Rec_azkar_items("الحديث التاسع "+"\n"+"( النهي عن كثرة السؤال والتشدد )"));
        Hadith_list.add(new Rec_azkar_items("الحديث العاشر "+"\n"+"( سبب إجابة الدعاء )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الحادي عشر "+"\n"+"( اترك ما شككت فيه )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الثاني عشر "+"\n"+"( الاشتغال بما يفيد )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الثالث عشر"+"\n"+"( من كمال الإيمان )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الرابع عشر "+"\n"+"( متى يهدر دم المسلم )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الخامس عشر"+"\n"+"( اكرام الضيف )"));
        Hadith_list.add(new Rec_azkar_items("الحديث السادس عشر"+"\n"+"( النهي عن الغضب )"));
        Hadith_list.add(new Rec_azkar_items("الحديث السابع عشر"+"\n"+"( الرفق بالحيوان )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الثامن عشر"+"\n"+"( الخلق الحسن )"));
        Hadith_list.add(new Rec_azkar_items("الحديث التاسع عشر"+"\n"+"( الإيمان بالقضاء والقدر )"));
        Hadith_list.add(new Rec_azkar_items("الحديث العشرون "+"\n"+"( الحياء من الإيمان )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الحادي والعشرون"+"\n"+"( الاستقامه بالإسلام )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الثاني والعشرون "+"\n"+"( الطريق إلى الجنة )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الثالث والعشرون"+"\n"+"( جوامع الخير )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الرابع والعشرون"+"\n"+"( من فضل الله على الناس )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الخامس والعشرون"+"\n"+"( فضل الذكر )"));
        Hadith_list.add(new Rec_azkar_items("الحديث السادس والعشرون"+"\n"+"( كثرة طرق الخير )"));
        Hadith_list.add(new Rec_azkar_items("الحديث السابع والعشرون"+"\n"+"( تعريف البر والإثم )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الثامن والعشرون"+"\n"+"( السمع والطاعة )"));
        Hadith_list.add(new Rec_azkar_items("الحديث التاسع والعشرون"+"\n"+"( بواب الخير )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الثلاثون "+"\n"+"( الوقوف عند حدود الشرع )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الحادي والثلاثون "+"\n"+"( الزهد في الدنيا )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الثاني والثلاثون"+"\n"+"( لاضرر ولا ضرار )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الثالث والثلاثون"+"\n"+"( البيّنة على المُدَّعي )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الرابع والثلاثون"+"\n"+"( تغيير المنكر فريضة )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الخامس والثلاثون"+"\n"+"( المسلم أخو المسلم )"));
        Hadith_list.add(new Rec_azkar_items("الحديث السادس والثلاثون"+"\n"+"( قضاء حوائج المسلمين )"));
        Hadith_list.add(new Rec_azkar_items("الحديث السابع والثلاثون"+"\n"+"( الترغيب في فعل الحسنات )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الثامن والثلاثون"+"\n"+"( جزاء معادات الأولياء )"));
        Hadith_list.add(new Rec_azkar_items("الحديث التاسع والثلاثون"+"\n"+"( التجاوز عن الخطأ والنسيان )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الأربعون "+"\n"+"( كن في الدنيا كأنك غريب )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الحادي و الأربعون "+"\n"+"( اتباع النبي صلى الله عليه وسلم )"));
        Hadith_list.add(new Rec_azkar_items("الحديث الثاني و الأربعون "+"\n"+"( سعة مغفرة الله )"));

        RecyclerView Hadith_recycle = findViewById(R.id.rvHadith);

        FortyAdapter fortyAdapter = new FortyAdapter( (ArrayList<Rec_azkar_items>) Hadith_list, getContext());

        Hadith_recycle.setAdapter(fortyAdapter);
        Hadith_recycle.setHasFixedSize(true);

        fortyAdapter.setListner(itemf -> {
            int index = (int) itemf;
            Intent forty = new Intent(getBaseContext(), FortyActivity.class);
            forty.putExtra("index", index);
            startActivity(forty);
        });
    }}
