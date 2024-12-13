package org.hahadeng.chapter5.item31;

import java.util.Collection;
import java.util.Stack;

/**
 * @author 邓聪
 */
public class Stack0<E> extends Stack<E> {

    /**
     * Stack<Number> stack = new Stack<>();
     * Iterable<Integer> integers = ...;
     * stack.pushAll(integers);
     * 上方代码会报错，java 提供了一种特殊的参数化类型，有界通配符类型。
     * pushAll输入的参数的类型不应该是E的Iterable接口，而应该是E的某个子类型的Iterable接口，Iterable<? extends E>
     */
    public void pushAll(Iterable<? extends E> src){
        for(E e: src){
            push(e);
        }
    }

    /**
     * popAll的输入参数的类型不应该是E的集合，而应该是E的某个超类型的集合，Collection<? super E>
     */
    public void popAll(Collection<? super E> dst){
        while(!isEmpty()){
            dst.add(pop());
        }
    }
}
