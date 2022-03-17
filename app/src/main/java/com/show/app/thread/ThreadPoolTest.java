package com.show.app.thread;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t3");
            }
        });

        //仅有一个线程的线程池，任务加到一个队列中，先入先出顺序执行
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);
        executorService.shutdown();

    }
}
