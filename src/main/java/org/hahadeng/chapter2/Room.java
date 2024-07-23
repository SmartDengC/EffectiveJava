package org.hahadeng.chapter2;

//import sun.misc.Cleaner;

import sun.misc.Cleaner;

/**
 * @author: HaHaDeng
 * 未完待续
 */

public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable {
        int numJunkPiles;

        State(int numJunkPiles){
            this.numJunkPiles = numJunkPiles;
        }

        // 由close方法或者清理方法调用
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    private final State state;

    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }
    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
