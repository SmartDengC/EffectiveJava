package org.hahadeng.chapters4.item24;

/**
 * @author 邓聪
 */
public class StaticInnerClass {

    // 创建一个静态内部类， 来创建外部类对象
    private static class InnerClass{
        private static StaticInnerClass staticInnerClass = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance(){
        return InnerClass.staticInnerClass;
    }

    private StaticInnerClass(){}
}
