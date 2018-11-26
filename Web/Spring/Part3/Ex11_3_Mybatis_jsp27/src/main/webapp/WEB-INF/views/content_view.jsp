<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>번호</td>
				<td>${dto.bId}</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${dto.bHit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${dto.bName}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${dto.bTitle}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					${dto.bContent}
				</td>
			</tr>
			<tr >
				<td colspan="2">
				<a href="modify_view?bId=${dto.bId}">수정</a> &nbsp;&nbsp;
				<a href="list?page=<%= session.getAttribute("cpage") %>">목록보기</a> &nbsp;&nbsp;
				<a href="delete?bId=${dto.bId}">삭제</a> &nbsp;&nbsp;
				<a href="reply_view?bId=${dto.bId}">답변</a></td>
			</tr>
		</form>
	</table>
</body>
</html>