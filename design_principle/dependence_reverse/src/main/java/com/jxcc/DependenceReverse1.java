package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-05 21:26
 */
public class DependenceReverse1 {

}

interface Device {
    public String getInfo();
}


class Email1 implements Device{
    @Override
    public String getInfo(){
        return "email";
    }
}

/**
 * 方式2解释
 *
 * 使用依赖倒转原则
 */
class Person1 {
    public void getEmail(Device device) {
        System.out.println(device.getInfo());
    }
}