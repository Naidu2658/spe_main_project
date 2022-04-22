package com.example.spe_main_project.service;


import com.example.spe_main_project.dto.AuthRequest;
import com.example.spe_main_project.dto.FacultyRegistrationDto;
import com.example.spe_main_project.entity.faculty_info;
import com.example.spe_main_project.repo.faculty_info_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class facultyService {

    @Autowired
    private faculty_info_repo facultyInfoRepo;

    public String registerFaculty(FacultyRegistrationDto facultyRegistrationDto)
    {
      faculty_info facultyinfo= facultyInfoRepo.getfacultybymail(facultyRegistrationDto.getFaculty_email());
      if(facultyinfo==null)
      {
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

}
