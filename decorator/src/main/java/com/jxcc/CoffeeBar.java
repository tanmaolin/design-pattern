package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-28 9:10
 */
public class CoffeeBar {

    //说明
    //1. InputStream 是抽象类，类似我们前面讲的Drink
    //2. FileInputStream 是InputStream 子类,类似我们前面的DeCaf, LongBlack
    //3. FilterInputStream 是InputStream 子类:类似我们前面的Decorator修饰者
    //4. DataInputStream是FilterInputStream子类，具体的修饰者,类似前面的Milk, Soy. 等
    //5. FilterInputStream 类有protected volatile InputStream in;即含被装饰者
    //6.分析得出在jdk的io体系中，就是使用装饰者模式

    public static void main(String[] args) {
        Drink order = new LongBlack();
        System.out.println(order.cost());
        System.out.println(order.getDes());

        //给咖啡加入牛奶
        order = new Mill(order);
        System.out.println(order.cost());
        System.out.println(order.getDes());

        //给咖啡再加入牛奶
        order = new Chocolate(order);
        System.out.println(order.cost());
        System.out.println(order.getDes());
    }
}
