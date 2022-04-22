package com.example.spe_main_project.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="lab_info")
@Data
public class lab_info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String lab_id;

    @Column
    private String description;

    @Column
    private String class_id;

    @Column
    private String faculty_mail;

    @Lob
    @Column
    private byte[] file;


}
