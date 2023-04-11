package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-30 8:32
 */
public class StaticProxy {
}

interface ITeacherDao {
    public void teach();
}

class TeacherDao implements ITeacherDao{

    @Override
    public void teach() {
        System.out.println("老师授课");
    }
}

class TeacherDaoProxy implements ITeacherDao{

    private ITeacherDao teacherDao;

    public TeacherDaoProxy(ITeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void teach() {
        System.out.println("静态代理对象");
        teacherDao.teach();
    }
}