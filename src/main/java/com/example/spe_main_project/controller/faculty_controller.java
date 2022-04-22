package com.example.spe_main_project.controller;

import com.example.spe_main_project.service.facultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.spe_main_project.dto.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"})
public class faculty_controller {

    @Autowired
    private facultyService facultyservice;

    @PostMapping(value="/register-faculty")
    public ResponseEntity<?> faculty_register(@RequestBody FacultyRegistrationDto facultyregistrationdto)
    {
        String id=facultyservice.registerFaculty(facultyregistrationdto);
        return ResponseEntity.ok(id);
    }

    @PostMapping(value="/faculty-login")
        public ResponseEntity<?> faculty_login(@RequestBody AuthRequest authrequest)
        {
          String id= facultyservice.loginfaculty(authrequest);
          return ResponseEntity.ok(id);
        }

}
