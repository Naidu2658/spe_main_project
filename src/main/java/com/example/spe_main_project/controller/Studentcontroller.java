package com.example.spe_main_project.controller;

import com.example.spe_main_project.dto.AuthRequestStudentDto;
import com.example.spe_main_project.dto.StudentCourseRegistrationDto;
import com.example.spe_main_project.dto.StudentRegisterDto;
import com.example.spe_main_project.dto.ViewCoursesResponseDto;
import com.example.spe_main_project.entity.lab_info;
import com.example.spe_main_project.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class Studentcontroller {

    @Autowired
    private studentService studentservice;

    @PostMapping(value = "/studentregistration")
    public ResponseEntity<?> registerStudent(@RequestBody StudentRegisterDto studentRegisterDto)
    {
        System.out.println(studentRegisterDto);
       String id=studentservice.register(studentRegisterDto);
       return ResponseEntity.ok(id);
    }

    @PostMapping(value = "/studentlogin")
    public ResponseEntity<?> loginStudent(@RequestBody AuthRequestStudentDto authRequestStudentDto)
    {
        String id=studentservice.login(authRequestStudentDto);
        return ResponseEntity.ok(id);
    }

    @PostMapping(value= "/studentcourseregistration")
    public ResponseEntity<?> student_course_registration(@RequestBody StudentCourseRegistrationDto studentCourseRegistrationDto)
    {
        String id= studentservice.studentcourseregisteration(studentCourseRegistrationDto);
        return ResponseEntity.ok(id);
    }


    @GetMapping(value = "/viewcourses/{student_mail}")
    public ResponseEntity<?> viewcourses(@PathVariable("student_mail") String student_mail)
    {
        ViewCoursesResponseDto viewCoursesResponseDto=studentservice.viewCourses(student_mail);
        System.out.println("yes");
        return ResponseEntity.ok(viewCoursesResponseDto);
    }

    @GetMapping(value = "/viewtasks/{student_mail}/{course_name}")
    public ResponseEntity<?> viewtasks(@PathVariable("student_mail") String student_mail, @PathVariable("course_name") String course_name)
    {
        List<lab_info> tasks=studentservice.viewTasks(student_mail,course_name);
        return ResponseEntity.ok(tasks);
    }

}
