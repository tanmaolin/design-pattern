package com.jxcc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanmaolin
 * @date 2022-09-06 10:00
 */
public class Dimit1 {
}


/**
 * 迪米特法则：最少知道原则，一个对象应该对其他对象保持最少知道
 *
 * 直接朋友： 就是在类的实例变量、方法参数、返回值
 * 间接朋友： 在方法内部，新建了一个对象
 *
 * 迪米特法则，就是尽量不要在方法内部直接新建一个陌生的类对象
 */
class Employee1 {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


class CollegeEmployee1 {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


class CollegeManager1 {
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("Ñ§ÔºÔ±¹¤id= " + i);
            list.add(emp);
        }
        return list;
    }

    public void getInfo() {
        List<CollegeEmployee> list1 = this.getAllEmployee();
        System.out.println("------------·Ö¹«Ë¾Ô±¹¤------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
    }
}

/**
 * 直接朋友：Employee、CollegeManager
 * 间接朋友：CollegeEmployee
 *
 * 违背了迪米特法则
 */
class SchoolManager1 {
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();

        for (int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.setId("Ñ§Ð£×Ü²¿Ô±¹¤id= " + i);
            list.add(emp);
        }
        return list;
    }

    void printAllEmployee(CollegeManager1 sub) {
        sub.getInfo();
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("------------Ñ§Ð£×Ü²¿Ô±¹¤------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}
