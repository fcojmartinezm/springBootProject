package com.privalia.services;

import com.privalia.domain.Student;

public interface StudentService {
	Iterable<Student> listAllStudents();
	
	Student getById(Integer id);
	
	Student saveOrUpdate(Student student);
	
	void deleteStudent(Integer id);

	Student getStudentById(Integer id);

	Student saveStudent(Student student);
}
