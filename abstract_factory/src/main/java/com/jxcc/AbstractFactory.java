package com.jxcc;

import java.util.Calendar;

/**
 * @author tanmaolin
 * @date 2022-09-11 13:16
 */
public class AbstractFactory {
}

class OrderPizza {

    AbsFactory absFactory;

    public OrderPizza(AbsFactory factory) {
        setAbsFactory(factory);
    }

    public AbsFactory getAbsFactory() {
        return absFactory;
    }

    public void setAbsFactory(AbsFactory absFactory) {
        this.absFactory = absFactory;
        String orderType = "";
        Pizza pizza = absFactory.createPizza(orderType);
    }
}

interface AbsFactory {
    Pizza createPizza(String orderType);
}

class BJPizzaFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String orderType) {
        if("cheese".equals(orderType)) {
            return new BJCheesePizza();
        }else {
            return new BJPerpperPizza();
        }
    }
}

class LDPizzaFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String orderType) {
        if("cheese".equals(orderType)) {
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
        Calendar.getInstance();
    }
}

class LDPerpperPizza extends Pizza {

    @Override
    public void prepare() {

    }
}
