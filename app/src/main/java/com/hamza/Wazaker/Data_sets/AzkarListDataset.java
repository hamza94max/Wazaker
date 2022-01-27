package com.hamza.Wazaker.Data_sets;

import com.hamza.Wazaker.Models.AzkarListModel;

import java.util.ArrayList;
import java.util.List;

public class AzkarListDataset {

    public static List<AzkarListModel> azkarList;

    public static List<AzkarListModel> getAzkarList() {

        azkarList = new ArrayList<>();

        azkarList.add(new AzkarListModel("أذكار المسجد"));
        azkarList.add(new AzkarListModel("أذكار بعد الصلاة "));
        azkarList.add(new AzkarListModel("أذكار الأذان "));
        azkarList.add(new AzkarListModel("أذكار الوضوء"));
        azkarList.add(new AzkarListModel("الأدعيـة القرآنية"));
        azkarList.add(new AzkarListModel("الأدعية النبوية "));
        azkarList.add(new AzkarListModel("أذكار الطعام"));
        azkarList.add(new AzkarListModel("أذكار المنزل"));
        azkarList.add(new AzkarListModel("أذكار النوم"));
        azkarList.add(new AzkarListModel("أذكار الإستيقاظ من النوم"));
        azkarList.add(new AzkarListModel("أذكار عظيمة"));
        azkarList.add(new AzkarListModel("دعاء السفر"));
        azkarList.add(new AzkarListModel("دعاء ختم القرآن الكريم"));
        azkarList.add(new AzkarListModel("فضل الدعاء"));
        azkarList.add(new AzkarListModel("فضل تلاوة القرآن الكريم"));
        azkarList.add(new AzkarListModel("فضل الأذكار"));
        azkarList.add(new AzkarListModel("الرقية الشرعية"));
        azkarList.add(new AzkarListModel("أدعية للمتوفّي"));

        return azkarList;
    }}
