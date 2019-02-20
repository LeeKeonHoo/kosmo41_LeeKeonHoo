<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:forEach items="${list }" var="dto">
	<tr onclick="location.href='content_view?seq=${dto.seq }'"
			style="cursor: pointer;">
	<td>${dto.seq }</td>
	<td>${dto.name }</td>
	<td>${dto.title}</td>
	<td><fmt:formatDate value="${dto.regDate }" pattern="yyyy-MM-dd" /></td>
	<td><fmt:formatDate value="${dto.uptDate }" pattern="yyyy-MM-dd" /></td>
	<td>${dto.adminName }</td>
	<td>${dto.event }</td>
	</tr>
</c:forEach>