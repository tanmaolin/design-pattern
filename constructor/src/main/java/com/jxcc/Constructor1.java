package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-13 15:12
 */
public class Constructor1 {

}

class HomeDirector {
    HomeBuilder homeBuilder;

    //构造器注入
    public HomeDirector(HomeBuilder homeBuilder) {
        this.homeBuilder = homeBuilder;
    }

    //set方法注入
    public void setHomeBuilder(HomeBuilder homeBuilder) {
        this.homeBuilder = homeBuilder;
    }

    public Home1 constructHome() {
        return null;
    }
}

abstract class HomeBuilder {
    protected Home1 home1;

    public Home1 builderHome() {
        return home1;
    }
}

class CommonHome1 extends HomeBuilder {

}

class HighHome1 extends HomeBuilder {

}

class Home1 {

    public void build() {
    }
}