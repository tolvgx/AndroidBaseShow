package com.tolvgx.show.thread;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/4/26
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class JoinTest {
    public static void main(String[] args) {
        JoinTest test = new JoinTest();
        test.fun();
    }

    private void fun() {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });

        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    t1.join();

                    System.out.println("t2");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    t2.join();

                    System.out.println("t3");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
