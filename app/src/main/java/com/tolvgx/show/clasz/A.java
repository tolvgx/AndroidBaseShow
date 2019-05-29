package com.tolvgx.show.clasz;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/4/29
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class A {
    String aStr = "A";

    /*
        内部类
     */
    class B {
        void funB(){
            System.out.println("funB");

            funA();//(内部类)可以调用外部类的方法, 即持有外部类的引用
        }
    }

    void funA(){
        System.out.println("funA");

        /*
            匿名内部类
         */
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                aStr = "newA";//(匿名内部类)可以调用外部类的变量, 即持有外部类的引用
                System.out.println(aStr);
            }
        });
        t.start();
    }

    /*
        静态内部类
     */
    static class C {
        void funC(){
            System.out.println("funC");
            //(静态内部类)不可调用外部类的变量和方法
        }
    }
}
