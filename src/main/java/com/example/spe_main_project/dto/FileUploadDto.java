package com.example.spe_main_project.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadDto {
    MultipartFile file;
}
