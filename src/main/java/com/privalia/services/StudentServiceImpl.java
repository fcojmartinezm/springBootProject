package com.privalia.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.privalia.domain.Student;
import com.privalia.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private StudentRepository studentRepository;
	
	@Autowired
	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Override
	public Iterable<Student> listAllStudents() {
		logger.debug("listAllStudents called");
		return studentRepository.findAll();
	}
	
	@Override
	public Student getStudentById(Integer id) {
		logger.debug("getStudentById called");
		return studentRepository.findOne(id);
	}
	
	@Transactional
	public Student saveStudent(Student student) {
		logger.debug("saveStudent called");
		return studentRepository.save(student);
	}
	
	@Transactional
	public void deleteStudent(Integer id) {
		logger.debug("deleteStudent called");
		studentRepository.delete(id);
	}

	@Override
	public Student getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student saveOrUpdate(Student student) {
		// TODO Auto-generated method stub
		return null;
	}
}
