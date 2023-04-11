package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-19 8:58
 */
public class AdapterPattern1 {
    public static void main(String[] args) {
        Phone1 phone1 = new Phone1();
        phone1.charging(new VoltageAdapter1(new Voltage220V()));
    }
}

class Phone1 {
    public void charging (Voltage5V v) {
        if(v.output5V() == 5) {
            System.out.println("ok");
        }
        if(v.output5V() > 5 ) {
            System.out.println("error");
        }
    }
}

//对象适配类
class VoltageAdapter1 implements Voltage5V{

    protected Voltage220V v;

    public VoltageAdapter1(Voltage220V v) {
        this.v = v;
    }

    @Override
    public int output5V() {
        int dstV = 0;
        if(null != v) {
            int srcV = v.output220V();
            dstV = srcV / 44;
        }
        return dstV;
    }
}


class Voltage220V1 {
    public int output220V () {
        return 220;
    }
}

//适配接口
interface Voltage5V1 {
    public int output5V ();
}