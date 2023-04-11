package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-21 9:16
 */
public class Decorator extends Drink {
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        //getPrice()是装饰者自己的价格
        //cost()是dirnk的价格
        return super.getPrice() + drink.cost();
    }


    @Override
    public String getDes() {
        //输出被装饰者的信息
        return super.des + " " + super.getPrice() + "&&" + super.getDes();
    }
}

class Chocolate extends Decorator {

    public Chocolate(Drink drink) {
        super(drink);
        setDes("巧克力");
        setPrice(3.00f);
    }
}

class Mill extends Decorator {

    public Mill(Drink drink) {
        super(drink);
        setDes("牛奶");
        setPrice(2.00f);
    }
}

abstract class Drink {
    public String des;
    private float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}

class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}

class Expresso extends Coffee {
    public Expresso() {
        setDes("咖啡1");
        setPrice(10.00f);
    }
}

class LongBlack extends Coffee {
    public LongBlack() {
        setDes("咖啡2");
        setPrice(12.00f);
    }
}