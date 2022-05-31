package com.example.lets_talk.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

class Utility {

    @SuppressLint("SimpleDateFormat")
    fun convertDate(date: String): SimpleDateFormat {
        return SimpleDateFormat("dd-MM-yyyy")
    }
}