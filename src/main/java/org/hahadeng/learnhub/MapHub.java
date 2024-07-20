package org.hahadeng.learnhub;

import java.util.*;

/**
 * 学习使用Map的知识点
 */
public class MapHub {
	static class Employee{
		int id;
		String name;
		Employee(int id, String name){
			this.id = id;
			this.name = name;
		}
	}
	public long maximumTotalDamage(int[] power){
		// 定义一个map
		Map<Integer, Integer> cnt = new HashMap<>();
		for(int x: power){
			// 这个代码的意思就是： 当map里面没有key为x的时候，value为1； 有key为x的时候，将原来的value+1
			cnt.merge(x, 1, Integer::sum);
		}
		return 1L;
	}

	public void mergeMap(){
		Employee employee = new Employee(1, "hahadeng");
		Map<Integer, Employee> map = new HashMap<>();
		// 简单来说就是当存在key = 1的时候将v1的id， v2的name用来创建Employee
		map.merge(1, employee, (v1, v2)->new Employee(v1.id, v2.name));
	}

	public static void keys(){
		Map<Integer, Integer> cnt = new HashMap<>();
		cnt.put(1,2);
		cnt.put(2,3);

		Map<Integer, Integer> cnt2 = new HashMap<Integer, Integer>() {{
			put(1,2);
			put(2,3);
		}};
		Set<Integer> integers = cnt2.keySet();
		Collection<Integer> values = cnt2.values();
		for(int x: cnt2.keySet())
			System.out.println(x);

		for(int x: cnt.values())
			System.out.println(x);
	}

	public static void main(String[] args) {
		// TreeMap ?
		TreeMap<Integer, List<int[]>> g = new TreeMap<>();
		MapHub.keys();
	}

}
