package com.example.spe_main_project.controller;

import com.example.spe_main_project.entity.lab_info;
import com.example.spe_main_project.service.facultyService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONValue;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.example.spe_main_project.dto.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class Facultycontroller {

    @Autowired
    private facultyService facultyservice;

    @PostMapping(value="/registerfaculty")
    public ResponseEntity<?> faculty_register(@RequestBody FacultyRegistrationDto facultyregistrationdto)
    {
        System.out.println("hii");
        System.out.println(facultyregistrationdto);
        String id=facultyservice.registerFaculty(facultyregistrationdto);
        return ResponseEntity.ok(id);
    }

    @PostMapping(value="/facultylogin")
    public ResponseEntity<?> faculty_login(@RequestBody AuthRequest authrequest)
    {
        System.out.println("login request");
        System.out.println(authrequest.toString());
        String id= facultyservice.loginfaculty(authrequest);
        return ResponseEntity.ok(id);
    }

    @PostMapping(value = "/createlab", consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<?> create_lab(@RequestParam("course_name") String course_name,@RequestParam("faculty_mail") String faculty_mail,@RequestParam("description") String description,@RequestParam("file") MultipartFile file)
    {

        System.out.println("inside create lalb");
        CreateLabDto createLabDto=new CreateLabDto();
        createLabDto.setFaculty_mail(faculty_mail);
        createLabDto.setCourse_name(course_name);
        createLabDto.setDescription(description);
//        System.out.println(createLabDto);
        createLabDto.setFile(file);
        System.out.println(createLabDto);

        String id=facultyservice.createlab(createLabDto);
        return ResponseEntity.ok("id");
    }

    @GetMapping(value = "/viewlab/{course_name}/{faculty_mail}")
    public void view_lab(@PathVariable("course_name") String course_name, @PathVariable("faculty_mail") String faculty_mail, HttpServletResponse response)
    {
//        System.out.println("inside view lalb");
   //     List<lab_info> files=new ArrayList<>();
          lab_info files=facultyservice.viewlab(course_name, faculty_mail);

        try {
            File file = new File("src/main/resources/targetFile.tmp");
            InputStream inputStream = new FileInputStream(file);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename="+file+".txt");
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception e){
            //LOGGER.debug("Request could not be completed at this moment. Please try again.");
            e.printStackTrace();
        }
//        System.out.println(files);
        //return ResponseEntity.ok("fine");
    }
//
//    @GetMapping(value = "/viewlab/{course_name}/{faculty_mail}")
//    public void view_lab( @PathVariable("course_name") String course_name, @PathVariable("faculty_mail") String faculty_mail,HttpServletResponse response) throws IOException {
////        System.out.println("inside view lalb");
//        //     List<lab_info> files=new ArrayList<>();
//        lab_info files=facultyservice.viewlab(course_name, faculty_mail);
//        File file = new File("src/main/resources/targetFile.tmp");
//
//        try (OutputStream os = new FileOutputStream(file)) {
//            os.write(files.getFile());
//        }
//        try {
//            File file1 = new File("src/main/resources/targetFile.tmp");
//            InputStream inputStream = new FileInputStream(file1);
//            response.setContentType("application/octet-stream");
//            response.setHeader("Content-Disposition", "attachment; filename="+file1+".txt");
//            IOUtils.copy(inputStream, response.getOutputStream());
//            response.flushBuffer();
//            inputStream.close();
//        } catch (Exception e){
//            //LOGGER.debug("Request could not be completed at this moment. Please try again.");
//            e.printStackTrace();
//        }
////        System.out.println(files);
//        //return ResponseEntity.ok("fine");
//    }

}
