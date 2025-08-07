package org.hahadeng.dp.mycomposite;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.google.common.collect.TreeMultiset;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalQueries;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * main
 *
 * @author 邓聪
 * @since 2025/6/4 18:32
 */
public class Main {
    public static void main(String[] args) {
        cityExample();
    }


    static void cityExample() {
        final Logger logger = Logger.getLogger(Main.class.getName());
        Province sc = new Province("四川");

        City chengdu = new City("成都");

        chengdu.addDistract(new Distract("锦江区", 1000));
        chengdu.addDistract(new Distract("青羊区", 2000));
        chengdu.addDistract(new Distract("高新区", 3000));

        // sc.addCity(chengdu);
        // logger.info(String.valueOf(sc.computePopulation()));

    }

    @Test
    public void test() {
        // false
        System.out.println(BeanUtil.isBean(HashMap.class));
        // 按自然排序，可重复的set
        TreeMultiset<Integer> set = TreeMultiset.create();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(2);
        System.out.println(set);
    }

    @Test
    public void test1() {
        Province province = new Province("四川");
        String jsonString = JSON.toJSONString(province);
        JSONObject jsonObject = JSON.parseObject(jsonString);
        Object o = jsonObject.get("name");
        System.out.println(o);
    }

    @Test
    public void test2() {
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = fm.format(LocalDateTime.now());

        DateTimeFormatter.ofPattern("HH:mm:ss");
        // 2025-06-13
        DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
        // 2025-06-13T14:53:12.362352
        DateTimeFormatter fm2 = DateTimeFormatter.ISO_DATE_TIME;
        // 2025-06-13T14:54:21.303763
        DateTimeFormatter fm3 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 20250613
        DateTimeFormatter fm4 = DateTimeFormatter.BASIC_ISO_DATE;
        // 14:55:26.365629
        DateTimeFormatter fm5 = DateTimeFormatter.ISO_LOCAL_TIME;

        // LocalDate 是年月日
        // LocalDateTime 是年月日时分秒
        // LocalTime 是时分秒

        LocalDateTime now = LocalDateTime.now();

        // 使用预定义的格式化器
        // 2023-11-15
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE));
        // 14:30:45.123
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_TIME));
        // 2023-11-15T14:30:45.123
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));


        String t1 = "2025-01-11 00:00:00";
        String t2 = "2025-01-11 11:00:00";
        LocalTime parse = fm.parse(t1, TemporalQueries.localTime());
        LocalDate parse1 = fm.parse(t1, TemporalQueries.localDate());

        LocalDateTime query = fm.parse(t1).query(LocalDateTime::from);
        LocalDateTime query1 = fm.parse(t2).query(LocalDateTime::from);
        int i = query.compareTo(query1);
        System.out.println(i);
    }

    @Test
    public void test3() {
        Date date = new Date();
        // 返回当前系统默认的时区
        ZoneId zoneId = ZoneId.systemDefault();

        // atZone()方法返回在指定时区,从该Instant生成的ZonedDateTime
        ZonedDateTime zonedDateTime = date.toInstant().atZone(zoneId);
        LocalDate localDate = zonedDateTime.toLocalDate();
        LocalTime localTime = zonedDateTime.toLocalTime();
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
    }

    @Test
    public void test4() {
        // 新建一个Date对象
        Date date = new Date();

        // 获取当前系统默认的时区
        ZoneId zoneId = ZoneId.systemDefault();
        // 转化
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zoneId);
        LocalDate localDate = LocalDate.ofInstant(date.toInstant(), zoneId);
        LocalTime localTime = LocalTime.ofInstant(date.toInstant(), zoneId);


        LocalTime now = LocalTime.now();

    }

    @Test
    public void test5() {
        Deque<Integer> s = new ArrayDeque<>();

        int[] nums = {1, 2, 3};
        for (int x : nums) {
            s.push(x);
        }
        while (!s.isEmpty()) {
            // out 1,2,3
            System.out.println(s.pop());
        }
        s.push(1);
        Integer peek = s.peek();

        // out 1
        System.out.println(peek);

    }
}
