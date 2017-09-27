/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itstep.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "GROUPS")
public class Group {

    @Id
    @Column(name = "GROUP_NAME", nullable = false)
    private String groupName;

    @Column(name = "COURSE", nullable = false)
    private int course;

    public Group() {
    }
}
