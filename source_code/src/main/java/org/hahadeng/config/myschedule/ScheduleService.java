package org.hahadeng.config.myschedule;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * 手写定时任务
 *
 * @since 2025/6/3 05:55
 */
public class ScheduleService {

    Trigger trigger = new Trigger();

    ExecutorService executorService = Executors.newFixedThreadPool(6);

    public void schedule(Runnable task, long delay) {
        Job job = new Job();
        job.setTask(task);
        job.setStartTime(System.currentTimeMillis() + delay);
        job.setDelay(delay);
        trigger.queue.offer(job);
        trigger.wakeUp();
    }

    // 等待相应的时间，把任务添加到线程池中
    class Trigger {

        PriorityBlockingQueue<Job> queue = new PriorityBlockingQueue<>();

        Thread thread = new Thread(() -> {
            while (true) {
                // 不能使用if判断，存在虚假唤醒问题，使用while解决
                // Object
                while (queue.isEmpty()) {
                    LockSupport.park();
                }
                Job latelyJob = queue.peek();
                if (latelyJob.getStartTime() < System.currentTimeMillis()) {
                    latelyJob = queue.poll();
                    executorService.execute(latelyJob.getTask());
                    // 计算下一次执行的任务
                    Job nextJob = new Job();
                    nextJob.setTask(latelyJob.getTask());
                    nextJob.setDelay(latelyJob.getDelay());
                    nextJob.setStartTime(System.currentTimeMillis() + latelyJob.getDelay());
                    queue.offer(nextJob);
                } else {
                    LockSupport.parkUntil(latelyJob.getStartTime());
                }
            }
        });

        {
            thread.start();
            System.out.println("触发器启动了！");
        }

        // 唤醒，当有更小的startTime的任务传进来的时候
        void wakeUp() {
            LockSupport.unpark(thread);
        }
    }

}
