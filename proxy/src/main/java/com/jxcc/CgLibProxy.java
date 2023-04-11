package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-30 14:07
 */
public class CgLibProxy {
}


class TeacherDao2 {

    public void teach() {
        System.out.println("老师授课");
    }
}

//class ProxyFactory1 implements MethodInterceptor {
//
//    private Object target;
//
//    public ProxyFactory1(Object target) {
//        this.target = target;
//    }
//
//    //target的代理对象
//    public Object getProxyInstance() {
//        //创建一个工具类
//        Enhancer enhancer = new Enhancer();
//        //设置父类
//        enhancer.setSuperclass(target.getClass());
//        //设置回调函数
//        enhancer.setCallback(this);
//        //创建子类对象，即代理对象
//        return enhancer.create();
//    }
//
//    //重写这个方法，会调用目标对象的方法
//    @Override
//    public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) {
//        System.out.println("Cglib代理模式");
//        Object invoke = method.invoke(target, args);
//        return invoke;
//    }
//}