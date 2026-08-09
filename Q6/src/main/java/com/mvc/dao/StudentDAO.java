package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.controller.DBUtil;
import com.mvc.model.Student;

public class StudentDAO {
	public void addStudent(Student s) {
		try (Connection conn = DBUtil.getMyConnection();
				PreparedStatement pst = conn
						.prepareStatement("INSERT INTO std (name, course, marks) VALUES (?, ?, ?)")) {

			pst.setString(1, s.getName());
			pst.setString(2, s.getCourse());
			pst.setInt(3, s.getMarks());

			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		try (Connection conn = DBUtil.getMyConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM std")) {
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setCourse(rs.getString("course"));
				s.setMarks(rs.getInt("marks"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
