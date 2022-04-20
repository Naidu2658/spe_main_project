package com.example.spe_main_project.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="faculty_info")
@Data
public class faculty_info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="faculty_id")
    private String fculty_id;

    @Column
    private String faculty_mail;

    @Column
    private String faculty_name;

    @Column
    private String faculty_password;
}
