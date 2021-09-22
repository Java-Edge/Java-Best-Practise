package com.javaedge.mybatis;

import java.util.List;

/**
 * @author apple
 * @date 1/26/23
 */
public interface StudentMapper {

    List<Student> findAllStudents();

    Student findStudentById(Integer id);

    void insertStudent(Student student);
}