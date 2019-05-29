package com.tolvgx.show.clasz;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/4/29
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class Test {
    public static void main(String[] args){
        A a = new A();
        A.B b = a.new B();

        b.fun();
    }
}
