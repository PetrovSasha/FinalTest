/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.dao.test;

import itstep.pojo.Student;
import org.itstep.app.App;
import static org.junit.Assert.*;

import org.itstep.dao.StudentDAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class StudentDAOTest {

    @Autowired
    StudentDAO studentDAO;

    @Test
    public void testCreateAndGetAndDelete() {
        Student student = new Student();
        student.setLogin("student1");
        student.setPassword("220788");
        student.setFirstName("Alex");
        student.setLastName("lastName");
        student.setStudentGroup("someGroup");
        Student studentDB = studentDAO.save(student);
        assertNotNull(studentDB);
        Student checkedStudent = studentDAO.findOne(studentDB.getLogin());
        assertEquals("Alex", checkedStudent.getFirstName());
        studentDAO.delete(studentDB.getLogin());

    }

    @Test
    public void testFindStudentsByGroup() {
    }

}
