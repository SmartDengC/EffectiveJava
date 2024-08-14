package org.hahadeng.structHub;

import java.util.Stack;

/**
 * 栈的知识点
 */
public class StackHub {

	public int[] nextGreaterElements(int[] nums){
		// 新建一个栈
		Stack<Integer> stack = new Stack<>();
		// 向栈顶插入一个元素
		Integer push = stack.push(1);
		// 获取栈顶元素， 不删除元素
		Integer peek = stack.peek();
		// 获取栈顶元素，删除元素
		Integer pop = stack.pop();
		// 判断栈是否为空
		boolean empty = stack.isEmpty();
		return new int[]{1,2,3};
	}
}
