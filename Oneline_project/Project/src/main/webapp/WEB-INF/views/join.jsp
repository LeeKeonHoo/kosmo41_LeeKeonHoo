<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="a" action="mailSend" method="post">
<label>업체명</label><input type="text" name="company"><br />
<label>담당자</label><input type="text" name="name"><br />
<label>연락처</label><input type="text" name="number"><br />
<label>이메일</label><input type="text" name="email"><br />
<label>제목</label><input type="text" name="subject"><br />
<label>내용</label><input type="text" name="content"><br />
<input type="button" value="메일발송" onclick="check()">
<input type="hidden" name="to" value="kunhoohei@naver.com"> // 여기에 자신의 이메일 계정
<input type="hidden" name="from" value="kunhoohei@naver.com">// 여기에 자신의 이메일 계정
</form>
<script> 
 function check() {
    document.a.submit();
}
</script>

</body>
</html>