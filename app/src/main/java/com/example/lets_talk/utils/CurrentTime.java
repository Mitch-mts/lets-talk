package com.example.lets_talk.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Hp on 25/3/2019.
 */
public class CurrentTime {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Date getCurrentDate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());
        return date;
    }

}
