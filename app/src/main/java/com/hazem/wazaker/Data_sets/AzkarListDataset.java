package com.hazem.wazaker.Data_sets;

import com.hazem.wazaker.Models.AzkarModel;

import java.util.ArrayList;
import java.util.List;

public class AzkarListDataset {

    public static List<AzkarModel> azkarList;

    public static List<AzkarModel> getAzkarList() {

        azkarList = new ArrayList<>();
        azkarList.add(new AzkarModel("أذكار المسجد"));
        azkarList.add(new AzkarModel("أذكار بعد الصلاة "));
        azkarList.add(new AzkarModel("أذكار الأذان "));
        azkarList.add(new AzkarModel("أذكار الوضوء"));
        azkarList.add(new AzkarModel("الأدعيـة القرآنية"));
        azkarList.add(new AzkarModel("الأدعية النبوية "));
        azkarList.add(new AzkarModel("أذكار الطعام"));
        azkarList.add(new AzkarModel("أذكار المنزل"));
        azkarList.add(new AzkarModel("أذكار النوم"));
        azkarList.add(new AzkarModel("أذكار الإستيقاظ من النوم"));
        azkarList.add(new AzkarModel("أذكار عظيمة"));
        azkarList.add(new AzkarModel("دعاء السفر"));
        azkarList.add(new AzkarModel("دعاء ختم القرآن الكريم"));
        azkarList.add(new AzkarModel("فضل الدعاء"));
        azkarList.add(new AzkarModel("فضل تلاوة القرآن الكريم"));
        azkarList.add(new AzkarModel("فضل الأذكار"));
        azkarList.add(new AzkarModel("الرقية الشرعية"));
        azkarList.add(new AzkarModel("أدعية للمتوفّي"));

        return azkarList;
    }}
