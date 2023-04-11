package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-04 21:10
 */
public class Singleresponsility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.runAir("飞机");
        vehicle2.runRoad("汽车");
    }

}

/**
 * 交通工具类
 *
 * 方式3
 * 类是没有遵循单一职责原则，但是方法上任然遵循单一职责原则
 *
 */
class Vehicle2 {
    public void runRoad(String vehicle) {
        System.out.println(vehicle + "在公路上跑");
    }
    public void runAir(String vehicle) {
        System.out.println(vehicle + "在天空飞");
    }
    public void runWater(String vehicle) {
        System.out.println(vehicle + "在公水中游");
    }
}