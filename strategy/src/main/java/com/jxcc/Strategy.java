package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-10-13 8:32
 */
public class Strategy {
}

abstract class Duck {

    public Duck() {
    }

    public abstract void display();

    public void quack() {
        System.out.println();
    }

    public void swim() {
        System.out.println();
    }

    public void fly() {
        System.out.println("飞翔");
    }
}


class WildDuck extends Duck {
    @Override
    public void display() {

    }
}

class BejingDuck extends Duck {
    @Override
    public void display() {

    }

    @Override
    public void fly() {
        System.out.println("不能飞翔");
    }
}
