<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript" src="members.js"></script>
</head>
<body>
	<form action="joinOk.do" method= "post" name = "reg_frm">
		아이디 : <input type = "text" name ="id" size = "20"><br>
		비밀번호 : <input type = "password" name ="pw" size = "20"><br>
		비밀번호 확인: <input type = "password" name ="pw_check" size = "20"><br>
		이름 : <input type = "text" name ="name" size = "20"><br>
		메일 : <input type = "text" name ="eMail" size = "20">@
		<select name ="eMail2">
			<option value = "naver.com">네이버</option>
			<option value = "daum.net">다음</option>
			<option value = "google.com">구글</option>
		</select><br>
		주소 : <input type ="text" name = "address" size="50"><br>
		<input type="button" value="회원가입" onclick="infoConfirm()">&nbsp;&nbsp;&nbsp;
		<input type ="reset" value="로그인" onclick = "javascript:window.location='login.jsp'">
	</form>

</body>
</html>