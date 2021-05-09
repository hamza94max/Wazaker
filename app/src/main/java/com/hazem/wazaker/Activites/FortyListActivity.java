package com.hazem.wazaker.Activites;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.hazem.wazaker.Adapters.FortyListAdapter;
import com.hazem.wazaker.Models.Azkar_model;
import com.hazem.wazkar.R;
import java.util.ArrayList;
import java.util.List;


import static java.security.AccessController.getContext;

public class FortyListActivity extends AppCompatActivity {
    private List<Azkar_model> Hadith_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortylist);
        loadData();
    }

    private void loadData() {
        Hadith_list = new ArrayList<>();
        Hadith_list.add(new Azkar_model("الحديث الأول "+"\n"+"( الأعمال بالنيات )"));
        Hadith_list.add(new Azkar_model( "الحديث الثاني "+"\n"+"( مراتب الدين )"));
        Hadith_list.add(new Azkar_model("الحديث الثالث "+"\n"+"( أركان الإسلام )"));
        Hadith_list.add(new Azkar_model("الحديث الرابع "+"\n"+"( مراحل الخلق )"));
        Hadith_list.add(new Azkar_model("الحديث الخامس "+"\n"+"( النهي عن الابتداع في الدين )"));
        Hadith_list.add(new Azkar_model("الحديث السادس "+"\n"+"( البعد عن مواطن الشبهات )"));
        Hadith_list.add(new Azkar_model("الحديث السابع "+"\n"+"( الدين النصيحة )"));
        Hadith_list.add(new Azkar_model("الحديث الثامن "+"\n"+"( حرمة دم المسلم وماله )"));
        Hadith_list.add(new Azkar_model("الحديث التاسع "+"\n"+"( النهي عن كثرة السؤال والتشدد )"));
        Hadith_list.add(new Azkar_model("الحديث العاشر "+"\n"+"( سبب إجابة الدعاء )"));
        Hadith_list.add(new Azkar_model("الحديث الحادي عشر "+"\n"+"( اترك ما شككت فيه )"));
        Hadith_list.add(new Azkar_model("الحديث الثاني عشر "+"\n"+"( الاشتغال بما يفيد )"));
        Hadith_list.add(new Azkar_model("الحديث الثالث عشر"+"\n"+"( من كمال الإيمان )"));
        Hadith_list.add(new Azkar_model("الحديث الرابع عشر "+"\n"+"( متى يهدر دم المسلم )"));
        Hadith_list.add(new Azkar_model("الحديث الخامس عشر"+"\n"+"( اكرام الضيف )"));
        Hadith_list.add(new Azkar_model("الحديث السادس عشر"+"\n"+"( النهي عن الغضب )"));
        Hadith_list.add(new Azkar_model("الحديث السابع عشر"+"\n"+"( الرفق بالحيوان )"));
        Hadith_list.add(new Azkar_model("الحديث الثامن عشر"+"\n"+"( الخلق الحسن )"));
        Hadith_list.add(new Azkar_model("الحديث التاسع عشر"+"\n"+"( الإيمان بالقضاء والقدر )"));
        Hadith_list.add(new Azkar_model("الحديث العشرون "+"\n"+"( الحياء من الإيمان )"));
        Hadith_list.add(new Azkar_model("الحديث الحادي والعشرون"+"\n"+"( الاستقامه بالإسلام )"));
        Hadith_list.add(new Azkar_model("الحديث الثاني والعشرون "+"\n"+"( الطريق إلى الجنة )"));
        Hadith_list.add(new Azkar_model("الحديث الثالث والعشرون"+"\n"+"( جوامع الخير )"));
        Hadith_list.add(new Azkar_model("الحديث الرابع والعشرون"+"\n"+"( من فضل الله على الناس )"));
        Hadith_list.add(new Azkar_model("الحديث الخامس والعشرون"+"\n"+"( فضل الذكر )"));
        Hadith_list.add(new Azkar_model("الحديث السادس والعشرون"+"\n"+"( كثرة طرق الخير )"));
        Hadith_list.add(new Azkar_model("الحديث السابع والعشرون"+"\n"+"( تعريف البر والإثم )"));
        Hadith_list.add(new Azkar_model("الحديث الثامن والعشرون"+"\n"+"( السمع والطاعة )"));
        Hadith_list.add(new Azkar_model("الحديث التاسع والعشرون"+"\n"+"( بواب الخير )"));
        Hadith_list.add(new Azkar_model("الحديث الثلاثون "+"\n"+"( الوقوف عند حدود الشرع )"));
        Hadith_list.add(new Azkar_model("الحديث الحادي والثلاثون "+"\n"+"( الزهد في الدنيا )"));
        Hadith_list.add(new Azkar_model("الحديث الثاني والثلاثون"+"\n"+"( لاضرر ولا ضرار )"));
        Hadith_list.add(new Azkar_model("الحديث الثالث والثلاثون"+"\n"+"( البيّنة على المُدَّعي )"));
        Hadith_list.add(new Azkar_model("الحديث الرابع والثلاثون"+"\n"+"( تغيير المنكر فريضة )"));
        Hadith_list.add(new Azkar_model("الحديث الخامس والثلاثون"+"\n"+"( المسلم أخو المسلم )"));
        Hadith_list.add(new Azkar_model("الحديث السادس والثلاثون"+"\n"+"( قضاء حوائج المسلمين )"));
        Hadith_list.add(new Azkar_model("الحديث السابع والثلاثون"+"\n"+"( الترغيب في فعل الحسنات )"));
        Hadith_list.add(new Azkar_model("الحديث الثامن والثلاثون"+"\n"+"( جزاء معادات الأولياء )"));
        Hadith_list.add(new Azkar_model("الحديث التاسع والثلاثون"+"\n"+"( التجاوز عن الخطأ والنسيان )"));
        Hadith_list.add(new Azkar_model("الحديث الأربعون "+"\n"+"( كن في الدنيا كأنك غريب )"));
        Hadith_list.add(new Azkar_model("الحديث الحادي و الأربعون "+"\n"+"( اتباع النبي صلى الله عليه وسلم )"));
        Hadith_list.add(new Azkar_model("الحديث الثاني و الأربعون "+"\n"+"( سعة مغفرة الله )"));

        RecyclerView Hadith_recycle = findViewById(R.id.rvHadith);

        FortyListAdapter fortyAdapter = new FortyListAdapter( (ArrayList<Azkar_model>) Hadith_list, getContext());

        Hadith_recycle.setAdapter(fortyAdapter);
        Hadith_recycle.setHasFixedSize(true);

        fortyAdapter.setListner(itemf -> {
            int index = (int) itemf;
            Intent forty = new Intent(getBaseContext(), FortyActivity.class);
            forty.putExtra("index", index);
            startActivity(forty);
        });
    }}
