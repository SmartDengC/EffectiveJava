package org.hahadeng.chapter5.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 推荐使用
 * @author 邓聪
 */
public class Stack1<E> {
    private E[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack1(){
        // unchecked warning
        elements = (E[]) new Object[DEFAULT_CAPACITY];
//        elements = new E[DEFAULT_CAPACITY];
    }

    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }
    public E pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        // 这里--size我知道，比如有一个元素，size = 1， 但是元素的下标是size - 1
        E element = elements[--size];
        // 这里使用size 是因为上面已经--size了，所以这里的size就表示最后一个元素的下标。
        elements[size] = null;
        return element;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    private void ensureCapacity(){
        if(size == elements.length){
            elements = Arrays.copyOf(elements, size * 2 +1);
        }
    }
}
