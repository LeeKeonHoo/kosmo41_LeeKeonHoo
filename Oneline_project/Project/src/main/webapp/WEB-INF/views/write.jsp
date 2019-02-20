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
		$(document).ready(function(){
			var check = '${content.event}'
			if(check =="결제대기"){
				check1.checked = true;
				title.disabled = true;
				content.disabled = true;
			}else if(check  =="결제중"){
				check1.checked = true;
				check2.checked = true;
				title.disabled = true;
				content.disabled = true;
			}else if(check =="결제완료"){
				check1.checked = true;
				check2.checked = true;				
				check3.checked = true;
				title.disabled = true;
				content.disabled = true;
			}
			var loginname = '${sessionScope.login.name}';		
			var name = '${content.name}'
			if(name != ''){
				$("#name").val(name);
			}
			
			if(name != loginname && check =="반려"){
				title.disabled = true;
				content.disabled = true;				
			}
		})
	
		//임시저장 버튼
		$("#writeBtn").click(function() {
			var event = $("#event").val()
			if(event =='반려'){
				$("#postevent").val("1");
				$("#write").attr("action","update").attr("method","post").submit();
			}else if(event=='임시저장'){
				$("#write").attr("action","lmsiupdate").attr("method","post").submit();				
			}else{
				$("#postevent").val("1");
				$("#write").attr("action","writeOk").attr("method","post").submit();				
			}
		})
		
		//반려 버튼
		$("#returnBtn").click(function() {
			$("#postevent").val("5");
			$("#write").attr("action","update").attr("method","post").submit();			
		})
		
		//결제 버튼
		$("#okBtn").click(function() {
			var event = $("#event").val();
			var admin = '${sessionScope.admin}';
			if(admin == ''){
				admin = '${sessionScope.login.admin}';	
			}
 			if(event == '' && (admin=="사원" || admin=="대리")){	//글작성 -> 결제대기
				alert("글작성 -> 결제대기");
				$("#postevent").val("2");
				$("#write").attr("action","writeOk").attr("method","post").submit();
			}
 			else if(event == '임시저장'){	//임시저장 -> 결제대기
 				if(admin =="과장"){
 					alert("(과장)임시저장 -> 결제중"); 				
 					$("#postevent").val("3");
 					$("#write").attr("action","update").attr("method","post").submit();
 				}
 				else if(admin =="부장"){
 					alert("(부장)임시저장 -> 결제완료"); 				
 					$("#postevent").val("4");
 					$("#write").attr("action","update").attr("method","post").submit();
 				}	
 				else{
 					alert("임시저장 -> 결제대기");
 					$("#postevent").val("2");
 					$("#write").attr("action","update").attr("method","post").submit();
 				}
			}
 			else if(event == '결제대기' && admin =="과장"){	//결제대기 -> 결제중
				alert("결제대기 -> 결제중");
				$("#postevent").val("3");
				$("#write").attr("action","update").attr("method","post").submit();
			}
 			else if(event == '결제중' && admin =="부장"){	//결제중 -> 결제완료
				alert("결제중 -> 결제완료");
				$("#postevent").val("4");
				$("#write").attr("action","update").attr("method","post").submit();				
			}
 			else if(event == '반려' && admin =="사원"){	//반려 -> 결제대기
				alert("반려 -> 결제대기");
				$("#postevent").val("2");
				$("#write").attr("action","update").attr("method","post").submit();				
			}
 			else if(event == '반려' && admin =="과장"){	//반려 -> 결제중
				alert("반려 -> 결제중");
				$("#postevent").val("3");
				$("#write").attr("action","update").attr("method","post").submit();				
			}
 			else if(event == '반려' && admin =="부장"){	//반려 -> 결제완료
				alert("반려 -> 결제완료");
				$("#postevent").val("4");
				$("#write").attr("action","update").attr("method","post").submit();				
			}
 			else if(admin =="과장" && event==""){	//과장 글작성 -> 결제중
				alert("(과장)글작성 -> 결제중"); 				
				$("#postevent").val("3");
				$("#write").attr("action","writeOk").attr("method","post").submit();
 			}
 			else if(admin =="부장" && event==""){	//부장 글작성 -> 결제완료
				alert("(부장)글작성 -> 결제완료"); 				
				$("#postevent").val("4");
				$("#write").attr("action","writeOk").attr("method","post").submit();
 			}
 			else{					
				alert("권한이 없습니다");
			} 
		})
	})


</script>
</head>
<body>
결제요청 : <input type="checkbox" id="check1" name="check1" disabled>
과장 : <input type="checkbox" id="check2" name="check2" disabled>
부장 : <input type="checkbox" id="check3" name="check3" disabled>

<hr>

<form id="write" name="write">
번호 : <input type="text" id="seq" name="seq" value="${content.seq }${login.seq}"  readonly ><br />
작성자 : <input type="text" id="name" name="name" value="${sessionScope.login.name}"  readonly ><br />
제목 : <input type="text" id="title" name="title" value="${content.title }"><br />
내용 : <br />
	<textarea rows="10" cols= "30" name="content" id="content">${content.content }</textarea><br />

<input type="hidden" id="event" name="event" value="${content.event }">
<input type="hidden" id="postevent" name="postevent" value="1">
<input type="hidden" id="adminname" name="adminname" value="${sessionScope.login.name}">
<input type="hidden" id="admin" name="admin" value="${sessionScope.login.admin}">

</form>
<c:if test="${(sessionScope.admin == '과장' and content.event =='결제대기') or
			 (sessionScope.admin == '부장' and content.event =='결제중') or
			 (sessionScope.login.admin == '과장' and content.event =='결제대기') or
			 (sessionScope.login.admin == '부장' and content.event =='결제중')}">
<input type="button" value="반려" name="returnBtn" id="returnBtn">	
</c:if>
<c:if test="${empty content or  
			 (sessionScope.login.name == content.name and content.event =='임시저장') or
			 (sessionScope.login.name == content.name and content.event =='반려')}">
<input type="button" value="임시저장" name="writeBtn" id="writeBtn">	
</c:if>
<c:if test="${empty content or 
			 (sessionScope.admin == '과장' and content.event =='결제대기') or
			 (sessionScope.admin == '부장' and content.event =='결제중') or
			 (sessionScope.login.admin == '사원' and content.event =='임시저장') or
			 (sessionScope.login.admin == '과장' and content.event =='결제대기') or
			 (sessionScope.login.admin == '부장' and content.event =='결제중') or
			 (sessionScope.login.admin == '과장' and content.event =='임시저장') or
			 (sessionScope.login.admin == '부장' and content.event =='임시저장') or
			 (sessionScope.login.admin == '사원' and content.event =='반려' and sessionScope.login.name == content.name) or
			 (sessionScope.login.admin == '과장' and content.event =='반려' and sessionScope.login.name == content.name) or
			 (sessionScope.login.admin == '부장' and content.event =='반려' and sessionScope.login.name == content.name)}">
<input type="button" value="결제" name="okBtn" id="okBtn">
</c:if>


<hr>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>결제일</td>
				<td>결제자</td>
				<td>결제상태</td>
			<tr>
		</thead>

		<tbody id="list">
			<c:forEach items="${history }" var="dto">
				<tr>
					<td>${dto.HISEQ }</td>
					<td><fmt:formatDate value="${dto.uptDate }"
							pattern="yyyy-MM-dd" /></td>
					<td>${dto.adminName }</td>
					<td>${dto.event }</td>
				<tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>