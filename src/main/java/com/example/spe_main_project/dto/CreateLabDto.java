package com.example.spe_main_project.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CreateLabDto {

    private String class_id;

    private String description;
    private String faculty_mail;
    private MultipartFile file;

}