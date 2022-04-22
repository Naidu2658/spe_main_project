package com.example.spe_main_project.controller;

import com.example.spe_main_project.dto.StudentRegisterDto;
import com.example.spe_main_project.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"})
public class student_controller {

    @Autowired
    private studentService studentservice;

    @PostMapping(value = "/student_registration")
    public ResponseEntity<?> registerStudent(@RequestBody StudentRegisterDto studentRegisterDto)
    {
       String id=studentservice.register(studentRegisterDto);
       return ResponseEntity.ok(id);
    }
}
