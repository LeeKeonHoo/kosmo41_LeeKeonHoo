<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String id, pw,name;
	%>
	<%
	request.setCharacterEncoding("UTF-8");

		id= request.getParameter("id");
		pw= request.getParameter("pw");
		name= request.getParameter("name");
		
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		session.setAttribute("name", name);

		if(id.equals("asdf") && pw.equals("1234")){
			response.sendRedirect("welcome.jsp");
		}else{
			response.sendRedirect("login.html");		
		}
	%>
	
	<!-- 
		session.setMamInactiveInterval(60*60);
	 -->
</body>
</html>