package com.example.spe_main_project.controller;

import com.example.spe_main_project.dto.AuthRequestStudentDto;
import com.example.spe_main_project.dto.StudentRegisterDto;
import com.example.spe_main_project.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    @PostMapping(value = "/student_login")
    public ResponseEntity<?> loginStudent(@RequestBody AuthRequestStudentDto authRequestStudentDto)
    {
        String id=studentservice.login(authRequestStudentDto);
        return ResponseEntity.ok(id);
    }

    @GetMapping(value = "/view_courses/{student_mail}")
    public ResponseEntity<?> viewcourses(@PathVariable("student_mail") String student_mail)
    {
        List<String> courses= studentservice.viewCourses(student_mail);
        return ResponseEntity.ok(courses);
    }

    @GetMapping(value = "/view_tasks/{student_mail}/{course_name}")
    public ResponseEntity<?> viewtasks(@PathVariable("student_mail") String student_mail, @PathVariable("course_name") String course_name)
    {
        List<MultipartFile> tasks=studentservice.viewTasks(student_mail,course_name);
        return ResponseEntity.ok(tasks);
    }

}
