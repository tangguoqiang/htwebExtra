package com.ht.extra.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Dell on 2016/12/22.
 */
public class DateToWeek {
    public final static String weekName[] = {"1","2","3","4","5","6","7"};
    public static LinkedHashMap<String,String> forDateToWeek(String beginDate, String endDate) {
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();
        Date begin = formatDate(beginDate,"yyyy-MM-dd");
        Date end = formatDate(endDate,"yyyy-MM-dd");
        while(!begin.after(end)){
            hashMap.put(formatDateString(begin,"yyyy-MM-dd"),getWeek(begin));
            begin = dayAdd(begin,1);
        }
        return hashMap;
    }

    /**
     * String转Date
     * @param
     * @param formater
     * @return
     */
    public static Date formatDate(String dateString,String formater){
        SimpleDateFormat format = new SimpleDateFormat(formater);
        Date date1 =null;
        try {
            date1 = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

    /**
     * Date类型格式化String
     * @param date
     * @param formater
     * @return
     */
    public static String formatDateString(Date date,String formater){
        SimpleDateFormat format = new SimpleDateFormat(formater);
        String dateString =null;
        dateString = format.format(date);
        return dateString;
    }

    /**
     * 获得时间对于的星期（1-7）
     * @param date
     * @return
     */
    public static String getWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek<0)
            dayOfWeek=0;
        return (weekName[dayOfWeek-1]);
    }

    /**
     * 加减后的天数
     * @param date 日期
     * @param i 需要加减的天数，减用负数表示
     * @return
     */
    private static Date dayAdd(Date date,int i){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE,i);
        return calendar.getTime();
    }
}
