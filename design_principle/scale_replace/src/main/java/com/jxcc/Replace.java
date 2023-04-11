package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-06 8:22
 */
public class Replace {
}

class A {
    public int fun1(int a, int b) {
        return a + b;
    }
}

class B extends A {

    /**
     * 程序员不小心重写了
     * 这里就可能导致数据进行运算的时候出现还以为调用了父类的方法，但是实际调用了自己的方法
     * 这样造成原本的功能出现错误
     * 解决方法就是编写一个基类，然后使用组合的方法来使用A累的方法
     */
    @Override
    public int fun1(int a, int b) {
        return a - b;
    }

    public int fun2(int a, int b) {
        return fun1(a, b) + 2;
    }
}