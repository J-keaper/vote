package com.keaper.vote.common.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {



    public static Date addDay(Date myDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.DAY_OF_MONTH, amount);
        return cal.getTime();
    }

}
