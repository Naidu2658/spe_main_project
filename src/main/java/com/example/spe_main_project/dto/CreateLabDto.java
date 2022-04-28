package com.example.spe_main_project.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

@Data
public class CreateLabDto {

    private String course_name;
    private String description;
    private String faculty_mail;
    private MultipartFile file;

}
