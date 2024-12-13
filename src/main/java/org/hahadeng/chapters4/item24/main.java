package org.hahadeng.chapters4.item24;

import java.util.*;

/**
 * @author 邓聪
 */
public class main {

    public static void main(String[] args) {
        StaticInnerClass instance = StaticInnerClass.getInstance();
        StaticInnerClass2.InnerClass2 innerClass2 = new StaticInnerClass2.InnerClass2();
        innerClass2.hello();
        ArrayList<Integer> integers = new ArrayList<>();
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        Integer[] it2 = integers.toArray(new Integer[0]);
    }

}
