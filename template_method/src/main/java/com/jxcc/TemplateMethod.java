package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-10-08 15:18
 */
public class TemplateMethod {

}

abstract class ITemplate {
    public void template() {
        this.method1();
        this.method2();
        this.method3();
    }

    public abstract void method3();

    public abstract void method2();

    public abstract void method1();
}

class Template extends ITemplate {

    @Override
    public void method3() {
        System.out.println(3);
    }

    @Override
    public void method2() {
        System.out.println(2);
    }

    @Override
    public void method1() {
        System.out.println(1);
    }
}


abstract class SoyaMilk {
    //制作豆浆
    final void make() {
        this.select();
        this.addCondiments();
        this.soak();
        this.beat();
    }
    //选材料
    void select() {
        System.out.println("选好材料黄豆");
    }

    //添加不同配料
    abstract void addCondiments();

    //浸泡
    void soak() {
        System.out.println("配料喝黄豆浸泡");
    }
    //碾磨
    void beat() {
        System.out.println("黄豆和配料碾磨");
    }
}

class RedBeanSoyaMilk extends SoyaMilk {

    @Override
    void addCondiments() {
        System.out.println("红豆豆浆");
    }
}

class YellowSoyaMilk extends SoyaMilk {

    @Override
    void addCondiments() {
        System.out.println("黄豆豆浆");
    }
}