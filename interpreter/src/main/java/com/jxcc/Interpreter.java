package com.jxcc;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author tanmaolin
 * @date 2022-10-12 10:31
 */
public class Interpreter {
}

class Calculator {

    //表达式
    private Expression expression;

    //
    public Calculator(String expStr) { // expStr = a+b
        // 安排运算先后顺序
        Stack<Expression> stack = new Stack<>();
        // 表达式拆分成字符数组
        char[] charArray = expStr.toCharArray();// [a, +, b]

        Expression left = null;
        Expression right = null;
        //遍历字符数组  [a, +, b]
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+': //
                    left = stack.pop();// ??stack???left => "a"
                    right = new VarExpression(String.valueOf(charArray[++i]));// ???????? "b"
                    stack.push(new AddExpression(left, right));// ????????left ?? right ???? AddExpresson????stack
                    break;
                case '-': //
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    //???????? Var ???????? VarExpression ?????push?? stack
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                    break;
            }
        }
        //???????????? charArray ?????stack ???????Expression
        this.expression = stack.pop();
    }

    public int run(HashMap<String, Integer> var) {
        return this.expression.interpreter(var);
    }
}

abstract class Expression {

    //解释公式和数值，就是存放变量的值
    public abstract int interpreter(HashMap<String, Integer> var);

}

//变量解释器
class VarExpression extends Expression {
    private String key; // key=a,key=b,key=c

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}

//抽象符号解释器，每个符号只跟他自己左右两个数字有关，但是左右两边可能出现表达式
class SymbolExpression extends Expression {

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    //因为 SymbolExpression是让其子类来实现，因此 interpreter 是一个默认是实现
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        // TODO Auto-generated method stub
        return 0;
    }
}

class SubExpression extends SymbolExpression {

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    //处理相减
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }

}

//加法解释器
class AddExpression extends SymbolExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    //处理相加
    //var {a=10,b=20}
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        //super.left.interpreter(var) 返回left表达式的值
        //super.right.interpreter(var): 返回right表达式的值
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}


