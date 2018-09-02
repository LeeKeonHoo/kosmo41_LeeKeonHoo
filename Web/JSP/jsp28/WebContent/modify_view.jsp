<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>
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

<script>
	function form_check() {
		document.modify_form.submit();
	}
</script>
</head>
<body>
	<form name="modify_form" action="modify.do" method="post">
		<input type="hidden" name="bId" value="${content_view.bId}">

		<table class="table table-sm">
			<tbody>
				<tr>
					<th scope="row">번호</th>
					<td>${content_view.bId}</td>
				</tr>
				<tr>
					<th scope="row">조회수</th>
					<td>${content_view.bHit}</td>
				</tr>
				<tr>
					<th scope="row">이름</th>
					<td><input type="text" name="bName"
						value="${content_view.bName}"></td>
				</tr>
				<tr>
					<th scope="row">제목</th>
					<td><input type="text" name="bTitle"
						value="${content_view.bTitle}"></td>
				</tr>
				<tr>
					<th scope="row">내용</th>
					<td><textarea rows="10" id="editor1" cols="80" name="bContent">${content_view.bContent}</textarea>
						<script>
							CKEDITOR.replace('editor1');
						</script></td>
				</tr>
				<tr>
					<a class="btn btn-outline-primary" href="javascript:form_check();"
						role="button">수정완료</a>
					<a class="btn btn-outline-secondary"
						href="list.do?page=<%=session.getAttribute("cpage")%>"
						role="button">목록보기</a>
					<a class="btn btn-outline-danger"
						href="content_view.do?bId=${content_view.bId}" role="button">취소</a>

				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>