package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-06 8:56
 */
public class OpenClose {
}


/**
 * 开闭原则
 * 对修改关闭（使用方），对拓展开放（提供方）
 *
 * 这个时候需要添加一个三角形，那么使用类A，就修改添加代码，判断对象是三角型，然后调用对应的方法，这样违背了该原则
 * 解决思路，就是抽象化基类，然后实现同一个方法
 */
class A {

    public void drawShape(Shape s) {
        if(s instanceof Circle) {
            drawCircle(s);
        }
        if(s instanceof Rectangle) {
            drawRectangle(s);
        }
    }

    public void drawCircle(Shape s) {
        System.out.println("绘制圆形");
    }

    public void drawRectangle(Shape s) {
        System.out.println("绘制矩形");
    }
}

class Shape {
    int r;
}

class Circle extends Shape {
    public Circle(int r) {
        super.r = r;
    }
}

class Rectangle extends Shape {
    public Rectangle(int r) {
        super.r = r;
    }
}
