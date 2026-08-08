package com.demo.model;

public class Student {
	private int id;
	private String name;
	private String email;

	/*
	 * CREATE TABLE student (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), email VARCHAR(100)); 
	 * INSERT INTO student(name,email) VALUES('Kg','kg@test.com');
	 */

	public Student() {
	}

	public Student(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
