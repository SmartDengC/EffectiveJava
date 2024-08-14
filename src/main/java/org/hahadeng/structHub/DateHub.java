package org.hahadeng.structHub;

import java.util.Calendar;
import java.util.Date;

/**
 * Date
 *
 * @author 邓聪
 */
public class DateHub {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        // 月份是从0开始算的
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int dayMin = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        int dayMax = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
