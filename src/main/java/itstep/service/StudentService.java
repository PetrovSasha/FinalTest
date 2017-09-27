/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itstep.service;

import itstep.pojo.Student;
import java.util.List;

/**
 *
 * @author admin
 */
public interface StudentService {

    public Student getStudent(String login);

    public Student createAndUpdateStudent(Student student);

    public void deleteStudent(Student student);

    public List<Student> findStudentsByGroup(String group);

    public List<Student> findAllStudentsByCourse(int course);

    public boolean isUnique(String login);
}
