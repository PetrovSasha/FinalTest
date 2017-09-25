/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.dao.test;

import itstep.pojo.Group;
import itstep.pojo.Lesson;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import org.itstep.app.App;
import org.itstep.dao.GroupDAO;
import org.itstep.dao.LessonDAO;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class LessonDAOTest {

    @Autowired
    LessonDAO lessonDAO;

    @Autowired
    GroupDAO groupDAO;

    @Test
    public void testGetLessonsForCourseForPeriod() {
        Lesson lesson = new Lesson();
        lesson.setLessonStart(2L);
        lesson.setLength(0L);
        lesson.setRoom("404");
        lesson.setSubject("HTML");
        lesson.setTeacher("me");
        Group group = new Group();
        group.setGroupName("group");
        group.setCourse(1);
        lesson.setGroup(group.getGroupName());
        Lesson lessonDB = lessonDAO.save(lesson);
        log.info(lessonDB.getLessonId().toString());
        Group groupDB = groupDAO.save(group);
        List<Lesson> lessonsFromDB = lessonDAO.getLessonsForCourseForPeriod(groupDB.getCourse(), 0L, 3L);
        assertNotNull(lessonsFromDB);
        assertEquals(lessonDB.getLessonId(), lessonsFromDB.get(0).getLessonId());
        groupDAO.delete(groupDB);
        lessonDAO.delete(lesson);
    }

}
