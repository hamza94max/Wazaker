package com.islamic.Wazaker.Data.DataSets

import com.islamic.Wazaker.Data.Models.AzkarListModel

object AzkarListDataset {
    private lateinit var azkarList: MutableList<AzkarListModel>

    fun getAzkarList(): List<AzkarListModel> {
        azkarList = ArrayList()
        azkarList.add(AzkarListModel("أذكار المسجد"))
        azkarList.add(AzkarListModel("أذكار بعد الصلاة "))
        azkarList.add(AzkarListModel("أذكار الأذان "))
        azkarList.add(AzkarListModel("أذكار الوضوء"))
        azkarList.add(AzkarListModel("الأدعيـة القرآنية"))
        azkarList.add(AzkarListModel("الأدعية النبوية "))
        azkarList.add(AzkarListModel("أذكار الطعام"))
        azkarList.add(AzkarListModel("أذكار المنزل"))
        azkarList.add(AzkarListModel("أذكار النوم"))
        azkarList.add(AzkarListModel("أذكار الإستيقاظ من النوم"))
        azkarList.add(AzkarListModel("أذكار عظيمة"))
        azkarList.add(AzkarListModel("دعاء السفر"))
        azkarList.add(AzkarListModel("دعاء ختم القرآن الكريم"))
        azkarList.add(AzkarListModel("فضل الدعاء"))
        azkarList.add(AzkarListModel("فضل تلاوة القرآن الكريم"))
        azkarList.add(AzkarListModel("فضل الأذكار"))
        azkarList.add(AzkarListModel("الرقية الشرعية"))
        azkarList.add(AzkarListModel("أدعية للمتوفّي"))

        return azkarList
    }
}