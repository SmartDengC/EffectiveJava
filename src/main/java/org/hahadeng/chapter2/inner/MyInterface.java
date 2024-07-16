package org.hahadeng.chapter2.inner;

/**
 * @ClassName MyInterface
 * @Author dengc4r
 * @Time 2024/7/17 01:36
 * @Description TODO
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
