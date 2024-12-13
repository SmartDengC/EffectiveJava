package org.hahadeng.chapter5.item29;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class Stack1Test {

    @Test
    void push() {
        Stack1<Integer> stack1 = new Stack1<>();
        stack1.push(1);
        while(!stack1.isEmpty()) {
            System.out.println(stack1.pop());
        }
    }

    @Test
    void pop() {
    }
}
