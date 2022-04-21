package com.example.zatca_qr_generation;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateUtil {
    public static final String DATE_FORMAT_6 = "yyyy-MM-dd HH:mm:ss";

    public static String getCurrentDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_6, Locale.ENGLISH);
        String strDate = sdf.format(c.getTime());
        return strDate;
    }
}
