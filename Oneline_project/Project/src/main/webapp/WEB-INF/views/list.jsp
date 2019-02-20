<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"
	type="text/css">
<script src = "./resources/js/jquery-3.3.1.min.js"></script>
<script src="./resources/js/jquery-ui.js"></script>
<script>
	$(function() {
		$(document).ready(function(){
			var login = '${login}'
			if(login == ''){
				alert("로그인 정보가 없습니다");
				location.href="/project/login";
			}
		})
		
		//날짜
		$("#startdate").datepicker({
			dateFormat : 'yy-mm-dd'
			});
		$("#enddate").datepicker({
			dateFormat : 'yy-mm-dd'
			});
		
		//검색 버튼
		$("#searchBtn").click(function() {
			$("#searchFrm").attr("action","list").attr("method","post").submit();			
		})
		
		//결제상태 Ajax
		$("#status").change(function() {
			var sessionName = '${sessionScope.login.name}'
			var sessionAdmin = '${sessionScope.login.admin}'
			var ADMIN = '${sessionScope.admin}'
			var ADMINNAME = '${sessionScope.adminname}'
			$.ajax({
				type : "get",
				url : "/project/status",
				data: { "status" : $("#status").val(),
					"sessionName" : sessionName,
					"sessionAdmin" : sessionAdmin,
					"ADMIN" : ADMIN,
					"ADMINNAME" : ADMINNAME},
				success : function(data) {
					$("#list").html(data);
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
	})

	function popupOpen(){
	var popUrl = "/project/popup?kwanhan=${sessionScope.login.admin}";	//팝업창에 출력될 페이지 URL
	
	var popupX = (window.screen.width / 2) - (200 / 2);
	var popupY= (window.screen.height /2) - (300 / 2);
	
	var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no, toolbar=no, location=no" +
				",left=" + popupX + ", top=" + popupY + ", screenX=" + popupX + ", screenY= " + popupY;    //팝업창 옵션(optoin)
		window.open(popUrl,"",popOption);

	}
	

	var timer; // 타이머셋팅을 위한 변수 설정
	function onOver(trId) {
	    timer = setInterval(function(){changergb(trId)}, 100);
	                      // 0.175초마다 changergb 함수가 호출된다.
	}
	function onOut(trId) {
	  var text = document.getElementById(trId); 
	  clearInterval(timer); // 타이머 멈추기
		text.style.color = "rgb(0,0,0)";
	  // 마우스를 벗어나면 색깔 원래대로 바꾸기   
	} 
	
	
   function changergb(trId){
	    var text = document.getElementById(trId); 
	    // 이벤트가 발생한 id가 "test1"인 객체를 찾아서 text변수에 넣는다. 
	    var r = Math.round(Math.random() * 255); 
	    var g = Math.round(Math.random() * 255);
	    var b = Math.round(Math.random() * 255);
	    // 0~255값을 랜덤으로 뽑아내서 각각의 변수 r,g,b 에 들어간다.
		 
	    var random_color = "rgb(" + r + "," + g + "," + b + ")";
	    // random_color = rgb(r,g,b)
	 
	    text.style.color = random_color; 
	    // text(test1)에 색상을 바꿉니다.
    }     
	
	
</script>
</head>
<body>
${sessionScope.login.name}(${sessionScope.login.admin}) 님 환영합니다.
<c:if test="${!empty kwanhan }">
	<c:forEach items="${kwanhan }" var="kwanhan">
		<br />
		권한자 : ${kwanhan.ADMINNAME}(${kwanhan.ADMIN})<br />
		기한 : <fmt:formatDate value="${kwanhan.REGDATE}"
							pattern="yyyy-MM-dd" />
	</c:forEach>
</c:if>
<input type ="button" value="로그아웃" onclick="location.href='/project/logout'">

<hr>
<button onclick="location.href='/project/write'">글작성</button>
<c:if test="${sessionScope.login.admin == '과장' or sessionScope.login.admin == '부장'}">
<button onclick="location.href='javascript:popupOpen();'">대리결제</button>
</c:if>
<br />
	<form id="searchFrm" name="searchFrm">
	<select name="option" id = "option">
		<option value='0' selected>-선택-</option>
		<option value='1'>작성자</option>
		<option value='2'>제목</option>
		<option value='3'>결제자</option>
	</select>
	<input type="text" id = "search" name="search" placeholder="검색어를 입력하세요" value="${searchmap.search}">
	<select name="status" id = "status">
		<option value='0' selected>-결제상태-</option>
		<option value='1'>임시저장</option>
		<option value='2'>결제대기</option>
		<option value='3'>결제중</option>
		<option value='4'>결제완료</option>
		<option value='5'>반려</option>
	</select>
	<br />
	<input type="text" id="startdate" name="startdate" autocomplete="off" value="${searchmap.startdate}">~
	<input type="text" id="enddate" name="enddate" autocomplete="off" value="${searchmap.enddate}">
	</form>
	<button id="searchBtn" name="searchBtn">검색</button>

	<hr>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
				<td>결제일</td>
				<td>결제자</td>
				<td>결제상태</td>
			<tr>
		</thead>

		<tbody id="list" background="https://pbs.twimg.com/profile_images/866355633896833024/A0i-azlT_400x400.jpg">
			<c:forEach items="${list }" var="dto">
				<tr onclick="location.href='content_view?seq=${dto.seq }'"
							style="cursor: pointer;" id="tr${dto.seq }" onmouseover="onOver('tr${dto.seq}');" onmouseout="onOut('tr${dto.seq}');">
					<td>${dto.seq }</td>
					<td>${dto.name }</td>
					<td>${fn:substring(dto.title,0,6)}</td>
					<td><fmt:formatDate value="${dto.regDate }"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${dto.uptDate }"
							pattern="yyyy-MM-dd" /></td>
					<td>${dto.adminName }</td>
					<td>${dto.event }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>