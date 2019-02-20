<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "./resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
			var check = '${check}';
			if(check == 'idfail'){
				alert("아이디 실패");
			}
			else if(check == 'pwfail'){
				alert("패스워드 실패");
			}			
		
		
		$("#loginBtn").click(function() {
	         var id = $("#id").val();
	         var pw = $("#pw").val();
	         if(id == ""){
	            alert("아이디를 입력하세요");
	            return;
	         }
	         if(pw == ""){
		        alert("비밀번호를 입력하세요");
		        return;
	         }else{
		          $("#loginFrm").attr("action", "loginChk").attr("method", "post").submit();	        	 
	         }
		})
	})

	


</script>
</head>
<body>
	<form id="loginFrm" name="loginFrm">
	아이디 : <input type="text" id = "id" name="id" placeholder="아이디를 입력하세요"><br />
	
	비밀번호 : <input type="password" id = "pw" name="pw" placeholder="비밀번호를 입력하세요"><br />
	</form>
	<input type="button" id="loginBtn" name="loginBtn" value="login">
	

</body>
</html>