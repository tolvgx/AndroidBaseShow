package com.show.app.clasz;

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

        /**
         * 内部类, 匿名内部类持有外部类的引用
         * 静态内部类不持有外部类的引用
         */
        A a = new A();
        A.B b = a.new B();
        b.funB();

        A.C c = new A.C();
        c.funC();
    }
}
