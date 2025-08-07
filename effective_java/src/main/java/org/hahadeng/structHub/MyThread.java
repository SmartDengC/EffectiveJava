package org.hahadeng.structHub;

import java.util.Map;

/**
 * 自定义多线程
 *
 * @author 邓聪
 * @since 2025/8/5 17:59
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "线程执行:" + i);
        }
    }

    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();

        for (Thread thread : allStackTraces.keySet()) {
            System.out.println(thread.getName());
        }
    }

    // public static void main(String[] args) {
    //     MyThread t1 = new MyThread();
    //     MyThread t2 = new MyThread();
    //     MyThread t3 = new MyThread();
    //     t1.setName("线程1");
    //     t2.setName("线程2");
    //     t3.setName("线程3");
    //
    //     // start会启动线程，jvm会调用此线程的run方法
    //     t1.start();
    //     t2.start();
    //     t3.start();
    // }
}
