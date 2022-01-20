<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.paytm.merchant.CheckSumServiceHelper"%>
<!-- Payment gatway API ko use karega  -->
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%!public class PaytmConstants {
		public final static String MID = "put your mid";
		public final static String MERCHANT_KEY = "put your merchant id";
		public final static String INDUSTRY_TYPE_ID = "Retail";
		public final static String CHANNEL_ID = "WEB";
		public final static String WEBSITE = "WEBSTAGING";
		public final static String PAYTM_URL = "put paytm url";
	}%>

<%
	Enumeration<String> paramNames = request.getParameterNames();

Map<String, String[]> mapData = request.getParameterMap();
TreeMap<String, String> parameters = new TreeMap<String, String>();
String paytmChecksum = "";
while (paramNames.hasMoreElements()) {
	String paramName = (String) paramNames.nextElement();
	if (paramName.equals("CHECKSUMHASH")) {
		paytmChecksum = mapData.get(paramName)[0];
	} else {
		parameters.put(paramName, mapData.get(paramName)[0]);
	}
}
boolean isValideChecksum = false;
String outputHTML = "";
try {
	isValideChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(PaytmConstants.MERCHANT_KEY,
	parameters, paytmChecksum);
	if (isValideChecksum && parameters.containsKey("RESPCODE")) {
		if (parameters.get("RESPCODE").equals("01")) {
	outputHTML = parameters.toString();
	Enumeration aa = request.getParameterNames();
	while (aa.hasMoreElements()) {
		Object a = aa.nextElement();

		// out.println(a);
%>
<h2>Your Payment Has been Done Successfully</h2>

<%
	}

} else {
outputHTML = "<b>Payment Failed.</b>";
Enumeration aa = request.getParameterNames();
while (aa.hasMoreElements()) {
Object a = aa.nextElement();

out.println(a);
}
}
} else {
outputHTML = "<b>Checksum mismatched.</b>";
}
} catch (Exception e) {
outputHTML = e.toString();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<%=outputHTML%>
</body>
</html>
