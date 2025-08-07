package org.hahadeng.config.mythreadpool;

/**
 * @author 邓聪
 * @since 2025/6/2 11:33
 */
public class DiscardRejectHandler implements RejectHandler {
    @Override
    public void reject(Runnable rejectCommand, MyThreadPool myThreadPool) {
        myThreadPool.blockingQueue.poll();
        myThreadPool.execute(rejectCommand);
    }
}
