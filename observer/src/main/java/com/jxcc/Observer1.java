package com.jxcc;

import java.util.ArrayList;

/**
 * @author tanmaolin
 * @date 2022-10-10 11:02
 */
public interface Observer1 {
    public void update(float temperature, float pressure, float humidity);
}

class CurrentCodition1 implements Observer1{
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println(temperature);
        System.out.println(pressure);
        System.out.println(humidity);
    }
}

class BaiduCodition1 implements Observer1{

    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println(temperature);
        System.out.println(pressure);
        System.out.println(humidity);
    }
}

interface Subject {
    public void registerObserver(Observer1 o);
    public void remove(Observer1 o);
    public void notifyObservers();
}

class WeatherData1 implements Subject {

    private float temperature;
    private float pressure;
    private float humidity;
    private ArrayList<Observer1> observer1s;

    public WeatherData1() {
        this.observer1s =new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer1 o) {
        observer1s.add(o);
    }

    @Override
    public void remove(Observer1 o) {
        observer1s.remove(o);
    }

    public void dataChange() {
       notifyObservers();
    }

    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }

    @Override
    public void notifyObservers() {
        for(Observer1 observer1 : observer1s) {
            observer1.update(temperature, pressure, humidity);
        }
    }
}
