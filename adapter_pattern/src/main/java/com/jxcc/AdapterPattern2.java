package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-19 8:58
 */
public class AdapterPattern2 {
    public static void main(String[] args) {
        //需要具体实现的方法
        new AbsAdapter() {
            @Override
            public void m1() {
                super.m1();
            }
        };
    }
}


interface Interface4 {
    public void m1();
    public void m2();
    public void m3();
    public void m4();

}

//将Interface4的方法空实现
abstract class AbsAdapter implements Interface4 {
    @Override
    public void m1(){}

    @Override
    public void m2(){}

    @Override
    public void m3(){}

    @Override
    public void m4(){}
}
