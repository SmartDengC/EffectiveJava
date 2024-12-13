package org.hahadeng.chapter5.item30;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class Set0Test {

    @Test
    void union() {
        Set0 set0 = new Set0();
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        Set<Integer> set3 = Set0.union(set1, set2);
        for(Integer i : set3){
            System.out.println(i);
        }
        Collections.reverseOrder();
        List<Object> objects = Collections.emptyList();
        Function<Object, Object> identity = Function.identity();

    }

    @Test
    void union1() {
        String[] strings = {"1", "2"};
    }

    @Test
    void max() {
        List<Integer> c = Arrays.asList(1,2,3,4);
        Integer max = Set0.max(c);
        System.out.println(max);
    }
}
