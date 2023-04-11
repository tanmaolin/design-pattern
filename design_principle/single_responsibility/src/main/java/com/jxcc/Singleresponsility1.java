package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-04 21:10
 */
public class Singleresponsility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("飞机");
    }

}

/**
 * 交通工具类
 *
 * 方式1
 * 违反了单一职责原则
 * 解决方式就是将交通类分解成对应的交通类
 */
class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上跑");
    }
}