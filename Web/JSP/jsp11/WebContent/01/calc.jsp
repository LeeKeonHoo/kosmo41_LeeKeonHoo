<%@ page import ="java.io.PrintWriter"%>
<%@ page import = "java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String name1, name2, major;
	int name3, name4;
	int result = 0;
	%>

	<%
	name1 = request.getParameter("name");
	name2 = request.getParameter("name2");
	major = request.getParameter("major");
	
	name3 = Integer.parseInt(name1);
	name4 = Integer.parseInt(name2);
	if(major.equals("더하기")) {
		result = name3+name4;
	}else if(major.equals("빼기")) {				
		result = name3-name4;
	}else if(major.equals("곱하기")) {				
		result = name3*name4;
	}else if(major.equals("나누기")){			
		result = name3/name4;			
	}				
	response.setContentType("text/html; charset=UTF-8");
	%>
	<%
	out.println(name3 + " " + major + " " + name4 + " 는 " + result + "<br>");
	%>
</body>
</html>