package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-11 17:02
 */
public class PrototypeModule1 {
    public static void main(String[] args) {
        Sheep1 sheep1 = new Sheep1("tom", 1, "write", new Sheep1("jack", 2, "write"));
        Sheep1 sheep2 = (Sheep1)sheep1.clone();
        Sheep1 sheep3 = (Sheep1)sheep1.clone();
        Sheep1 sheep4 = sheep1;
        System.out.println(sheep1 == sheep2);
        System.out.println(sheep1 == sheep4);
        /**
         * 克隆是把这个对象的属性一一克隆到一个对象里面，其中属性中的属性是基本类型还是引用数据类型
         * 针对基本数据类型是进行拷贝一份，而对引用数据类型是将被拷贝的对象中引用属性指向拷贝对象引用属性的地址（引用转递）——》（浅拷贝）
         */

        System.out.println(sheep1 + "" + sheep1.getFriend().hashCode());
        System.out.println(sheep2 + "" + sheep2.getFriend().hashCode());
        System.out.println(sheep3 + "" + sheep3.getFriend().hashCode());
    }
}

//创建十只🐏，具有相同的属性名字，使用克隆的方式
class Sheep1 implements Cloneable{
    private String name;

    private Integer age;

    private String color;

    //深拷贝问题
    private Sheep1 friend;

    public Sheep1() {
    }

    public Sheep1(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Sheep1(String name, Integer age, String color, Sheep1 friend) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Sheep1 getFriend() {
        return friend;
    }

    public void setFriend(Sheep1 friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    protected Object clone() {
        try {
            Sheep1 sheep = (Sheep1)super.clone();
            return sheep;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
