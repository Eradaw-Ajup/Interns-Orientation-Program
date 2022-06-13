/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eradaw.springProject.service;

import com.eradaw.springProject.model.Teacher;
import java.util.List;

/**
 *
 * @author pujawadare
 */
public interface TeacherService {
    List<Teacher> getAllTeacher();
    void saveTeacher(Teacher teacher);
    Teacher getTeacherById(long id);
    void deleteTeacherById(long id);
    List<String> getAllSubject();
}
