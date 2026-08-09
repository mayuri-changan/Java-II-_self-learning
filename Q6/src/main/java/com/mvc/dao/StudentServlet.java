package com.mvc.dao;

import java.io.IOException;
import java.util.List;

import com.mvc.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String course = request.getParameter("course");
		int marks = Integer.parseInt(request.getParameter("marks"));

		Student s = new Student(name, course, marks);
		StudentDAO dao = new StudentDAO();
		dao.addStudent(s);

		response.sendRedirect("success.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		List<Student> students = dao.getAllStudents();
		request.setAttribute("students", students);
		RequestDispatcher rd = request.getRequestDispatcher("viewStudents.jsp");
		rd.forward(request, response);
	}
}