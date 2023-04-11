package com.jxcc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanmaolin
 * @date 2022-10-09 14:31
 */
public class Visitor {


    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());

        objectStructure.display(new Success());
    }

}


abstract class Action {
    public abstract void getManResult(Man man);

    public abstract void getWomanResult(Woman woman);
}

class Success extends Action {

    @Override
    public void getManResult(Man man) {
        System.out.println("成功");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("成功");
    }
}

class Failure extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("失败");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("失败");
    }
}

abstract class Person {
    public abstract void accept(Action action);
}

//这里使用了双分派，即首先在客户端程序中，将具体的状态作为参数传递Woman中（第一次分派)
//然后Woman类调用作为参数的“具体方法”中方法getWomanResult，同时将自己（this）作为参数传入，完成第二次分派
class Man extends Person {

    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}

class Woman extends Person {

    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}

class ObjectStructure {
    private List<Person> persons = new ArrayList<>();

    public void attach(Person p) {
        persons.add(p);
    }

    public void delete(Person p) {
        persons.remove(p);
    }

    public void display(Action action) {
        for(Person p : persons) {
            p.accept(action);
        }
    }
}

class Wait extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("待定");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("待定");
    }
}
