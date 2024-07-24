package org.hahadeng.chapter3;

import java.util.ArrayList;

/**
 * @author: HaHaDeng
 */

public class SelfObject {

    public static void seeObject(){
        Object object = new Object();
        // Object 具有的非final方法
        // clone, equals, hashCode, toString...

        ArrayList<Integer> lit1 = new ArrayList<Integer>();
        ArrayList<Integer> lis2 = new ArrayList<Integer>();

        lis2.add(1);
        lit1.add(1);
        // equal 就是判断值，==是判断地址
        System.out.println(lis2.equals(lit1));
        System.out.println(lit1 == lit1);

    }

    public static void main(String[] args) {
        SelfObject.seeObject();
    }
}
