/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eradaw.springProject.service;

import com.eradaw.springProject.model.Student;
import com.eradaw.springProject.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pujawadare
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    @Override
    public void saveStudent(Student student){
        this.studentRepository.save(student);
    }
    @Override
    public Student getStudentById(long id){
        Optional<Student> optional = studentRepository.findById(id);
        Student student = null;
        if (optional.isPresent()){student = optional.get();}
        else {throw new RuntimeException("Student not found for id :: "+ id);}
        return student;
    }
    @Override
    public void deleteStudentById(long id){
        this.studentRepository.deleteById(id);
    }
}
