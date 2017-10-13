package com.example.zhangbing.love.dao;

import com.example.zhangbing.love.MyApp;
import com.example.zhangbing.love.dao.entity.Student;
import com.example.zhangbing.love.dao.entity.StudentDao;


import java.util.List;

/**
 * 创建时间: 2017/10/12.
 * 编写人:
 * 功能描述:
 */

public class StudioDao {

    /**
     * 添加学生
     *
     * @param s
     */
    public static void insertStudent(Student s) {
        MyApp.getDaoInstant().getStudentDao().insertOrReplace(s);
    }

    /**
     * 添加多条数据
     *
     * @param students
     */
    public static void insertStudents(List<Student> students) {
        MyApp.getDaoInstant().getStudentDao().insertOrReplaceInTx(students);
    }

    /**
     * 查询全部输数据
     *
     * @return
     */
    public static List<Student> queryAll() {
        return MyApp.getDaoInstant().getStudentDao().queryBuilder().list();
    }

    /**
     * 查询某一条数据
     *
     * @param name
     * @return
     */
    public static List<Student> findStudent(String name) {
        return MyApp.getDaoInstant().getStudentDao().queryBuilder().where(StudentDao.Properties.Name.eq(name)).list();

    }
}
