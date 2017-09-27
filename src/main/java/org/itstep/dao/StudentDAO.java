/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.dao;
import java.util.List;

import itstep.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO extends JpaRepository<Student, String>{
	
	@Query(value = "SELECT * FROM STUDENTS WHERE STUDENT_GROUP = ?1", nativeQuery = true)
	public List<Student> findStudentsByGroup(String group);
	
	@Query(value = "SELECT * FROM STUDENTS INNER JOIN ON "
			+ "STUDENT_GROUP =  GROUPS.GROUP_NAME WHERE GROUPS.COURSE = ?1", nativeQuery = true)
	public List<Student> findAllStudentsByCourse(Integer course);
}