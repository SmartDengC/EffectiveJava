package org.hahadeng.chapter2.inner;

/**
 * @author: HaHaDeng
 */

public class OuterClass {
    /**
     * 非静态内部类
     * 1 非静态内部类是实例的一个类，需要创建外部对象， 使用外部对象才能使用内部类
     * 2 为什么使用内部类？隐藏细节和内部结构，封装新更好，让程序的结构更加合理。
     */
    private String name;
    public void display(){
        System.out.println("OuterClass Display");
        System.out.println(name);

        /**
         * 把内部类定义到方法里面
         */
        class InnerClass2{
            public void print(){
                System.out.println("InnerClass2 Print");
            }
        }

        InnerClass2 inner = new InnerClass2();
        inner.print();
    }

    public class InnerClass{
        private String name;
        public void display(){
            System.out.println("InnerClass Display");
            System.out.println(name);
        }

        public InnerClass(){
            this.name = "Inner Name";
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.display();

        InnerClass inner = outer.new InnerClass();
        inner.display();
    }
}
