package com.example.spe_main_project.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="class_info")
@Data
public class course_info {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column
    private String course_id;

    @Column
    private String course_name;

    @Column
    private String faculty_mail;
}
