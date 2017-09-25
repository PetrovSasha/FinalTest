/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itstep.service;

import itstep.pojo.Group;
import itstep.pojo.Teacher;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TeacherService {

	public Teacher getTeacher(String login);
	
	public Teacher createAndUpdateTeacher(Teacher teacher);
	
	public void deleteTeacher(Teacher teacher);

	public List<Group> findGroupsByTeacher(Teacher teacher);

    public boolean isUnique(Teacher teacher);
	
}
