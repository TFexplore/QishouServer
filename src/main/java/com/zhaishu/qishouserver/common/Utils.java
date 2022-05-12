package com.zhaishu.qishouserver.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    /**
     * 获得当前日期 yyyy-MM-dd HH:mm:ss
     *
     * @return 2019-08-27 14:12:40
     */
    public static String getCurrentTime() {
        // 小写的hh取得12小时，大写的HH取的是24小时
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return df.format(date);
    }
    /**
     * 获取当前日期 yy-MM-dd
     *
     * @return 2019-08-27
     */
    public static Integer getDateByInteger(Integer i) {
        Calendar c = Calendar.getInstance();

        c.add(Calendar.DATE, +i);
        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return Integer.valueOf(sdf.format(date));
    }


}
