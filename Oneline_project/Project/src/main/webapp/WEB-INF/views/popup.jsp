<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "./resources/js/jquery-3.3.1.min.js"></script>
<script>
	$(function() {
		//직급 ajax
		$("#option").change(function() {
			$.ajax({
				type : "get",
				url : "/project/popupajax",
				data: { "option" : $("#option").val() },
				success : function(data) {
					$("#test").html(data);
				},
				error : function(request, status, error) {
					//alert(params);
					alert("code : " + request.status + "\n"
						+ "message : "
						+ request.responseText + "\n"
						+ "error:" + error);
				}
			})
		})

		
		//승인 버튼
		$("#popupBtn").click(function() {
			if($("#option").val() == '-선택-'){
				alert("선택점");
			}
			else{
			$.ajax({
				type : "get",
				url : "/project/popupok",
				data: $("#popupFrm").serialize(),
				success : function(data) {
					alert("권한부여 성공");
					window.close();
				},
				error : function(request, status, error) {
					alert("code : " + request.status + "\n"
						+ "message : "
						+ request.responseText + "\n"
						+ "error:" + error);
				}
			})		
			}
		})
	})
</script>
</head>
<body>
<form id="popupFrm" name="popupFrm">
대리결제자 : 	<select name="option" id = "option">
				<option selected>-선택-</option>
			 <c:forEach var="popup" items="${popup}" varStatus="i">
         		<option value="${popup.name}">${popup.name}</option>
     		 </c:forEach>
			</select><br />
<input type="hidden" id="name" name="name" value="${sessionScope.login.name}">
<input type="hidden" id="class" name="class" value="${sessionScope.login.admin}">
</form>
<div id="test">
직급 : <input type="text" id="admin" name="admin" readonly><br />
</div>
대리자 : <input type="text" id="daerija" name="daerija" value="${sessionScope.login.name}(${sessionScope.login.admin})" readonly><br />
<input type="button" onclick="location.href='javascript:self.close()'" value="취소">
<button id="popupBtn" name="popupBtn">승인</button>

</body>
</html>