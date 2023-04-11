package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-13 15:12
 */
public class Constructor {
}

abstract class Home {
    abstract void buildBasic();

    abstract void buildWalls();

    abstract void roofed();

    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }
}

class CommonHome extends Home {

    @Override
    void buildBasic() {

    }

    @Override
    void buildWalls() {

    }

    @Override
    void roofed() {

    }
}
