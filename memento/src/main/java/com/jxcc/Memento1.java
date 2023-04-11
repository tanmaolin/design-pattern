package com.jxcc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanmaolin
 * @date 2022-10-11 15:14
 */
public class Memento1 {

    private int vit;
    private int def;

    public Memento1(int vit, int def) {
        this.vit = vit;
        this.def = def;
    }

    public int getVit() {
        return vit;
    }

    public int getDef() {
        return def;
    }

}

class client1 {
    public static void main(String[] args) {
        GameRole gameRole = new GameRole();
        gameRole.setDef(100);
        gameRole.setVit(100);

        gameRole.display();

        Caretaker1 caretaker = new Caretaker1();

        caretaker.add(gameRole.createMemento());

        gameRole.setDef(30);
        gameRole.setVit(10);
        gameRole.display();

        //恢复状态
        gameRole.getStateFromMemento(caretaker.get((0)));
        gameRole.display();
    }
}

class Caretaker1 {
    private List<Memento1> mementos = new ArrayList<>();

    public void add(Memento1 memento) {
        mementos.add(memento);
    }

    //获去备忘录
    public Memento1 get(int index) {
        return mementos.get(index);
    }
}

class GameRole {
    private int vit;
    private int def;

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public Memento1 createMemento() {
        return new Memento1(vit, def);
    }

    //通过备忘录恢复状态
    public void getStateFromMemento(Memento1 memento) {
        vit = memento.getVit();
        def = memento.getDef();
    }

    public void display() {
        System.out.println(this.vit + this.def);
    }
}