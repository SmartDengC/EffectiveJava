package org.hahadeng.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void date2String() {
        System.out.println(DateUtil.date2String(new Date(), DateUtil.YYYY_MM_DD_HH_MM_SS));
        System.out.println(DateUtil.date2String(new Date(), DateUtil.YYYY_MM_DD));
    }

    @Test
    void string2Date() {
    }

    @Test
    void testString2Date() {
    }

    @Test
    void str2SqlDate() {
    }

    @Test
    void getCurrentYearMonth() {

    }

    @Test
    void getCurrentMonth() {
        System.out.println(DateUtil.getCurrentMonth());
    }

    @Test
    void getCurrentYear() {
    }

    @Test
    void getFormatCurrentTime() {
    }

    @Test
    void addMonths() {
        System.out.println(DateUtil.addMonth("202409", 1));
    }

    @Test
    void addSecond() {
    }

    @Test
    void allHours() {
    }

    @Test
    void nextDate() {
    }

    @Test
    void isLeapYear() {
    }

    @Test
    void dateDiff() {
    }

    @Test
    void dateDiffNoTime() {
    }

    @Test
    void getFirstDateOfMonth() {
        System.out.println(DateUtil.getFirstDateOfMonth("20241031"));
    }

    @Test
    void getLastDateOfMonth() {
        System.out.println(DateUtil.getLastDateOfMonth("20241031"));
    }

    @Test
    void getMondayOfThisWeek() {
    }

    @Test
    void getSundayOfThisWeek() {
    }

    @Test
    void getMondayOfWeek() {
    }

    @Test
    void getWeekCountOfMonth() {
    }

    @Test
    void getDaysOfMonth() {
    }

    @Test
    void getDaysOfCurMonth() {
    }

    @Test
    void getDayIndexOfWeek() {
    }

    @Test
    void testGetDayIndexOfWeek() {
    }

    @Test
    void getWeekIndexOfMonth() {
    }

    @Test
    void getIntYearOfDate() {
    }

    @Test
    void getIntMonthOfDate() {
        System.out.println(DateUtil.getIntMonthOfDate("20241031"));
        System.out.println(DateUtil.getIntMonthOfDate("2024-10-31"));
    }

    @Test
    void getIntDayOfDate() {
        System.out.println(DateUtil.getIntDayOfDate("2024-10-31"));
        String day = "2024-10-31";
        System.out.println(day.substring(8));
    }

    @Test
    void getMonthName() {
    }

    @Test
    void sortDateVectorAsc() {
    }

    @Test
    void trimMillis() {
    }

    @Test
    void getOffsetDate() {
    }

    @Test
    void getDayList() {
    }

    @Test
    void getWeekList() {
    }

    @Test
    void testGetWeekList() {
    }

    @Test
    void getMonthList() {
    }

    @Test
    void getYearList() {
    }

    @Test
    void formatDate() {
    }

    @Test
    void formatDateToCN() {
    }

    @Test
    void getDateObj() {
    }

    @Test
    void testGetDateObj() {
    }

    @Test
    void addMonth() {
    }

    @Test
    void verifyDate() {
    }

    @Test
    void getToday() {
    }

    @Test
    void lastFewDay() {
    }

    @Test
    void lastFewMon() {
    }

    @Test
    void getStepDay() {
    }

    @Test
    void getStepMonth() {
    }

    @Test
    void getStepYear() {
    }

    @Test
    void getLastDate() {
    }

    @Test
    void getDateOfLastMonth() {
    }

    @Test
    void getFrontBackStrDate() {
    }

    @Test
    void getFrontBackStrDate1() {
    }

    @Test
    void getFrontYearStrDate() {
    }

    @Test
    void getFrontYearStrDate1() {
    }

    @Test
    void getAlldays() {
    }

    @Test
    void getFrontMonthList() {
    }

    @Test
    void getFrontMonthList2() {
    }

    @Test
    void getAllMonths() {
    }

    @Test
    void getFrontYearList() {
    }

    @Test
    void getFrontYearList2() {
    }

    @Test
    void getDateToWeek() {
    }

    @Test
    void getNDaysList() {
    }
}
