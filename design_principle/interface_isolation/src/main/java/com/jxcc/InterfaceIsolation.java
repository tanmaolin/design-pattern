package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-04 23:11
 */
public class InterfaceIsolation {

}

/**
 * 接口隔离就是：一个类对另一个类的依赖应该建立在最小接口上
 */
interface InterfaceTest {
    void interface1();
    void interface2();
    void interface3();
}

class A implements InterfaceTest {

    @Override
    public void interface1() {

    }

    @Override
    public void interface2() {

    }

    @Override
    public void interface3() {

    }
}

class B implements InterfaceTest {

    @Override
    public void interface1() {

    }

    @Override
    public void interface2() {

    }

    @Override
    public void interface3() {

    }
}

class C {
    public void depend1(InterfaceTest interfaceTest) {
        interfaceTest.interface1();
    }

    public void depend2(InterfaceTest interfaceTest) {
        interfaceTest.interface2();
    }
}

class D {
    public void depend3(InterfaceTest interfaceTest) {
        interfaceTest.interface3();
    }
}