package com.demo.service;

import java.util.List;

import com.demo.model.Student;

public interface StudentService {
	boolean addNewStudent(Student s);

	List<Student> getAll();

	Student getById(int id);

	boolean updateStudent(Student s);

	boolean deleteStudent(int id);

	void closeMyConnection();
}
