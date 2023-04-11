package com.jxcc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanmaolin
 * @date 2022-09-28 23:19
 */
public class Component {
}

abstract class OrganizationComponent {

    private String name;
    private String des;

    public void add(OrganizationComponent organizationComponent) {
        //默认实现
        throw new UnsupportedOperationException();
    }

    public void remove(OrganizationComponent organizationComponent) {
        //默认实现
        throw new UnsupportedOperationException();
    }

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public abstract void print();
}

class University extends OrganizationComponent {

    List<OrganizationComponent> list = new ArrayList<>();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    public void add(OrganizationComponent organizationComponent) {
        list.add(organizationComponent);
    }

    @Override
    public void remove(OrganizationComponent organizationComponent) {
        list.remove(organizationComponent);
    }

    @Override
    public void print() {
        System.out.println(super.getName() + super.getDes());
    }
}

class College extends OrganizationComponent {
    List<OrganizationComponent> list = new ArrayList<>();

    public College(String name, String des) {
        super(name, des);
    }

    @Override
    public void add(OrganizationComponent organizationComponent) {
        list.add(organizationComponent);
    }
    @Override
    public void remove(OrganizationComponent organizationComponent) {
        list.remove(organizationComponent);
    }

    @Override
    public void print() {
        System.out.println(super.getName() + super.getDes());
    }
}

class Department extends OrganizationComponent {

    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    public void print() {
        System.out.println(super.getName() + super.getDes());
    }
}

