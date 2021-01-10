package com.hundsun.dao;

import com.hundsun.domain.Student;

import java.util.List;

public interface StudentDao {

    //定义添加方法
    int insertStudent(Student student);

    //定义查询方法
    List<Student> selectStudents();
}
