/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.service.impl;

import itstep.pojo.Group;
import itstep.pojo.Teacher;
import itstep.service.TeacherService;
import java.util.List;
import org.itstep.dao.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherDAO teacherDAO;

    @Override
    public Teacher getTeacher(String login) {
        return teacherDAO.getOne(login);
    }

    @Override
    public Teacher createAndUpdateTeacher(Teacher teacher) {
        return teacherDAO.saveAndFlush(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherDAO.delete(teacher.getLogin());

    }

    @Override
    public List<Group> findGroupsByTeacher(Teacher teacher) {
        return teacherDAO.findGroupsByTeacher(teacher);
    }

    @Override
    public boolean isUnique(Teacher teacher) {
        return false;

    }
}
