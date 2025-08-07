package org.hahadeng.structHub;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 邓聪
 */
public class Solution {
    public String destCity(List<List<String>> paths) {
//        new Deque<>()
        // 差集
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        for(List<String> x: paths){
            l1.add(x.get(0));
            l2.add(x.get(1));
        }

        List<String> ans = l2.stream().filter(x -> !l1.contains(x)).collect(Collectors.toList());
        return ans.get(0);
    }
    public List<Integer> list1(){
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        System.out.println("l1 = " + l1);
        return l1;
    }

    public List<Integer> list2(){
        // 不可变化
        List<Integer> list = Arrays.asList(1, 2, 3);
        // 可变化
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        list2.add(5);
        System.out.println(list2);
        return list2;
    }
    public List<Integer> list3(){
        // 匿名内部类
        List<Integer> list3 = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};
        System.out.println(list3);
        return list3;
    }

    public List<Integer> list4(){
        List<Integer> list4 = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        System.out.println(list4);
        return list4;
    }
    public List<Integer> list5(){
        // pom里面需要加入com.google.guava的依赖
        List<Integer> list5 = Lists.newArrayList(1, 2, 3, 4);
        System.out.println(list5);
        return list5;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.list1();
        solution.list2();
        solution.list3();
        solution.list4();
        solution.list5();

    }
}
