package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-06 8:22
 */
public class Replace1 {
}

//基础类
class Base {

}
class A1 extends Base{
    public int fun1(int a, int b) {
        return a + b;
    }
}

class B1 extends Base {

    /**
     * 里式替换原则，就是在继承的关系， 基类的方法必须能透明地使用其子类的对象，子类尽量不要重写父类的方法
     * 尽量使用聚合，组合，依赖来解决问题
     * 程序员不小心重写了
     * 这里就可能导致数据进行运算的时候出现还以为调用了父类的方法，但是实际调用了自己的方法
     * 这样造成原本的功能出现错误
     * 解决方法就是让类继承基础类
     */

    private A1 a =new A1();

    public int fun1(int a, int b) {
        return a - b;
    }

    public int fun2(int a, int b) {
        return fun1(a, b) + 2;
    }

    public int fun3(int a, int b) {
        return this.a.fun1(a,b);
    }
}