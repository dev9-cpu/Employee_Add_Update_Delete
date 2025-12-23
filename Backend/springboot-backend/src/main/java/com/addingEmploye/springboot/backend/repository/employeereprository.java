package com.addingEmploye.springboot.backend.repository;

import com.addingEmploye.springboot.backend.model.Employemodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeereprository extends JpaRepository<Employemodel, Long> {
        //All Curd database methods to interact with a database
}

