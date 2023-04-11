package com.jxcc;

import java.io.*;

/**
 * @author tanmaolin
 * @date 2022-09-11 17:02
 */
public class PrototypeModule2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep2 sheep1 = new Sheep2("tom", 1, "write", new Sheep2("jack", 2, "write"));
        Sheep2 sheep2 = (Sheep2)sheep1.clone();
        Sheep2 sheep3 = (Sheep2)sheep1.clone();
        /**
         * 深克隆
         */
    }
}

//创建十只🐏，具有相同的属性名字，使用克隆的方式
class Sheep2 implements Cloneable, Serializable {
    private String name;

    private Integer age;

    private String color;

    //深拷贝问题
    private Sheep2 friend;

    public Sheep2() {
    }

    public Sheep2(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Sheep2(String name, Integer age, String color, Sheep2 friend) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.friend = friend;
    }

    /**
     * 深拷贝，方式一
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep2 sheep2 = (Sheep2) super.clone();
        Sheep2 sheep3 = (Sheep2) friend.clone();
        sheep2.friend = sheep3;
        return sheep2;
    }

    /**
     * 深拷贝，方式二
     * @return
     */
    public Object deepClone() {
        //B
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return (Sheep2) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {

        }
    }
}
