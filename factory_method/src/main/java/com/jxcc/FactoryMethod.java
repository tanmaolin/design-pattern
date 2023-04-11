package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-08 10:29
 */
public class FactoryMethod {
}

abstract class OrderPizza {
    String orderType = "";

    Pizza pizza = null;

    public OrderPizza() {
        Pizza pizza = createPizza(orderType);
    }

    abstract Pizza createPizza(String ordertype);
}

class BJOrderPizza extends OrderPizza{

    @Override
    Pizza createPizza(String ordertype) {
        if(ordertype == "cheese") {
            return new BJCheesePizza();
        }else {
            return new BJPerpperPizza();
        }
    }
}

class LDOrderPizza extends OrderPizza{

    @Override
    Pizza createPizza(String ordertype) {
        if(ordertype == "cheese") {
            return new LDCheesePizza();
        }else {
            return new LDPerpperPizza();
        }
    }
}

abstract class Pizza {
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

class BJCheesePizza extends Pizza {

    @Override
    public void prepare() {

    }
}

class BJPerpperPizza extends Pizza {

    @Override
    public void prepare() {

    }
}

class LDCheesePizza extends Pizza {

    @Override
    public void prepare() {

    }
}

class LDPerpperPizza extends Pizza {

    @Override
    public void prepare() {

    }
}