package org.hahadeng.chapter5.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 不推荐使用
 * @author 邓聪
 */
public class Stack {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity() {
        if(size == elements.length) {
            elements = Arrays.copyOf(elements, 2*size +1);
        }
    }
    public void push(Object element) {
        ensureCapacity();
        elements[size++] = element;
    }
    public Object pop(){
        if(size == 0) {
            throw new EmptyStackException();
        }
        Object e = elements[--size];
        elements[size] = null;
        return e;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
    }
}
