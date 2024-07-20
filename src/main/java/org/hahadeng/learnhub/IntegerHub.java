package org.hahadeng.learnhub;

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

	public static void main(String[] args) {
		IntegerHub hub  = new IntegerHub();
		hub.temperatureTrend(new int[]{1,2}, new int[]{3,4});
	}
}
