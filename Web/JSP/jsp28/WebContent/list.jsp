<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<table class="table table-hover table-hover">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">이름</th>
				<th scope="col">제목</th>
				<th scope="col">날짜</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<th scope="row">${dto.bId}</th>
					<td>${dto.bName}</td>
					<td><c:forEach begin="1" end="${dto.bIndent}">-</c:forEach> <a
						href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
					<td>${dto.bDate}</td>
					<td>${dto.bHit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-outline-primary" href="write_view.do" role="button">글작성</a>

          <form class="form-inline mt-2 mt-md-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="bTitle">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" href="search.do">Search</button>
          </form>



	<div class="btn-toolbar" role="toolbar"
		aria-label="Toolbar with button groups">
		<div class="btn-group mr-2" role="group" aria-label="First group">

			<!-- 처음 -->
			<c:choose>
				<c:when test="${(page.curPage -1) < 1}">
					<a class="btn btn-secondary" role="button">[&lt;&lt;]</a>
				</c:when>
				<c:otherwise>
					<a class="btn btn-secondary" href="list.do?page=1" role="button">[&lt;&lt;]</a>
				</c:otherwise>
			</c:choose>

			<!-- 이전 -->
			<c:choose>
				<c:when test="${(page.curPage -1) < 1}">
					<a class="btn btn-secondary" role="button">[&lt;]</a>
				</c:when>
				<c:otherwise>
					<a class="btn btn-secondary" href="list.do?page=${page.curPage -1}"
						role="button">[&lt;]</a>
				</c:otherwise>
			</c:choose>


			<!-- 개별 페이지 -->
			<c:forEach var="fEach" begin="${page.startPage}"
				end="${page.endPage}" step="1">
				<c:choose>
					<c:when test="${page.curPage == fEach}">
						<a class="btn btn-secondary" role="button">${fEach}</a>
					</c:when>
					<c:otherwise>
						<a class="btn btn-secondary" href="list.do?page=${fEach}"
							role="button">${fEach}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<!-- 다음 -->
			<c:choose>
				<c:when test="${(page.curPage + 1) > page.totalPage}">
					<a class="btn btn-secondary" role="button">[&gt;]</a>
				</c:when>
				<c:otherwise>
					<a class="btn btn-secondary"
						href="list.do?page=${page.curPage + 1}" role="button">[&gt;]</a>
				</c:otherwise>
			</c:choose>
			<!-- 끝 -->
			<c:choose>
				<c:when test="${page.curPage == page.totalPage}">
					<a class="btn btn-secondary" role="button">[&gt;&gt;]</a>
				</c:when>
				<c:otherwise>
					<a class="btn btn-secondary" href="list.do?page=${page.totalPage}"
						role="button">[&gt;&gt;]</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<div class="alert alert-success" role="alert">
		<h4 class="alert-heading">카운트 확인</h4>
		<hr>
		totalCount : ${page.totalCount}<br>
		listCount : ${page.listCount}<br>
		totalPage : ${page.totalPage}<br> 
		curPage : ${page.curPage}<br>
		pageCount : ${page.pageCount}<br> 
		startPage : ${page.startPage}<br>
		endPage : ${page.endPage}<br>
	</div>

</body>
</html>