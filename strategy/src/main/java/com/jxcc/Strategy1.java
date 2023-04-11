package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-10-13 8:32
 */
public class Strategy1 {
}

interface FlyBehavior {
    public abstract void fly();
}

class NoFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {

    }
}

class GoodFLyBehavior implements FlyBehavior {

    @Override
    public void fly() {

    }
}

class Duck1 {
    public FlyBehavior flyBehavior;

    public Duck1() {
    }

    public void quack() {

    }

    public void swim() {
    }

    public void fly() {
        if(flyBehavior != null) {
            flyBehavior.fly();
        }
    }
}

class WildDuck1 extends Duck1 {

    public WildDuck1() {
        flyBehavior = new GoodFLyBehavior();
    }

}

class BejingDuck1 extends Duck1 {

    public BejingDuck1() {
        flyBehavior = new NoFlyBehavior();
    }

}