/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import lombok.extern.slf4j.Slf4j;
import itstep.pojo.Group;
import itstep.pojo.Lesson;
import itstep.pojo.Student;
import itstep.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        if (studentService.isUnique(student.getLogin())) {
            Student studentDB = studentService.createAndUpdateStudent(student);
            return new ResponseEntity<Student>(studentDB, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        if (!studentService.isUnique(student.getLogin())) {
            Student studentDB = studentService.createAndUpdateStudent(student);
            return new ResponseEntity<Student>(studentDB, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/get-one-by-login")
    public ResponseEntity<Student> getOne(String login) {
        Student studentDB = studentService.getStudent(login);

        if (studentDB != null) {
            return new ResponseEntity<Student>(studentDB, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping

    public ResponseEntity deleteStudent(Student student) {
        try {
            studentService.deleteStudent(student);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
