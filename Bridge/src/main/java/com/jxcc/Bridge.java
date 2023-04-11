package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-20 8:46
 */
public class Bridge {
}

abstract class Phone {
    Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open() {
        this.brand.open();
    }

    protected void close() {
        this.brand.close();
    }
}
class FoldedPhone extends Phone{

    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    public void close() {
        super.close();
    }
}

class SolidPhone extends Phone{

    public SolidPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    public void close() {
        super.close();
    }
}

interface Brand {
    void open();
    void close();
}

class Xiaomi implements Brand {
    @Override
    public void open() {

    }

    @Override
    public void close() {

    }
}


class HUAWEI implements Brand {
    @Override
    public void open() {

    }

    @Override
    public void close() {

    }
}

