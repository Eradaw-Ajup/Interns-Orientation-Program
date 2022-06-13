/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eradaw.springProject.repository;

import com.eradaw.springProject.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pujawadare
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
