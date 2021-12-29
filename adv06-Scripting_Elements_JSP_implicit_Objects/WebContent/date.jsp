<%@ page import="java.util.*"%>

<%!Date d = null;
	String date = "";%>
	
<%

d=new Date();
date=d.toString();
%>

<h1 style="color:red;"> Today's Date: <%= date %>  </h1>