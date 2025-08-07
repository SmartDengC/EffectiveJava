package org.hahadeng.sort;

/**
 * @author 邓聪
 * @since 2025/7/31 09:36
 */
public abstract class Person {

    private Integer age;

    public Person() {
    }

    public Person(Integer age) {
        this.age = age;
    }

    /**
     * 普通方法，可以有实现
     */
    void sayHello() {
        System.out.println("hello");
    }

    abstract void add(int a, int b);
}
