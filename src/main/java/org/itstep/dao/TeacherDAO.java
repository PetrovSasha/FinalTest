/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.dao;
import java.util.List;

import itstep.pojo.Group;
import itstep.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherDAO extends JpaRepository<Teacher, String>{
	
	@Query(value = "SELECT * FROM GROUPS WHERE TEACHER = ?1", nativeQuery = true)
	public List<Group> findGroupsByTeacher(Teacher teacher);
	
}