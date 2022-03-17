package com.show.app.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private int count = 0;
    private Lock lock = new ReentrantLock();
    Condition con1 = lock.newCondition();
    Condition con2 = lock.newCondition();
    Condition con3 = lock.newCondition();


    public static void main(String[] args) {
        LockTest test = new LockTest();
        test.funLoop();
    }

    private void funLoop(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<100) {
                    try {
                        lock.lock();

                        if (count % 3 == 0) {
                            System.out.println("t1:" + count);
                            count++;
                            con2.signal();
                        } else {
                            con1.await();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<100) {
                    try {
                        lock.lock();

                        if (count % 3 == 1) {
                            System.out.println("t2:" + count);
                            count++;
                            con3.signal();
                        } else {
                            con2.await();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<100) {
                    try {
                        lock.lock();

                        if (count % 3 == 2) {
                            System.out.println("t3:" + count);
                            count++;
                            con1.signal();
                        } else {
                            con3.await();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
