package org.hahadeng.chapters4.item24;

/**
 * @author 邓聪
 */
public class StaticInnerClass2 {

    // 静态内部类， 不依赖与外部类
    public static class InnerClass2{

        public void hello(){
            System.out.println("hello world");
        }
    }

    public static void main(String[] args) {
        InnerClass2 innerClass2 = new InnerClass2();
        innerClass2.hello();
    }
}
