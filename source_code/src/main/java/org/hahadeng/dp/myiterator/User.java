package org.hahadeng.dp.myiterator;

import java.util.Iterator;

/**
 * 用户
 * Iterable是接口，表示可迭代的，实现的话需要实现iterator接口
 * Iterator也是接口，表示迭代器，实现的话需要实现hasNext和next两个方法
 *
 * @author 邓聪
 * @since 2025/6/3 20:18
 */
public class User implements Iterable {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Iterator<String> iterator() {
        return new UserIterator();
    }

    class UserIterator implements Iterator<String> {
        int count = 2;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public String next() {
            count--;
            if (count == 1) {
                // 是一个内部类，需要使用Outer.this.属性
                return User.this.name;
            }
            if (count == 0) {
                return User.this.age + "";
            }
            try {
                throw new NoSuchFieldException();
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
