package org.hahadeng.chapter5.item30;

import java.util.*;

/**
 * 泛型方法
 * @author 邓聪
 */
public class Set0 implements Set0Interface{

    /**
     *  类型参数列表为<E>, 返回类型为Set<E>。
     */
    public static <E> Set<E> union(Set<E> set1, Set<E> set2) {
        Set<E> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public <E> Set<E> union1(Set<E> s1){
        return new HashSet<>();
    }

    /**
     * <E extends Comparable<E>> 类型限定， 表示可以与自身比较的任何类型E
     * E 表示返回的类型
     */
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if(c.isEmpty()){
            throw new IllegalArgumentException("Empty collection");
        }
        E result = null;
        for(E e: c) {
            if(result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Collection是一个接口类
        Collection<Integer> collection = new ArrayList<>();

        // binarySearch 是泛型方法 <T> int binarySearch()
        // Collections.binarySearch();
    }
}
