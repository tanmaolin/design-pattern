package com.jxcc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanmaolin
 * @date 2022-10-10 8:38
 */
public class Iterator {
}

class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ComputerColleageIterator implements java.util.Iterator {

    Department[] departments;

    int position = 0;

    public ComputerColleageIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {

        if(position >= departments.length || departments[position] == null) {
            return false;
        }else {
            return true;
        }

    }

    @Override
    public Object next() {
        Department department = departments[position];
        position += 1;
        return department;
    }

    @Override
    public void remove() {

    }
}

class InfoColleageIterator implements java.util.Iterator {

    List<Department> departments;
    int position = -1;

    public InfoColleageIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {

        if(position >= departments.size() - 1) {
            return false;
        }else {
            position ++;
            return true;
        }

    }

    @Override
    public Object next() {
        Department department = departments.get(position);
        return department;
    }

    @Override
    public void remove() {

    }
}

interface College {
    public String getName();
    public void addDepartment(String name);
    public java.util.Iterator createIterator();
}

class ComputerCollege implements College {

    Department[] departments;
    int count = 0; //当前数组中的个数

    public ComputerCollege() {
        this.departments = new Department[5];
        addDepartment("java");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void addDepartment(String name) {
        Department department = new Department(name);
        departments[count] = department;
        count ++;
    }

    @Override
    public java.util.Iterator createIterator() {
        return new ComputerColleageIterator(departments);
    }
}

class InfoCollege implements College {

    List<Department> departments;
    int count = 0; //当前数组中的个数

    public InfoCollege() {
        this.departments = new ArrayList<>();
        addDepartment("java");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void addDepartment(String name) {
        Department department = new Department(name);
        departments.add(department);
        count ++;
    }

    @Override
    public java.util.Iterator createIterator() {
        return new InfoColleageIterator(departments);
    }
}

class OutPutImpl {
    //学院集合
    List<College> colleges;

    public OutPutImpl(List<College> colleges) {
        this.colleges = colleges;
    }
    //遍历学院
    public void printCollege() {
        java.util.Iterator<College> iterator = colleges.iterator();
        while (iterator.hasNext()) {
            College college = iterator.next();
            printDepartment(college.createIterator());
        }
    }

    //遍历专业
    public void printDepartment(java.util.Iterator iterator) {
        while (iterator.hasNext()) {
            Department department = (Department) iterator.next();
            System.out.println(department.getName());
        }
    }
}