<%@ page import="java.time.LocalTime"%>
<%!
LocalTime lt=null;
String wish_message="";
%>

<% 
	lt=LocalTime.now();
	wish_message="Good Morning!!!!!";
	if(lt.getHour()>=12)
	{
		wish_message="Good After Noon!!!!!!!";
	}
	else if(lt.getHour()>=17)
	{
		wish_message="Good Evening !!!!!";
	}	
%>

<h1 style="color:red;"> Hello User, <%= wish_message %> </h1>