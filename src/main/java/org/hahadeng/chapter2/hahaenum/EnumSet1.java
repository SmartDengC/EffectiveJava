package org.hahadeng.chapter2.hahaenum;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * @author: HaHaDeng
 */

public class EnumSet1 {
    enum Size{
        SMALL, MEDIUE,  LARGE
    }
    public static void main(String[] args) {
        // allOf() 方法创建一个枚举集， 其中包含指定枚举类型Size的所有值
        EnumSet<Size> sizes = EnumSet.allOf(Size.class);
        // [SMALL, MEDIUE, LARGE]
        System.out.println(sizes);

        // noneOf() 创建一个空的set
        EnumSet<Size> sizes1 = EnumSet.noneOf(Size.class);
        System.out.println("空EnumSet: " + sizes1);

        // rangeOf() 创建一个from to
        EnumSet<Size> range = EnumSet.range(Size.MEDIUE, Size.LARGE);
        // [MEDIUE, LARGE]
        System.out.println(range);
        List<String> list = new ArrayList();
    }
}
