package com.example.spe_main_project.service;

import com.example.spe_main_project.dto.AuthRequestStudentDto;
import com.example.spe_main_project.dto.StudentCourseRegistrationDto;
import com.example.spe_main_project.dto.StudentRegisterDto;
import com.example.spe_main_project.dto.ViewCoursesResponseDto;
import com.example.spe_main_project.entity.course_student_mapping_info;
import com.example.spe_main_project.entity.lab_info;
import com.example.spe_main_project.entity.student_info;
import com.example.spe_main_project.repo.course_student_mapping_info_repo;
import com.example.spe_main_project.repo.lab_info_repo;
import com.example.spe_main_project.repo.student_info_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {

    @Autowired
    private student_info_repo studentInfoRepo;

    @Autowired
    private course_student_mapping_info_repo courseStudentMappingInfoRepo;

    @Autowired
    private lab_info_repo labInfoRepo;


    public String register(StudentRegisterDto studentRegisterDto)
    {
        student_info studentInfo=studentInfoRepo.getstudentbymail(studentRegisterDto.getStudent_mail());
        if(studentInfo==null)
        {
            studentInfo=new student_info();
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

    public String login(AuthRequestStudentDto authRequestStudentDto)
    {
        student_info studentInfo=studentInfoRepo.getstudentbymail(authRequestStudentDto.getStudent_mail());
        if(studentInfo!=null)
        {
            if(authRequestStudentDto.getPassword()==studentInfo.getPassword())
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

    public String studentcourseregisteration(StudentCourseRegistrationDto studentCourseRegistrationDto)
    {
        course_student_mapping_info courseStudentMappingInfo=courseStudentMappingInfoRepo.getcoursenamebystudentmailandcoursename(studentCourseRegistrationDto.getStudent_mail(), studentCourseRegistrationDto.getCourse());
        if(courseStudentMappingInfo==null)
        {
            courseStudentMappingInfo=new course_student_mapping_info();
            courseStudentMappingInfo.setStudent_mail(studentCourseRegistrationDto.getStudent_mail());
            courseStudentMappingInfo.setCourse_name(studentCourseRegistrationDto.getCourse());
            courseStudentMappingInfoRepo.save(courseStudentMappingInfo);
            return "yes";
        }
        return "no";
    }

    public ViewCoursesResponseDto viewCourses(String student_mail)
    {
        ViewCoursesResponseDto viewCoursesResponseDto=new ViewCoursesResponseDto();
       List<String> courses=courseStudentMappingInfoRepo.getcoursebystudentmail(student_mail);
       viewCoursesResponseDto.setCourses(courses);
       return viewCoursesResponseDto;
    }

    public List<lab_info> viewTasks(String student_mail, String course_name)
    {
       List<lab_info> tasks=labInfoRepo.getlabbycoursename(course_name);
       return tasks;
    }
}
