package com.durgasoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hutch")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RedirectServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>THIS IS HUTCH</h1>");
		out.println("<a href='htpp:localhost:8091/app01/welcome.html'> Click Here </a>");
		
	}
	
}
