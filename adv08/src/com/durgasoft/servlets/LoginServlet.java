package com.durgasoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");

		out.println("<html>");
		out.println("<body>");
		out.println("<br><br>");
		out.println("<h2 style='color:red;' align='center'>");
		if (uname.equals("durga") && upwd.equals("durga")) {
			out.println(" User Login Success");
		}
		else
		{
			out.println(" User Login Fail");
		}
		out.println("</h2>");
		out.println("<br><br>");
		out.println("<h3 align='center'>");
		out.println("<a href='./loginform.html'> Login Form </a>");
		out.println("</h3>");
		out.println("<body>");
		out.println("<html>");
	}

}
