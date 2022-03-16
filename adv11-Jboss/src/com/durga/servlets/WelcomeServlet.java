package com.durga.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws 	ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1> Welcome to Wildfly Server</h1>");
	}
}
