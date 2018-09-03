<%@ page import ="com.study.jsp.MemberDto"  %>
<%@ page import ="com.study.jsp.MemberDao"  %>
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
		<form action="modifyOk.do" method= "post" name = "reg_frm">

		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">아이디</span>
				<div class="alert alert-danger" role="alert">
				 <%= dto.getId() %>
				</div>
			</div>
		</div>

		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">비밀번호</span>
			</div>
			<input type="password" aria-label="First name" class="form-control"
				name="pw">
		</div>

		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">비밀번호 확인</span>
			</div>
			<input type="password" aria-label="First name" class="form-control"
				name="pw_check">
		</div>

		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">이름</span>
				<div class="alert alert-danger" role="alert">
				<%= dto.getName() %>
				</div>
			</div>
		</div>

		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">메일</span>
			</div>
			<span><input type="text" aria-label="First name"
				class="form-control" name="eMail"></span>
		</div>

		<select class="custom-select" name="eMail2">
			<option selected>주소를 눌러주세요</option>
			<option value="naver.com">네이버</option>
			<option value="daum.net">다음</option>
			<option value="google.com">구글</option>
		</select>

		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">주소</span>
			</div>
			<input type="text" aria-label="First name" class="form-control"
				name="address">
		</div>

		<button type="button" class="btn btn-outline-primary"
			onclick="updateInfoConfirm()">수정</button>
		<button type="reset" class="btn btn-outline-primary"
			onclick="javascript:window.location='main.jsp'">취소</button>




	</form>


</body>
</html>