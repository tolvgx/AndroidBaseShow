package com.tolvgx.show.modifier;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/6/14
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */

/*
    一.类:
    1.访问修饰符
        public: 可以被本项目的所有类访问, (其他项目若想使用本项目中的类，必须将本项目打包为jar包，然后加入到classpath中)
        (default)无访问修饰符: 只能被同一个包中的类访问
    2.修饰符
        final
        abstract
    3.注意:
        内部类还可以使用private/protected这两种访问修饰符!
        内部类还可以使用static修饰符!

    二.变量:
    1.访问修饰符
        public: 可以被本项目的所有类访问
        protected: 可以被所有子类访问
        private: 只能够被当前类的方法访问
        (default)无访问修饰符: 可以被同一包中的所有类访问
    2.修饰符
        static
        final
        transient
        volatile
    3.注意:
        上面所说的变量都是成员变量，局部变量前是没有访问修饰符的，因为局部变量的生命周期只在当前函数中，再声明访问修饰符没有意义

    三.方法:
    1.访问修饰符
        public: 可以被本项目的所有类访问
        protected: 可以被所有子类访问
        private: 只能够被当前类的方法访问
        (default)无访问修饰符: 可以被同一包中的所有类访问
     2.修饰符
        static
        final
        abstract
        native
        synchronized

 */
public class ModifierClass {

    class Inner{

    }
}
