package com.jxcc;

import java.util.HashMap;

/**
 * @author tanmaolin
 * @date 2022-10-11 13:42
 */
public abstract class Mediator {
    public abstract void Register(String colleagueName, Colleague colleague);

    public abstract void GetMessage(int stateChange, String colleagueName);

    public abstract void SetMessage();
}

class ConcreteMeditor extends Mediator {

    private HashMap<String, Colleague> colleagueHashMap;
    private HashMap<String, String> interMap;

    public ConcreteMeditor() {
        this.colleagueHashMap = new HashMap<>();
        this.interMap = new HashMap<>();
    }

    @Override
    public void Register(String colleagueName, Colleague colleague) {
        colleagueHashMap.put(colleagueName,colleague);

        if(colleague instanceof Alarm) {
            interMap.put("Alarm", colleagueName);
        }
    }

    @Override
    public void GetMessage(int stateChange, String colleagueName) {
        if(colleagueHashMap.get(colleagueName) instanceof Alarm) {
            if(stateChange == 0) {
                //做的操作
            }
        }
    }

    @Override
    public void SetMessage() {

    }
}

abstract class Colleague {
    private Mediator mediator;
    public String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public abstract void SendMessage(int stateChange);
}

class Alarm extends Colleague {

    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        //在创建同事对象时，把自己翻入到中介对象中去。
        mediator.Register(name, this);
    }

    public void sendAlarm(int stateChange) {
        SendMessage(stateChange);
    }
    @Override
    public void SendMessage(int stateChange) {
        //调用中介者
        this.getMediator().GetMessage(stateChange, this.name);
    }
}