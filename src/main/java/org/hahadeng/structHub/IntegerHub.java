package org.hahadeng.structHub;

/**
 * Integer 知识点
 */
public class IntegerHub {
	public int temperatureTrend(int[] temperateA, int[] temperatureB){
		// 当A1 < A2 时返回-1
		int compare = Integer.compare(1, 2);
		// 当 A1 > A2 时返回1
		int compare1 = Integer.compare(2, 1);
		// 当 A1 = A2 时返回0
		int compare2 = Integer.compare(1, 1);
		System.out.println(compare);
		System.out.println(compare1);
		System.out.println(compare2);
		return 1;
	}

	public void maxInt(int a, int b){
		// 返回a和b中的最大值和最小值。
		int max = Math.max(a, b);
		int min = Math.min(a, b);
	}
	public static void sameValue(){
		Integer x = new Integer(10);
		Integer y = new Integer(10);
		System.out.println(x.equals(y));  // compare value  -> true
		System.out.println(x == y);  // compare place  -> false

		int a = 100;
		Integer b = 100;
		System.out.println(a == b); // true b自动拆箱，直接和a比较值
		Integer c = 100;
		Integer d = 100;
		System.out.println(c == d);  // true  自动装箱？
		c = 200;
		d = 200;
		System.out.println(c == d);  // false
		c = 127;
		d = 127;
		System.out.println(c == d); // true 当需要进行自动装箱时，如果数字在 -128 至 127 之间时，会直接使用缓存中的对象，而不用重新创建一个对象

	}

	public static void main(String[] args) {
		// IntegerHub hub  = new IntegerHub();
		// hub.temperatureTrend(new int[]{1,2}, new int[]{3,4});
		IntegerHub.sameValue();
	}
}
