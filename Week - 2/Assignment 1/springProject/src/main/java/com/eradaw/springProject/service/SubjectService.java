package com.eradaw.springProject.service;

import java.util.List;

import com.eradaw.springProject.model.Subject;

public interface SubjectService {
	List<Subject> getAllSubjects();
    void saveSubject(Subject subject);
    Subject getSubjectById(long id);
    void deleteSubjectById(long id);
}
