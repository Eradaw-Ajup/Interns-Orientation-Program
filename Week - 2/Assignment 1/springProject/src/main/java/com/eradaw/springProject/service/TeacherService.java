package com.eradaw.springProject.service;

import java.util.List;

import com.eradaw.springProject.model.Teacher;

public interface TeacherService  {
	List<Teacher> getAllTeachers();
	void saveTeacher(Teacher teacher);
    Teacher getTeacherById(long id);
    void deleteTeacherById(long id);
}
