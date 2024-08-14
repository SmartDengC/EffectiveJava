package org.hahadeng.learnHub;

import sun.jvm.hotspot.utilities.Assert;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * StreamHub
 *
 * @author 邓聪
 */
public class StreamHub {
    public static void create(){
        int[] arr = {1,2,3,4};
        IntStream stream = Arrays.stream(arr);
        // stream.forEach(System.out::println);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> limit = integerStream.limit(3);

        Optional<Integer> first = limit.filter(x -> x > 2).findFirst();
        Optional<Integer> first1 = limit.parallel().filter(x -> x > 2).findFirst();
        first.ifPresent(System.out::println);
        limit.forEach(System.out::println);
    }
    public static void learn(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));

        // findFirst(), findAny() 都返回的是Optional对象，Optional.isPresent()

        // 获取String集合钟最长的元素
        List<String> list = Arrays.asList("admin", "root", "me", "denh");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        max.ifPresent(System.out::println);

        // 获取到最大的数字
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> max1 = list1.stream().max(Integer::compareTo);
        max1.ifPresent(System.out::println);


    }

    public static void main(String[] args) {
        // StreamHub.create();
        StreamHub.learn();
    }
}
