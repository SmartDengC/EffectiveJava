package org.hahadeng.config.mythreadpool;

/**
 * @author 邓聪
 * @since 2025/6/2 11:31
 */
public class ThrowRejectHandler implements RejectHandler {

    @Override
    public void reject(Runnable rejectCommand, MyThreadPool myThreadPool) {
        throw new RuntimeException("阻塞队列满了！");
    }

}
