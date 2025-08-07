package org.hahadeng.sort;

import java.io.Serializable;

/**
 * @author 邓聪
 * @since 2025/7/31 09:38
 */
public class Student extends Person implements Running, Serializable, Cloneable {

    public int x;

    public static String name = "hello";

    @Override
    void add(int a, int b) {
        // 实现抽象方法
    }

    @Override
    public void running() {
        System.out.println();
    }

    @Override
    public void speaking() {
        // 局部变量必须手动设置默认值
        int y = 0;
        System.out.println(y);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int x = -1234;
        System.out.println(x % 10);
    }

}
