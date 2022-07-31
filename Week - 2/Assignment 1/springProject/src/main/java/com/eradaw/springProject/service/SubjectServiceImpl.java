package com.eradaw.springProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eradaw.springProject.model.Subject;
import com.eradaw.springProject.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	@Override
	public List<Subject> getAllSubjects() {
		return subjectRepository.findAll();
	}

	@Override
	public void saveSubject(Subject subject) {
		this.subjectRepository.save(subject);
	}

	@Override
	public Subject getSubjectById(long id) {
		Optional<Subject> optional = subjectRepository.findById(id);
		Subject subject = null;
		if (optional.isPresent()) subject = optional.get();
		else throw new RuntimeException("Subject not found for id :: "+ id);
		return subject;
	}

	@Override
	public void deleteSubjectById(long id) {
		this.subjectRepository.deleteById(id);
	}

}
