package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-07 15:50
 */
public class SingleExample {
}

class Singleton {

    /**
     * 单例模式（饿汉式，静态变量）
     *
     * 第一步私有化构造器
     * 第二步直接私有化这个类的静态变量
     * 第三步获取实例
     */
    private Singleton() {

    }

    private final static Singleton instance = new Singleton();

    public Singleton getInstance() {
        return instance;
    }

}

class Singleton1 {

    /**
     * 单例模式（饿汉式，静态代码块）
     *
     * 第一步私有化构造器
     * 第二步直接私有化这个类的静态变量
     * 第三步获取实例
     */
    private final static Singleton1 instance;

    static {
        instance = new Singleton1();
    }

    private Singleton1() {

    }

    public Singleton1 getInstance() {
        return instance;
    }

}

class Singleton2 {

    /**
     * 单例模式（懒汉式）,不安全
     *
     * 第一步私有化构造器
     * 第二步直接私有化这个类的静态变量
     * 第三步获取实例
     */
    private static Singleton2 instance;


    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        if(instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

}

class Singleton3 {

    /**
     * 单例模式（懒汉式）,安全，效率低
     *
     * 第一步私有化构造器
     * 第二步直接私有化这个类的静态变量
     * 第三步获取实例
     */
    private static Singleton3 instance;


    private Singleton3() {

    }

    //加入同步锁
    public static synchronized Singleton3 getInstance() {
        if(instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }

}

class Singleton4 {

    /**
     * 单例模式（懒汉式）,安全，效率高
     *
     * 第一步私有化构造器
     * 第二步直接私有化这个类的静态变量
     * 第三步获取实例
     */
    private static Singleton4 instance;


    private Singleton4() {

    }

    //双重检索
    public static Singleton4 getInstance() {
        if(instance == null) {
            synchronized (Singleton4.class) {
                if(instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }

}

class Singleton5 {

    /**
     * 单例模式（懒汉式）,安全
     *
     * 第一步私有化构造器
     * 第二步直接私有化这个类的静态变量
     * 第三步获取实例
     *
     * 外部内加载的时候内部静态类是不会被加载的，在使用的时候会被加载，加载的时候是线程安全的
     */
    private static class SingletonInstance {
        private static final Singleton5 instance = new Singleton5();
    }

    public Singleton5() {
    }

    public static Singleton5 getInstance() {
        return SingletonInstance.instance;
    }
}

enum Singleton6 {

    /**
     * 单例模式,安全
     *
     * 第一步私有化构造器
     * 第二步直接私有化这个类的静态变量
     * 第三步获取实例
     */
    INSTANCE;

}