package com.islamey.hamza.wazaker.domain.Models

data class HijriDateResponse(
    val code: Int,
    val `data`: HijriDateData,
    val status: String
)

data class HijriDateData(
    val gregorian: Gregorian,
    val hijri: Hijri
)

data class Gregorian(
    val date: String,
    val day: String,
    val designation: Designation,
    val format: String,
    val month: Month,
    val weekday: Weekday,
    val year: String
)

data class Hijri(
    val date: String,
    val day: String,
    val designation: Designation,
    val format: String,
    val holidays: List<String>,
    val month: ArabicMonth,
    val weekday: ArabicWeekday,
    val year: String
)

data class Designation(
    val abbreviated: String,
    val expanded: String
)

data class Month(
    val en: String,
    val number: Int
)

data class ArabicMonth(
    val ar: String,
    val en: String,
    val number: Int
)

data class Weekday(
    val en: String
)

data class ArabicWeekday(
    val ar: String,
    val en: String
)