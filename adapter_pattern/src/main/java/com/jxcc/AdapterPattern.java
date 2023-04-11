package com.jxcc;


/**
 * @author tanmaolin
 * @date 2022-09-19 8:58
 */
public class AdapterPattern {

}


class Phone {
    public void charging (Voltage5V v) {
        if(v.output5V() == 5) {
            System.out.println("ok");
        }
        if(v.output5V() > 5 ) {
            System.out.println("error");
        }
    }
}

//类适配类
class VoltageAdapter extends Voltage220V implements Voltage5V{

    @Override
    public int output5V() {
        int srcV = output220V();
        int dstV = srcV / 44;
        return dstV;
    }
}


class Voltage220V {
    public int output220V () {
        return 220;
    }
}

//适配接口
interface Voltage5V {
    public int output5V ();
}