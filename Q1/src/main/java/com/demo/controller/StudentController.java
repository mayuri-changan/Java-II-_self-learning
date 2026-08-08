package com.demo.controller;

import java.io.IOException;

import com.demo.model.Student;
import com.demo.service.StudentService;
import com.demo.service.StudentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentController extends HttpServlet {
	private StudentService service = new StudentServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("create".equals(action)) {
			Student s = new Student(0, request.getParameter("name"), request.getParameter("email"));
			service.addNewStudent(s);
		} else if ("update".equals(action)) {
			Student s = new Student(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),
					request.getParameter("email"));
			service.updateStudent(s);
		} else if ("delete".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			service.deleteStudent(id);
		}
		response.sendRedirect("studentList.jsp");
	}
}
