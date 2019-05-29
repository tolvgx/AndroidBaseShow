package com.tolvgx.show.thread;

public class SynTest {

    private Object obj = new Object();
    private int count = 0;

    public static void main(String[] args) {

        SynTest test = new SynTest();
        test.funLoop();
    }

    private void funLoop() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    try {

                        while (count<100){
                            if (count%3==0) {
                                System.out.println("t1:"+count);
                                count++;
                                obj.notifyAll();
                            } else {
                                obj.wait();
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){

                    try {

                        while (count<100){
                            if (count%3==1) {
                                System.out.println("t2:"+count);
                                count++;
                                obj.notifyAll();
                            } else {
                                obj.wait();
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    try {

                        while (count<100){
                            if (count%3==2) {
                                System.out.println("t3:"+count);
                                count++;
                                obj.notifyAll();
                            } else {
                                obj.wait();
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

}
