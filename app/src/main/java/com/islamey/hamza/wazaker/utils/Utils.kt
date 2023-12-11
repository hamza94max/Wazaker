package com.islamey.hamza.wazaker.utils

import android.content.Context
import android.content.Intent
import com.islamey.hamza.wazaker.domain.Models.HijriDateResponse
import org.apache.commons.lang3.StringEscapeUtils
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Utils {

    fun getCurrentDate(): String {
        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        return currentDate.format(formatter)
    }

    fun saveDarkModeState(context: Context, isDark: Boolean) {
        val sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putBoolean("darkMode", isDark)
        editor.apply()
    }

    fun getDarkModeState(context: Context): Boolean {
        val sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)

        return sharedPreferences.getBoolean("darkMode", false)
    }


    fun shareText(context: Context, text: String) {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, text)
        sendIntent.type = "text/plain"

        val shareIntent = Intent.createChooser(sendIntent, null)
        context.startActivity(shareIntent)
    }

    fun getFormattedHijriDate(response: HijriDateResponse): String {
        return buildString {
            append(StringEscapeUtils.unescapeJava(response.data.hijri.weekday.ar))
            append(" ")
            append(response.data.hijri.day)
            append(" ")
            append(StringEscapeUtils.unescapeJava(response.data.hijri.month.ar))
            append(" ")
            append(StringEscapeUtils.unescapeJava(response.data.hijri.year))
            append(" ")
            append("هجريا")
        }
    }


}