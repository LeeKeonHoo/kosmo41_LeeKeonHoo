<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
	<script>
		alert("test");
	</script>