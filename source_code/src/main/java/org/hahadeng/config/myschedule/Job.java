package org.hahadeng.config.myschedule;

import lombok.Data;

/**
 * 任务
 *
 * @author 邓聪
 * @since 2025/6/3 06:08
 */
@Data
public class Job implements Comparable<Job> {

    private Runnable task;

    private long startTime;

    private long delay;

    @Override
    public int compareTo(Job o) {
        return Long.compare(this.startTime, o.startTime);
    }
}
