package com.jaxx;

/**
 * @author tanmaolin
 * @date 2022-09-08 8:42
 */
public class SimapleFactory1 {}

class PizzaStore1 {
    public static void main(String[] args) {
        new OrderPizza("Cheese");
    }
}

class OrderPizza1 {
    Pizza1 pizza1 = null;

    public OrderPizza1(String orderType) {
        this.pizza1 = SimapleFactoryTest.createPizza(orderType);
    }

//    public OrderPizza1(SimapleFactoryTest simapleFactoryTest) {
//
//    }

//    public Pizza setPizza(String pizzaType) {
//        return simapleFactoryTest.createPizza(pizzaType);
//    }
}

class SimapleFactoryTest {

    static Pizza1 pizza1 = null;

    public SimapleFactoryTest() {

    }

    public static Pizza1 createPizza(String pizzaType) {
        if(pizzaType == "Cheese") {
            pizza1 = new CheesePizza1();
            pizza1.setName(pizzaType);
        }else {
            pizza1 = new GreekPizza1();
            pizza1.setName(pizzaType);
        }
        return pizza1;
    }
}

abstract class Pizza1 {
    protected String name;

    // 准配材料
    public abstract void prepare();

    public void bake() {
        System.out.println("baking" + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}

class CheesePizza1 extends Pizza1 {

    @Override
    public void prepare() {

    }
}

class GreekPizza1 extends Pizza1 {

    @Override
    public void prepare() {

    }
}