/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eradaw.springProject.controller;

import com.eradaw.springProject.model.Teacher;
import com.eradaw.springProject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author pujawadare
 */

@Controller
public class TeacherController {
    // display list of students
    @Autowired
    private TeacherService teacherService;
    
    @GetMapping("/viewTeacher")
    public String viewTeacher(Model model){
        model.addAttribute("listTeacher", teacherService.getAllTeacher());
        model.addAttribute("listSubject", teacherService.getAllSubject());
        return "tindex"; 
    }
    @GetMapping("/showNewTeacherForm")
    public String showNewTeacherForm(Model model){
//        create model attribute to bind form data 
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "new_teacher";
    }
    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher")Teacher teacher){
        // save teacher to database
        teacherService.saveTeacher(teacher);
        return "redirect:/viewTeacher";
    }
    @GetMapping("/showFormForUpdateTeacher/{id}")
    public String showFormForUpdateTeacher(@PathVariable (value = "id")long id, Model model){
        // get student from the service
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "update_teacher";
    }
    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable (value = "id")long id, Model model){
        //call delete student method
        this.teacherService.deleteTeacherById(id);
        return "redirect:/viewTeacher";
    }
}
