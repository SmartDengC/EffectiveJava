package org.hahadeng.config.mythreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 手写线程池
 *
 * @author 邓聪
 * @since 2025/6/2 00:20
 */
public class MyThreadPool {

    // 任务阻塞队列
    BlockingQueue<Runnable> blockingQueue;

    // 核心线程的数量
    private final int corePoolSize;
    // 最大线程数量
    private final int maxSize;
    // 辅助线程多久没有获取到任务自动关闭
    private final int timeOut;
    // 时间单位
    private final TimeUnit timeUnit;
    // 拒绝策略
    private final RejectHandler rejectHandler;

    public MyThreadPool(int corePoolSize, int maxSize, int timeOut, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectHandler rejectHandler) {
        this.corePoolSize = corePoolSize;
        this.maxSize = maxSize;
        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
        this.blockingQueue = blockingQueue;
        this.rejectHandler = rejectHandler;
    }

    List<Thread> coreList = new ArrayList<>();
    List<Thread> supportList = new ArrayList<>();


    public void execute(Runnable commands) {
        // 如果核心线程数量小于核心线程池大小，则创建核心线程
        if (coreList.size() < corePoolSize) {
            Thread thread = new CoreThread();
            coreList.add(thread);
            thread.start();
        }
        // 如果任务阻塞队列成功加入任务，则直接返回
        if (blockingQueue.offer(commands)) {
            return;
        }
        // 如果核心线程数量加辅助线程数量小于最大线程池大小，则创建辅助线程
        if (coreList.size() + supportList.size() < maxSize) {
            // 创建辅助线程
            Thread thread = new SupportThread();
            supportList.add(thread);
            thread.start();
        }
        // 如果任务阻塞队列加入任务失败，则执行拒绝策略
        if (blockingQueue.offer(commands)) {
            rejectHandler.reject(commands, this);
        }

    }

    class CoreThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    // 从任务阻塞队列中取出任务并执行
                    Runnable command = blockingQueue.take();
                    command.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class SupportThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    // 从任务阻塞队列中取出任务并执行，如果超时则返回null
                    Runnable command = blockingQueue.poll(timeOut, timeUnit);
                    // 如果取出的任务为null，则说明辅助线程没有获取到任务，自动关闭
                    if (command == null) {
                        break;
                    }
                    command.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + "线程结束了!");
        }
    }
}
