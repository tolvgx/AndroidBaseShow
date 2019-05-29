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
    class B {
        public void fun(){
            System.out.println("xxx");

            A.this.test();
        }
    }

    public void test(){
        System.out.println("test");
    }
}
