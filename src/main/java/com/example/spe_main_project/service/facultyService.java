package com.example.spe_main_project.service;


import com.example.spe_main_project.dto.AuthRequest;
import com.example.spe_main_project.dto.CreateLabDto;
import com.example.spe_main_project.dto.FacultyRegistrationDto;
import com.example.spe_main_project.entity.faculty_info;
import com.example.spe_main_project.entity.lab_info;
import com.example.spe_main_project.repo.faculty_info_repo;
import com.example.spe_main_project.repo.lab_info_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class facultyService {

    @Autowired
    private faculty_info_repo facultyInfoRepo;

    @Autowired
    private lab_info_repo labInfoRepo;

    private FileOutputStream fileOutputStream;
    public String registerFaculty(FacultyRegistrationDto facultyRegistrationDto)
    {
        System.out.println("hii");
      faculty_info facultyinfo= facultyInfoRepo.getfacultybymail(facultyRegistrationDto.getFaculty_email());
      if(facultyinfo==null)
      {
          facultyinfo=new faculty_info();
          facultyinfo.setFaculty_mail(facultyRegistrationDto.getFaculty_email());
          facultyinfo.setFaculty_name(facultyRegistrationDto.getFaculty_name());
          facultyinfo.setFaculty_password(facultyRegistrationDto.getFaculty_password());

          try
          {
              facultyInfoRepo.save(facultyinfo);
          }
          catch (Exception e)
          {
              return null;
          }
          return facultyinfo.getFaculty_mail();
      }
      return null;
    }

    public String loginfaculty(AuthRequest authrequest)
    {
        faculty_info facultyInfo=facultyInfoRepo.getfacultybymail(authrequest.getMail());
        if(facultyInfo!=null)
        {
            if(facultyInfo.getFaculty_password()== authrequest.getPassword())
            {
                return "yes";
            }
            else
            {
                return null;
            }
        }
        return null;
    }

    public String createlab(CreateLabDto createLabDto)
    {
        lab_info labinfo = new lab_info();
        try
        {
            labinfo.setFaculty_mail(createLabDto.getFaculty_mail());
            labinfo.setDescription(createLabDto.getDescription());
            labinfo.setCourse_name(createLabDto.getCourse_name());
            labinfo.setFile_type(createLabDto.getFile().getContentType());
            System.out.println(createLabDto.getFile().getContentType());
            labinfo.setFile(createLabDto.getFile().getBytes());
            File file = new File("src/main/resources/targetFile.tmp");

            try (OutputStream os = new FileOutputStream(file)) {
                os.write(createLabDto.getFile().getBytes());
            }
            System.out.println(createLabDto.getFile().getBytes());

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        try
        {
            labInfoRepo.save(labinfo);
        }
        catch (Exception e)
        {
            return null;
        }
        return null;

    }

    public lab_info viewlab(String course_name, String faculty_mail)
    {
        System.out.println(course_name);
        System.out.println(faculty_mail);
        lab_info files=labInfoRepo.getlabbycourse_and_facultymail(course_name, faculty_mail);
        System.out.println(files);
//        if(files!=null){
//            System.out.println("inside viewlab");
//            for(lab_info labInfo:files){
//                System.out.println(labInfo.getFile().toString());
//            }
//        }
        return files;
    }

     public List<lab_info> getfiles()
     {
        return labInfoRepo.findAll();
     }
}
