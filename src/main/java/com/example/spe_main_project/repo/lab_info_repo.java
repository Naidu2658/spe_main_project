package com.example.spe_main_project.repo;

import com.example.spe_main_project.entity.lab_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public interface lab_info_repo extends JpaRepository<lab_info, String> {

    @Query(value = "select file from lab_info where course_name=?1", nativeQuery = true)
    List<MultipartFile> getlabbycoursename(String course_name);
}
