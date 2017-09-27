/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itstep.service;

import itstep.pojo.Group;
import java.util.List;



public interface GroupService {

    public Group getGroup(String groupName);

    public Group createAndUpdateGroup(Group group);

    public void deleteGroup(String groupName);

    List<Group> findAllByCourse(int course);

    public boolean isUnique(Group group);
}
