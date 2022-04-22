package com.example.spe_main_project.service;

import com.example.spe_main_project.dto.StudentRegisterDto;
import com.example.spe_main_project.entity.student_info;
import com.example.spe_main_project.repo.student_info_repo;
import org.springframework.stereotype.Service;

@Service
public class studentService {

    private student_info_repo studentInfoRepo;

    public String register(StudentRegisterDto studentRegisterDto)
    {
        student_info studentInfo=studentInfoRepo.getstudentbymail(studentRegisterDto.getStudent_mail());
        if(studentInfo==null)
        {
            studentInfo.setStudent_mail(studentRegisterDto.getStudent_mail());
            studentInfo.setStudent_name(studentRegisterDto.getStudent_name());
            studentInfo.setPassword(studentRegisterDto.getPassword());
            try
            {
                studentInfoRepo.save(studentInfo);
            }
            catch (Exception e)
            {
                return null;
            }
        }
        return null;
    }
}
