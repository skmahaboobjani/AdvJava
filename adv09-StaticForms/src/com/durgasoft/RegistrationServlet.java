package com.durgasoft;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String[] squal = request.getParameterValues("squal");
		String sgender = request.getParameter("sgender");
		String[] stech = request.getParameterValues("stech");
		String branch = request.getParameter("branch");
		String saddr = request.getParameter("saddr");
		String qual = "";
		for (int i = 0; i < squal.length; i++) {
			qual = qual + squal[i] + "<br>";
		}
		String tech = "";
		for (int j = 0; j < stech.length; j++) {
			tech = tech + stech[j] + "<br>";
		}
		out.println("<html>");
		out.println("<body>");
		out.println("<font color='red'>");
		out.println("<h2>Durga Software Solutions</h2>");
		out.println("<h3>Student Registration Details</h3>");
		out.println("</font>");
		out.println("<table border='1'>");
		out.println("<tr><td>Student Id</td><td>" + sid + "</td></tr>");
		out.println("<tr><td>Student Name</td><td>" + sname + "</td></tr>");
		out.println("<tr><td>Student Qualification</td><td>" + qual + "</td></tr>");
		out.println("<tr><td>Student Gender</td><td>" + sgender + "</td></tr>");
		out.println("<tr><td>Student Technologies</td><td>" + tech + "</td></tr>");
		out.println("<tr><td>Branch</td><td>" + branch + "</td></tr>");
		out.println("<tr><td>Student Address</td><td>" + saddr + "</td></tr>");
		out.println("</table></body></html>");
	}
}
