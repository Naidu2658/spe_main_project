package com.example.spe_main_project.repo;

import com.example.spe_main_project.entity.course_student_mapping_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface course_student_mapping_info_repo extends JpaRepository<course_student_mapping_info, String> {

    @Query(value = "select course_name from course_student_mapping_info  where studnet_mail=?1", nativeQuery = true)
    List<String> getcoursebystudentmail(String student_mail);
}
