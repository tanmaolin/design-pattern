package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-04 21:10
 */
public class Singleresponsility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        AirVehicle airVehicle = new AirVehicle();
        roadVehicle.run("汽车");
        airVehicle.run("飞机");
    }

}

/**
 * 交通工具类
 *
 * 方式2
 * 遵循单一职责原则
 * 但是花销大
 */
class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上跑");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在天上飞");
    }
}
class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在水里游");
    }
}