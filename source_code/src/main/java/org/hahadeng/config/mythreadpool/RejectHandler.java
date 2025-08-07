package org.hahadeng.config.mythreadpool;

/**
 * 拒接策略
 *
 * @author 邓聪
 * @since 2025/6/2 11:28
 */
public interface RejectHandler {

    void reject(Runnable rejectCommand, MyThreadPool myThreadPool);
}
