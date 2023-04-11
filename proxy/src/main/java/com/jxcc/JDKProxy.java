package com.jxcc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author tanmaolin
 * @date 2022-09-30 11:02
 */
public class JDKProxy {


    public static void main(String[] args) {
        ITeacherDao1 teacherDao1 = new TeacherDao1();

        ProxyFactory proxyFactory = new ProxyFactory(teacherDao1);
        ITeacherDao1 proxyInstance = (ITeacherDao1) proxyFactory.getProxyInstance();
        System.out.println(proxyInstance);
        System.out.println(proxyInstance.getClass());
    }

}

interface ITeacherDao1 {
    public void teach();
}

class TeacherDao1 implements ITeacherDao1{

    @Override
    public void teach() {
        System.out.println("老师授课");
    }
}

class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * ClassLoader loader : 指定当前目标对象是呀的类加载器，
     * Class</?>[] interfaces: 目标对象实现接口类型
     * InvocationHandler h : 事件处理，执行目标对象的方法，会触发时间处理器方法，
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("jdk动态代理");
                Object invoke = method.invoke(target, args);
                return invoke;
            }
        });
    }
}