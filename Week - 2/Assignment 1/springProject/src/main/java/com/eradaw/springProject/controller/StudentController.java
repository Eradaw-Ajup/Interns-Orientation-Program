 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eradaw.springProject.controller;

import com.eradaw.springProject.model.Student;
import com.eradaw.springProject.service.StudentService;
import com.eradaw.springProject.service.SubjectService;

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
public class StudentController {
    // display list of students
    @Autowired
    private StudentService studentService;
    
    @Autowired 
    private SubjectService subjectService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listStudent", studentService.getAllStudent());
        return "index";
    }
    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model){
//        create model attribute to bind form data 
    	model.addAttribute("listSubjects", subjectService.getAllSubjects());
    	model.addAttribute("student", new Student());
        return "new_student";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student){
        // save student to database
        studentService.saveStudent(student);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdateStudent/{id}")
    public String showFormForUpdateStudent(@PathVariable (value = "id")long id, Model model){
        // get student from the service
        Student student = studentService.getStudentById(id);
        model.addAttribute("listSubjects", subjectService.getAllSubjects());
        model.addAttribute("student", student);
        return "update_student";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable (value = "id")long id, Model model){
        //call delete student method
        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }
    
}
