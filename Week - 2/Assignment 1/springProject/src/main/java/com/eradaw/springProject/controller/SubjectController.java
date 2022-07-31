package com.eradaw.springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eradaw.springProject.model.Subject;
import com.eradaw.springProject.service.SubjectService;

@Controller
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/viewSubjects")
	public String viewSubjects(Model model) {
		model.addAttribute("listSubject", subjectService.getAllSubjects());
		return "subjects";
	}
    @GetMapping("/showNewSubjectForm")
    public String showNewSubjectForm(Model model){
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "new_subject";
    }
    
    @PostMapping("/saveSubject")
    public String saveSubject(@ModelAttribute("subject")Subject subject){
        // save student to database
        subjectService.saveSubject(subject);
        return "redirect:/viewSubjects";
    }
    @GetMapping("/showFormForUpdateSubject/{id}")
    public String showFormForUpdateSubject(@PathVariable (value = "id")long id, Model model){
        // get student from the service
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        return "update_subject";
    }
    @GetMapping("/deleteSubject/{id}")
    public String deleteSubject(@PathVariable (value = "id")long id, Model model){
        //call delete student method
        this.subjectService.deleteSubjectById(id);
        return "redirect:/viewSubjects";
    }
}
