<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src = "/resources/js/jquery-3.2.1.min.js"></script>
<script>
	$(function(){
		$("#wrBtn").click(function(){
			$("#frm").attr("action","write");
			$("#frm").attr("method","post");
			$("#frm").submit();
		})
		
		$("#upBtn").click(function(){
			$("#frm").attr("action","update");
			$("#frm").attr("method","post");
			$("#frm").submit();
		})
		
	})
</script>
</head>
<body>
<form name = "frm" id = "frm">
	작성자 : <input type = "text" name = "MEM_NAME" value="${list.MEM_NAME }" ><br>
	id : <input type = "text" name = "MEM_ID" value="${list.MEM_ID }"><br>
	제목 : <input type = "text" name = "BOARD_SUBJECT" value="${list.BOARD_SUBJECT }" ><br>
	내용 : <br><textarea rows="5" cols="25" name = "BOARD_CONTENT" >${list.BOARD_CONTENT }</textarea>
	<br>
	<c:set var="name" value="${list.MEM_NAME }"></c:set>	
		<c:if test="${empty name}">
		<input type = "button" name = "wtBtn" id = "wrBtn" value = "등록">
		</c:if>
		
		<c:if test="${not empty name}">
		<input type = "button" name = "upBtn" id = "upBtn" value = "수정">
		</c:if>
		<input type="hidden" name="SEQ" value="${list.SEQ}">
	
</form>	
</body>
</html>