package com.demo.dao;

import java.util.List;

import com.demo.model.Student;

public interface StudentDao {
	boolean saveStudent(Student s);

	List<Student> findAll();

	Student findById(int id);

	boolean updateStudent(Student s);

	boolean deleteStudent(int id);

	void closeMyConnection();
}
