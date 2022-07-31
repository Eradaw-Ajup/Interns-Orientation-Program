package com.eradaw.springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eradaw.springProject.model.Teacher;
import com.eradaw.springProject.service.SubjectService;
import com.eradaw.springProject.service.TeacherService;

@Controller
public class teacherController {
	@Autowired
	private TeacherService teacherService;
    @Autowired 
    private SubjectService subjectService;
	
	@GetMapping("/viewTeachers")
	public String viewTeachers(Model model) {
		model.addAttribute("listTeachers", teacherService.getAllTeachers());
		return "teachers";
	}
	@GetMapping("/showNewTeacherForm")
    public String showNewTeacherForm(Model model){
//        create model attribute to bind form data 
    	model.addAttribute("listSubjects", subjectService.getAllSubjects());
    	model.addAttribute("teacher", new Teacher());
        return "new_teacher";
    }
    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher")Teacher teacher){
        // save student to database
        teacherService.saveTeacher(teacher);
        return "redirect:/viewTeachers";
    }
    @GetMapping("/showFormForUpdateTeacher/{id}")
    public String showFormForUpdateTeacher(@PathVariable (value = "id")long id, Model model){
        // get student from the service
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("listSubjects", subjectService.getAllSubjects());
        model.addAttribute("teacher", teacher);
        return "update_teacher";
    }
    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable (value = "id")long id, Model model){
        //call delete student method
        this.teacherService.deleteTeacherById(id);
        return "redirect:/viewTeachers";
    }
}
