<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style></style>
		<script type="text/javascript"></script>
</head>
<body>
<%
	String saveDir = application.getRealPath("/ex0820/");
	int maxSize = 1024*1024*100;
	String encType = "UTF-8";

	MultipartRequest multipartRequest
	= new MultipartRequest(request, saveDir, maxSize, encType, new DefaultFileRenamePolicy());
   
    File file = multipartRequest.getFile("file");
%>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	파일용량 : <fmt:formatNumber value="<%=file.length() %>" groupingUsed="true"/>

</body>
</html>