package com.example.spe_main_project.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="student_info")
@Data
public class student_info {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int student_id;

    @Column
    private String student_mail;

    @Column
    private String student_name;

    @Column
    private String password;
}
