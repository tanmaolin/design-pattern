package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-10-08 15:18
 */
public class TemplateMethod1 {

}

//模板模式的钩子方法
abstract class SoyaMilk1 {
    //制作豆浆
    final void make() {
        this.select();
        if(customerWantCondiments()) {
            this.addCondiments();
        }
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

    //钩子方法，就是让子类去重写它
    boolean customerWantCondiments() {
        return true;
    }
}

class RedBeanSoyaMilk1 extends SoyaMilk1 {

    @Override
    void addCondiments() {
        System.out.println("红豆豆浆");
    }
}

class YellowSoyaMilk1 extends SoyaMilk1 {

    @Override
    void addCondiments() {
        System.out.println("黄豆豆浆");
    }
}

class PureSoyaMilk1 extends SoyaMilk1 {

    @Override
    void addCondiments() {
    }

    @Override
    boolean customerWantCondiments() {
        return false;
    }
}