package org.hahadeng.structHub;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 实现Runnable接口
 *
 * @author 邓聪
 * @since 2025/8/5 20:36
 */
public class MyThreadImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "线程执行:" + i);
        }
    }

    public void test() {
        new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));
    }

    public static void main(String[] args) {

        MyThreadImpl t1 = new MyThreadImpl();

        // 传入一个实现Runnable的对象
        Thread thread = new Thread(t1, "helll");
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 只有当thread执行完之后，才会执行thread1线程
        Thread thread1 = new Thread(t1, "hello world");
    }
}
