<%@ page import ="com.study.jsp.BDto"  %>
<%@ page import ="com.study.jsp.BDao"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String id = (String)session.getAttribute("id");
	BDao dao =BDao.getInstance();
	BDto dto =dao.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript" src="members.js"></script>
</head>
<body>
	<form action="main.jsp" method= "post" name = "reg_frm">
		아이디 : <%= dto.getId() %><br>
		비밀번호 : <%= dto.getPw() %><br>
		이름 : <%= dto.getName() %><br>
		메일 : <%= dto.geteMail() %>@<%= dto.geteMail2() %><br>
		주소 : <%= dto.getAddress() %><br>
		
		<input type ="button" value="로그아웃"
				onclick="javascript:window.location='logout.jsp'">&nbsp;&nbsp;&nbsp;
		<input type ="button" value="정보수정"
				onclick="javascript:window.location='modify.jsp'">&nbsp;&nbsp;&nbsp;
		<input type ="button" value="메인화면"
				onclick="javascript:window.location='main.jsp'">
		
	</form>
	
</body>
</html>