<%@ page import ="com.study.jsp.login.MemberDto"  %>
<%@ page import ="com.study.jsp.login.MemberDao"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String id = (String)session.getAttribute("id");
	MemberDao dao =MemberDao.getInstance();
	MemberDto dto =dao.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript" src="members.js"></script>
<meta charset="UTF-8">

<!-- Required meta tags -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</head>
<body>
		<form action="modifyOk.go" method= "post" name = "reg_frm">


		<table class="table table-sm">
			<tbody>
				<tr>
					<th scope="row">아이디</th>
					<td><%= dto.getId() %></td>
				</tr>
				<tr>
					<th scope="row">비밀번호</th>
					<td>
					<input type="password" aria-label="First name" class="form-control"	name="pw">
					</td>
				</tr>
				<tr>
					<th scope="row">비밀번호 확인</th>
					<td>
					<input type="password" aria-label="First name" class="form-control"	name="pw_check">
					</td>
				</tr>
				<tr>
					<th scope="row">이름</th>
					<td><%= dto.getName() %></td>
				</tr>
				<tr>
					<th scope="row">메일주소</th>
					<td>
					<input type="text" aria-label="First name" class="form-control"	name="eMail">
					<select class="custom-select" name="eMail2">
						<option selected>주소를 눌러주세요</option>
						<option value="naver.com">네이버</option>
						<option value="daum.net">다음</option>
						<option value="google.com">구글</option>
					</select>
					</td>
				</tr>
				<tr>
					<th scope="row">주소</th>
					<td>
					<input type="text" aria-label="First name" class="form-control"	name="address">
					</td>
				</tr>			
		</tbody>
		</table>
		<button type="button" class="btn btn-outline-primary"
			onclick="updateInfoConfirm()">수정</button>
		<button type="reset" class="btn btn-outline-primary"
			onclick="javascript:window.location='list.do'">취소</button>
	</form>
</body>
</html>