package com.example.spe_main_project.repo;

import com.example.spe_main_project.entity.lab_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface lab_info_repo extends JpaRepository<lab_info, String> {


}
