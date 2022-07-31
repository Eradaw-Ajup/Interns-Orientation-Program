/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eradaw.springProject.service;

import com.eradaw.springProject.model.Student;
import java.util.List;

/**
 *
 * @author pujawadare
 */
public interface StudentService {
    List<Student> getAllStudent();
    void saveStudent(Student student);
    Student getStudentById(long id);
    void deleteStudentById(long id);
}
