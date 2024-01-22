package com.example.mydiary.presentation.utils

fun convertDateFormat(year: Int, month: Int): String {
    return if (month < 10) "$year 0$month" else "$year $month"
}