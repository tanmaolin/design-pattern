package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-05 21:26
 */
public class DependenceReverse {

}

class Email {
    public String getInfo(){
        return "email";
    }
}

/**
 * 方式1解释
 *
 * 依赖倒转：高层不应该依赖底层，抽象不应依赖细节，细节依赖抽象，面向接口编程
 * 1.简单，比较容易
 * 2.如果我们获取的对象是 其他的，则新增类，就需要新增方法
 * 3.解决思路就是引入一个抽象接口
 */
class Person {
    public void getEmail(Email email) {
        System.out.println(email.getInfo());
    }
}