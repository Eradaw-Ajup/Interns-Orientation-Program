/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eradaw.springProject.repository;

import com.eradaw.springProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pujawadare
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
