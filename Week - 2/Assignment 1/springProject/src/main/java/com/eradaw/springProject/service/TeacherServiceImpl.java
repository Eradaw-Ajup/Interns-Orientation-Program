package com.eradaw.springProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eradaw.springProject.model.Teacher;
import com.eradaw.springProject.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		this.teacherRepository.save(teacher);
	}

	@Override
	public Teacher getTeacherById(long id) {
		Optional<Teacher> optional = teacherRepository.findById(id);
		Teacher teacher = null;
		if (optional.isPresent()) teacher = optional.get();
		else throw new RuntimeException("Subject not found for id :: "+ id);
		return teacher;
	}

	@Override
	public void deleteTeacherById(long id) {
		this.teacherRepository.deleteById(id);
	}
	
	
}
