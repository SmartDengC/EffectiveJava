package org.hahadeng.chapter2;

/**
 * @author: HaHaDeng
 */

public class Elvis1 {
    /**
     * java会为每一个类创建一个无参的构造方法
     */
    private static final Elvis1 INSTANCE = new Elvis1();

    public static Elvis1 getInstance(){
        return INSTANCE;
    }
}

class Main{
    public static void main(String[] args) {
        // private 表示同类访问， 这里只暴露出一个getInstance()的方法
        // Elvis1 elvis1 = Elvis1.getInstance();
        Elvis2 elvis2 = Elvis2.INSTANCE;
        System.out.println(elvis2.getValue());
    }
}
