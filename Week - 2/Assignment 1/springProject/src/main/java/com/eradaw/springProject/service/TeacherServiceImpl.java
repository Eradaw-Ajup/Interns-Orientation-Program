/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eradaw.springProject.service;

import com.eradaw.springProject.model.Teacher;
import com.eradaw.springProject.repository.TeacherRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pujawadare
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    
    private TeacherRepository teacherRepository;
    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }
    @Override
    public void saveTeacher(Teacher teacher){
        this.teacherRepository.save(teacher);
    }
    @Override
    public Teacher getTeacherById(long id){
        Optional<Teacher> optional = teacherRepository.findById(id);
        Teacher teacher = null;
        if (optional.isPresent()){teacher = optional.get();}
        else {throw new RuntimeException("Teacher not found for id :: "+ id);}
        return teacher;
    }
    @Override
    public void deleteTeacherById(long id){
        this.teacherRepository.deleteById(id);
    }
    @Override
    public List<String> getAllSubject() {
        Set<String> subjectSet = new HashSet<>();
        List<Teacher> lst = getAllTeacher();
        for (int i = 0; i < lst.size(); i++){
            subjectSet.add(lst.get(i).getSubject());
        }
        List<String> sub = new ArrayList<>();
        subjectSet.forEach(s -> {
            sub.add(s);
        });
        return sub;
    }
}