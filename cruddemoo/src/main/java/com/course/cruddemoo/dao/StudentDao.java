package com.course.cruddemoo.dao;

import com.course.cruddemoo.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    void update(Student theStudent);
    void delete(Integer id);

}
