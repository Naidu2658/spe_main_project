package com.example.spe_main_project.repo;

import com.example.spe_main_project.entity.faculty_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface faculty_info_repo  extends JpaRepository<faculty_info, Integer> {
    @Query(value = "select * from faculty_info  where faculty_mail=?1", nativeQuery = true)
    faculty_info getfacultybymail(String faculty_mail); //this method return faculty_info type i.e like entire row

}
