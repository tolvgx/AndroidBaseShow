package com.show.app.thread;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/5/30
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class CPTest {

    private int queueSize = 100;
    private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);

    private Lock lock = new ReentrantLock();
    private Condition conC= lock.newCondition();
    private Condition conP = lock.newCondition();

    public static void main(String[] args){
        CPTest test = new CPTest();

//        Comsumer comsumer = test.new Comsumer();
//        Producer producer = test.new Producer();

        Comsumer1 comsumer = test.new Comsumer1();
        Producer1 producer = test.new Producer1();

        comsumer.start();
        producer.start();
    }

    class Comsumer extends Thread{

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    try {
                        if (queue.size() == 0){
                            System.out.println("队列空空空!!");
                            queue.wait();
                        } else {
                            queue.poll();
                            System.out.println("-----从队列取走一个元素，队列大小: "+queue.size());
                            queue.notify();
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Producer extends Thread{

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    try {
                        if (queue.size() == queueSize){
                            System.out.println("队列满满满!!");
                            queue.wait();
                        } else {
                            queue.offer(1);
                            System.out.println("+++++向队列插入一个元素，队列大小: "+queue.size());
                            queue.notify();
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Comsumer1 extends Thread{

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();

                    if (queue.size() == 0){
                        System.out.println("队列空空空!!");
                        conC.await();
                    } else {
                        queue.poll();
                        System.out.println("-----从队列取走一个元素，队列大小: "+queue.size());
                        conP.signal();
                    }
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Producer1 extends Thread{

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();

                    if (queue.size() == queueSize){
                        System.out.println("队列满满满!!");
                        conP.await();
                    } else {
                        queue.offer(1);
                        System.out.println("+++++向队列插入一个元素，队列大小: "+queue.size());
                        conC.signal();
                    }
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
