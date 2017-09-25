/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.service.impl;

import itstep.pojo.Student;
import java.util.List;
import org.itstep.dao.StudentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import itstep.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Override
    public Student getStudent(String login) {
        return studentDAO.findOne(login);
    }

    @Override
    public Student createAndUpdateStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDAO.delete(student.getLogin());
    }

    @Override
    public List<Student> findStudentsByGroup(String group) {
        return studentDAO.findStudentsByGroup(group);
    }

    @Override
    public List<Student> findAllStudentsByCourse(int course) {
        return studentDAO.findAllStudentsByCourse(course);
    }

    @Override
    public boolean isUnique(String login) {
        return false;
          }

}
