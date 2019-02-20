<%@page import="com.study.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src = "/resources/js/jquery-3.2.1.min.js"></script>
<script>

function fncWrite(){
	location.href = "writeView";
	
}
$(function(){
	alert("아조씨들 힘내세요");
	$("#searchBtn").click(function(){
		$.ajax({
			data:$("#searchFrm").serialize(),
	        url:'ajaxBoard.do',
	        type:'post',
	        success:function(data){
	        	$("#listData").html(data);
	        },
	        error:function(data){
	        	alert("오류");
	        }
	    });
	})
	
})
</script>
</head>
<body>
<form id="searchFrm">	
		<select name="searchKeyword">
			<option value="all">전체</option>
			<option value="subject">제목</option>
			<option value="subcon">제목+내용</option>
			<option value="name">작성자</option>
		</select>
		<input type="text" name="search">
		<input type="button" id="searchBtn" value="검색">
</form>
<form name = "listfrm">
	<input type = "button" name = "btn" id = "btn" value = "글쓰기" onclick="fncWrite()">
	
	
	<table border="1px" bordercolor="black">
		<thead>
		<tr>
			<th>글번호</th>	
			<th>작성자(ID)</th>
			<th>제목</th>
			<th>내용</th>
			<th>결제자</th>
			<th>등록일</th>
			<th>수정일</th>
			<th>조회수</th>
			<th>번호</th>
		</tr>
		</thead>
		<tbody id = "listData">
			<c:forEach items="${boardlist}" var="board" varStatus="num">	
				<tr>
					<td>${board.seq }</td>	
					<td>${board.memName}(${board.memId})</td>
					<td><a href = "detail?seq=${board.seq}">${board.boardSubject }</a></td>
					<td>${board.boardContent }</td>
					<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/> </td>
					<td><fmt:formatDate value="${board.uptDate }" pattern="yyyy-MM-dd"/></td>
					<td>${board.viewCnt }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>
</body>
</html>