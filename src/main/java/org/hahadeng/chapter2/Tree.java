package org.hahadeng.chapter2;

/**
 * @author dCong
 * @package_name:org.hahadeng.chapter2
 * @date: 2024/7/17
 * @desc:
 */

public class Tree {
    public static String name;

    public static String callName(String name){
        return name;
    }

    public static void main(String[] args) {
        // Pine Tree
        System.out.println(Tree.callName("Pine Tree"));
        Tree.name = "Aspen";
        // Aspen
        System.out.println(Tree.name);
    }
}
