package com.jxcc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanmaolin
 * @date 2022-10-11 15:14
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("状态1");
        caretaker.add(originator.saveSateMemento());

        originator.setState("状态2");
        caretaker.add(originator.saveSateMemento());

        System.out.println(originator.getState());

        //恢复状态
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println(originator.getState());
    }
}

class Caretaker {
    private List<Memento> mementos = new ArrayList<>();

    public void add(Memento memento) {
        mementos.add(memento);
    }

    //获去备忘录
    public Memento get(int index) {
        return mementos.get(index);
    }
}

class Originator {
    private String state; // 状态信息

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveSateMemento() {
        return new Memento(state);
    }

    //通过备忘录恢复状态
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}