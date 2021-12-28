package com.durgasoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="AnnotatedServlet",
			urlPatterns= {"/welcome"},
			loadOnStartup = 1,
			initParams = {  @WebInitParam(name="a",value="SAI KRISHNA"), 
					@WebInitParam(name="b",value="BADINEEDI")}
			)
public class Servlet1 extends HttpServlet {
	
	static {
		System.out.println("Servlet Loading");
	}
	private static final long serialVersionUID = 1L;
    public Servlet1() {
        super();
        System.out.println("Servlet Instatiation");
      
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	System.out.println("Servlet Initialization");
    }
	public void destroy() {
		System.out.println("Servlet Destruction");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ServletConfig config=getServletConfig();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("<html>");
		out.println("Welcome to Annotations in Servlets<br/>");
		out.println("Logical Name:"+config.getServletName()+"<br>");
		out.println("a---->:"+config.getInitParameter("a")+"<br>");
		out.println("b---->:"+config.getInitParameter("b")+"<br>");
		out.println("</h1></body></html>");	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
