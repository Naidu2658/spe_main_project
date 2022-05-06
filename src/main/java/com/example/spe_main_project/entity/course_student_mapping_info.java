package com.example.spe_main_project.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="course_student_mapping_info")
@Data
public class course_student_mapping_info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer course_student_mapping_id;

    @Column
    private String course_name;

    @Column
    private String student_mail;

}
