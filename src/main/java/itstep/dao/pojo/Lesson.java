/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itstep.pojo;

/**
 *
 * @author admin
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "LESSONS")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID", nullable = false)
    private Long lessonId;

    @Column(name = "START_TIME", nullable = false)
    private Long lessonStart;

    @Column(name = "LENGTH", nullable = false)
    private Long length;

    @Column(name = "TEACHER", nullable = false)
    private String teacher;

    @Column(name = "GROUP_NAME", nullable = false)
    private String group;

    @Column(name = "ROOM", nullable = false)
    private String room;

    @Column(name = "SUBJECT", nullable = false)
    private String subject;

    public Lesson() {
    }

}
