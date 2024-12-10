package org.hahadeng.structHub;

import org.hahadeng.test.T1;
import org.hahadeng.test.T2;

import java.util.*;

public class SetHub implements T1, T2 {
    static void tSet(){
        // HashSet, LinkedSet, TreeSet
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.indexOf(1);
        integers1.add(1);
        integers1.add(1);
        // 倒叙
        TreeSet<Integer> integers = new TreeSet<>((v1, v2) -> v2 - v1);
        integers.add(1);
        integers.add(2);
        integers.add(0);
        for(Integer x: integers){
            System.out.println(x);
        }

    }
    public static void main(String[] args) {
        SetHub.tSet();
    }

    @Override
    public void function1() {
        ArrayList<Integer> integers = new ArrayList<>();
//        integers.removeIf();
        Objects.requireNonNull(integers);
        // 判断- 0


    }

    @Override
    public void function2() {

    }
}
