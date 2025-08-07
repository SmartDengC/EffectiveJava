package org.hahadeng.structHub;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class IntegerArrayHub {
	public static void compareDouble(){
		int[] x = new int[]{1,2,3,4,5,0};
		int length = x.length;
		// 在原来数组上面修改 现在大多都是用List, 很少用定长的Array
		Arrays.sort(x); // 排序数组x内部元素
		System.out.println(x);  // [I@1540e19d
		System.out.println(Arrays.toString(x));  // [0, 1, 2, 3, 4, 5]

		int[] y = new int[10];
		Arrays.fill(y, -1);

		// 降序只能用封装类型
		Integer[] z = new Integer[]{1,2,3,4,0};
		Arrays.sort(z, Collections.reverseOrder());
		Arrays.sort(z, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		System.out.println(Arrays.toString(z));

	}
	public static void main(String[] args) {
		IntegerArrayHub.compareDouble();
	}
}
