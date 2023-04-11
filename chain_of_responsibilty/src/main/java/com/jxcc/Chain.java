package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-10-13 10:23
 */
public class Chain {

    public static void main(String[] args) {
        int i = 0;
        i = i++;
        System.out.println(i);
    }
}


class PurchaseReuqest {
    private int type = 0; // 请求类型
    private float price = 0.0f;
    private int id = 0;

    public PurchaseReuqest(int type, float price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}

abstract class Approver {
    Approver approver; //下一个处理者
    String name;// 名字

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    //处理审批请求的方法
    public abstract void processRequest(PurchaseReuqest purchaseReuqest);
}

class DepartmentApprover extends Approver {

    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseReuqest purchaseReuqest) {
        if(purchaseReuqest.getPrice() <= 5000) {
            System.out.println(purchaseReuqest.getId() + this.name);
        }else {
            approver.processRequest(purchaseReuqest);
        }
    }
}

class CollegeApprover extends Approver {
    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseReuqest purchaseReuqest) {
        if(purchaseReuqest.getPrice() >= 5000) {
            System.out.println(purchaseReuqest.getId() + this.name);
        }else {
            approver.processRequest(purchaseReuqest);
        }
    }
}