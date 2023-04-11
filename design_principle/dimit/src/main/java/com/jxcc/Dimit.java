package com.jxcc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanmaolin
 * @date 2022-09-06 10:00
 */
public class Dimit {
}


/**
 * 迪米特法则：最少知道原则，一个对象应该对其他对象保持最少知道
 *
 * 直接朋友： 就是在类的实例变量、方法参数、返回值
 * 间接朋友： 在方法内部，新建了一个对象
 *
 * 迪米特法则，就是尽量不要在方法内部直接新建一个陌生的类对象
 */
class Employee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


class CollegeEmployee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


class CollegeManager {
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("Ñ§ÔºÔ±¹¤id= " + i);
            list.add(emp);
        }
        return list;
    }
}

/**
 * 直接朋友：Employee、CollegeManager
 * 间接朋友：CollegeEmployee
 *
 * 违背了迪米特法则
 */
class SchoolManager {
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();

        for (int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.setId("Ñ§Ð£×Ü²¿Ô±¹¤id= " + i);
            list.add(emp);
        }
        return list;
    }

    void printAllEmployee(CollegeManager sub) {
        //CollegeEmployee是陌生类直接引入的，所以这里违背了迪米特法则
        List<CollegeEmployee> list1 = sub.getAllEmployee();
        System.out.println("------------·Ö¹«Ë¾Ô±¹¤------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("------------Ñ§Ð£×Ü²¿Ô±¹¤------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}
