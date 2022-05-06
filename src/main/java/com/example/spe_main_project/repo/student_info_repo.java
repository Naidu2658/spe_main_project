package com.example.spe_main_project.repo;

import com.example.spe_main_project.entity.student_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface student_info_repo extends JpaRepository<student_info, Integer> {

    @Query(value = "select * from student_info where student_mail=?1", nativeQuery = true)
    student_info getstudentbymail(String studnet_mail);

}
