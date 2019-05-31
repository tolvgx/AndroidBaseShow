package com.tolvgx.show.thread;

import java.util.PriorityQueue;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/5/30
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class CPTest {

    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);

    public static void main(String[] args){
        CPTest test = new CPTest();

        Comsumer comsumer = test.new Comsumer();
        Producer producer = test.new Producer();

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
                            System.out.println("队列空，等待数据");
                            queue.wait();
                        } else {
                            queue.poll();
                            System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
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
                            System.out.println("队列满，等待有空余空间");
                            queue.wait();
                        } else {
                            queue.offer(1);
                            System.out.println("向队列取中插入一个元素，队列有"+queue.size()+"个元素");
                            queue.notify();
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
