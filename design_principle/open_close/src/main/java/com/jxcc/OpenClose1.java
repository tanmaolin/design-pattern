package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-06 8:56
 */
public class OpenClose1 {
}


/**
 * 开闭原则
 * 对修改关闭（使用方），对拓展开放（提供方）
 *
 */
class A1 {

    public void drawShape(Shape1 s) {
        s.draw();
    }

}

abstract class Shape1 {
    public abstract void draw();
}

class Circle1 extends Shape1 {

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

class Rectangle1 extends Shape1 {

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}
