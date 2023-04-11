package com.jaxx;

/**
 * @author tanmaolin
 * @date 2022-09-08 8:42
 */
public class SimapleFactory {}

class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza("Cheese");
    }
}

class OrderPizza {

    Pizza pizza = null;

    public OrderPizza(String pizzaType) {
        if(pizzaType == "Cheese") {
            pizza = new CheesePizza();
            pizza.setName(pizzaType);
        }else {
            pizza = new GreekPizza();
            pizza.setName(pizzaType);
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

class CheesePizza extends Pizza {

    @Override
    public void prepare() {

    }
}

class GreekPizza extends Pizza {

    @Override
    public void prepare() {

    }
}