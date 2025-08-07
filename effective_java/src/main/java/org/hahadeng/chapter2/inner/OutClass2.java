package org.hahadeng.chapter2.inner;

/**
 * @author: HaHaDeng
 */

public class OutClass2 {

    /**
     * 静态内部类
     * 1 不依赖于外部类实例创建
     */
    public static class InnerClass{
        public void display(){
            System.out.println("InnerClass display");
        }
    }

    public static void main(String[] args) {
        InnerClass inner = new InnerClass();
        inner.display();
    }
}
