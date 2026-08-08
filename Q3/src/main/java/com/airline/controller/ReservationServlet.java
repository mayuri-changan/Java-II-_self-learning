package com.airline.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.airline.dao.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/reserve")
public class ReservationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		String pname = request.getParameter("pname");
		String fno = request.getParameter("fno");
		String src = request.getParameter("src");
		String dest = request.getParameter("dest");
		String doj = request.getParameter("doj");

		// Use try-with-resources so connection and statement are closed automatically
		try (Connection conn = DBUtil.getMyConnection();
				PreparedStatement pst = conn.prepareStatement(
						"INSERT INTO ticket(passenger_name, flight_no, source, destination, date_of_journey) VALUES (?,?,?,?,?)")) {

			pst.setString(1, pname);
			pst.setString(2, fno);
			pst.setString(3, src);
			pst.setString(4, dest);
			pst.setString(5, doj);

			int rows = pst.executeUpdate();
			System.out.println("Rows inserted: " + rows);

			response.getWriter().println(
					"Ticket booked successfully for " + pname + " by user " + session.getAttribute("username"));

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Error while booking ticket: " + e.getMessage());
		}
	}
}
