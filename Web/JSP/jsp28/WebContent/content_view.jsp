<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">

    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<script type ="text/javascript">
		function goBack(){
			window.history.back();
		}
		function onDownload(bId) {
			var o = document.getElementById("ifrm_filedown");	
			o.src = "download.do?bId="+bId;
		}
		function button_event(bId){
			if (confirm("정말 삭제하시겠습니까??") == true){    //확인
				alert("삭제되었습니다");
				location.replace("delete.do?bId="+bId);
			}else{   //취소
			    return;
			}		
			}
		
	</script>
	
	
	
	<%
	String name = (String) session.getAttribute("name");
	String id = (String) session.getAttribute("id");
	%>
</head>
<body>
<iframe id="ifrm_filedown"  style="position:absolute; z-index:1;visibility : hidden;"></iframe> 

<table class="table table-sm">
  <tbody>
    <tr>
      <th scope="row" name="bId">번호</th>
      <td>${content_view.bId}</td>
    </tr>
    <tr>
      <th scope="row">조회수</th>
      <td>${content_view.bHit}</td>
    </tr>
    <tr>
      <th scope="row">종류</th>
      <td>${content_view.food}</td>
    </tr>
    <tr>
      <th scope="row">지역</th>
      <td>${content_view.sido}</td>
    </tr>
    <tr>
      <th scope="row">시군구</th>
      <td>${content_view.gigungu}</td>
    </tr>
    <tr>
      <th scope="row">리뷰인원</th>
      <td>${content_view.manscore}</td>
    </tr>
    <tr>
      <th scope="row">평점</th>
      <td>${content_view.avgscore}</td>
    </tr>
    <tr>
      <th scope="row">이름</th>
      <td>${content_view.bName}</td>
    </tr>
    <tr>
      <th scope="row">제목</th>
      <td>${content_view.bTitle}</td>
    </tr>
    <tr>
      <th scope="row">내용</th>
      <td>${content_view.bContent}</td>
    </tr>
	<tr>
      <th scope="row">업로드 파일</th>
		<td>
		<a href="#" onclick="onDownload('${content_view.bId}')">${content_view.upload}</a>
		<% if(session.getAttribute("id2").equals("list.do")) { %>
		<% if(session.getAttribute("check3").equals("yes")){ %>
		<img src = "<%= request.getContextPath() %>/upload/${content_view.upload}"  width="100" height="100">
		<% }} %>
		</td>
	</tr>
	<tr>
      <th scope="row">당신의 점수가 개발에 큰 도움이 됩니다</th>
		<td>
		<form action ="review.do" method="post">
		<input type = "hidden" name = "bId" value="${content_view.bId}">
			<select class="custom-select" name="sumscore">
				<option selected value="1">1점</option>
				<option value="2">2점</option>
				<option value="3">3점</option>
				<option value="4">4점</option>
				<option value="5">5점</option>
			</select>
  		<button class="btn btn-outline-info" role="submit" >평점주기</button>
		</form>
		</td> 
	</tr>
 

</table>
<% if(session.getAttribute("id2").equals("list.do")) { %>
<% if(session.getAttribute("check").equals("yes")) { %>
	<a class="btn btn-outline-primary" href="modify_view.do?bId=${content_view.bId}" role="button">수정</a>
	<a class="btn btn-outline-danger" role="button" onclick="button_event('${content_view.bId}');">삭제</a>
<% }} %>
	<a class="btn btn-outline-secondary" href="list.do?page=<%= session.getAttribute("cpage") %>" role="button">목록보기</a>
	<a class="btn btn-outline-success" href="reply_view.do?bId=${content_view.bId}" role="button">답변</a>
	<a class="btn btn-outline-info" href="javascript:history.back()" role="button" >뒤로가기</a>

<% if(session.getAttribute("id2").equals("list.do")) { %>
<% if(session.getAttribute("check2").equals("yes")) { %>
   	<a class="btn btn-outline-primary" href="star.do?bId=${content_view.bId}" role="button" ><img src="<%= request.getContextPath() %>/image/star1.jpg" width="80"></a>
<% }} %>
<% if(session.getAttribute("id2").equals("list.do")) { %>
<% if(session.getAttribute("check2").equals("no")) { %>
	<a class="btn btn-outline-primary" href="stardel.do?bId=${content_view.bId}" role="button" ><img src="<%= request.getContextPath() %>/image/star2.jpg" width="80"></a>
<% }} %>

</body>
</html>