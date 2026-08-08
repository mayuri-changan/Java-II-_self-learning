package com.demo.service;

import java.util.List;

import com.demo.dao.StudentDao;
import com.demo.dao.StudentDaoImpl;
import com.demo.model.Student;

public class StudentServiceImpl implements StudentService {
	private StudentDao sdao;

	public StudentServiceImpl() {
		this.sdao = new StudentDaoImpl();
	}

	@Override
	public boolean addNewStudent(Student s) {
		return sdao.saveStudent(s);
	}

	@Override
	public List<Student> getAll() {
		return sdao.findAll();
	}

	@Override
	public Student getById(int id) {
		return sdao.findById(id);
	}

	@Override
	public boolean updateStudent(Student s) {
		return sdao.updateStudent(s);
	}

	@Override
	public boolean deleteStudent(int id) {
		return sdao.deleteStudent(id);
	}

	@Override
	public void closeMyConnection() {
		sdao.closeMyConnection();
	}
}
