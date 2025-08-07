package org.hahadeng.chapter2.inner;

/**
 * @author: HaHaDeng
 */
public interface MyInterface {
    public void display();
}

class A{
    /**
     * 匿名内部类
     *
     * @param args
     */
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterface() {
            @Override
            public void display() {
                System.out.println("Anonymity display");
            }
        };
        myInterface.display();
    }
}
