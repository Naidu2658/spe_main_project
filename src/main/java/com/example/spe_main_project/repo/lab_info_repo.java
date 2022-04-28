package com.example.spe_main_project.repo;

import com.example.spe_main_project.entity.lab_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface lab_info_repo extends JpaRepository<lab_info, Integer> {

    @Query(value = "select * from lab_info where course_name=?1", nativeQuery = true)
    List<lab_info> getlabbycoursename(String course_name);

    @Query(value = "select * from lab_info where  course_name=?1 and faculty_mail=?2", nativeQuery = true)
    lab_info getlabbycourse_and_facultymail( String course_name, String faculty_mail);
}
