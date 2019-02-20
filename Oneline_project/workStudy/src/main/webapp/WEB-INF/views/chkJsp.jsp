<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="/resources/js/jquery-3.2.1.min.js"></script>
	<script>
	$(function(){

	$('#chkAll').click(function(){
	
		var check = $('#chkAll').is(':checked')
	
		
		if(check){
			
			$('input[name=chk]').attr('checked','checked');
			
		}else{
			$('input[name=chk]').attr('checked',false);
		}
		
		sdsad;
	})
	
		
	 $("#btn").click(function(){
		var cnt = $('input[name=chk]:checked').length;
		
		if(cnt<1){
			alert("체크하세요");
		}
		else if(cnt < 5 || cnt==9 ) {
			alert ("성공");
		} else {
			alert("실패");
		}		
		 
	 })
	})
	function fncChkClick(){
		
	}
	
	</script>
</head>
<body>
<form name = "frm">
	<div id = "dvTop">
		<input type = "checkbox" name = "chkAll" id = "chkAll"  >전체
		<input type = "button" id = "btn" value = "버튼">
	</div>
	<div id = "dvChkSection">
		<input type = "checkbox" class="select" name = "chk" id = "chk1" onclick="fncChkClick(this)" value=  "가"><label for = "chk1">가</label>
		<input type = "checkbox" class="select" name = "chk" id = "chk2" onclick="fncChkClick(this)" value=  "나">나
		<input type = "checkbox" class="select"  name = "chk" id = "chk3" onclick="fncChkClick(this)" value=  "다">다
		<input type = "checkbox" class="select" name = "chk" id = "chk4" onclick="fncChkClick(this)" value=  "라">라
		<input type = "checkbox" class="select" name = "chk" id = "chk5" onclick="fncChkClick(this)" value=  "마">마
		<input type = "checkbox" class="select"  name = "chk" id = "chk6" onclick="fncChkClick(this)" value=  "바">바
		<input type = "checkbox" class="select"  name = "chk" id = "chk7" onclick="fncChkClick(this)" value=  "사">사
		<input type = "checkbox" class="select"  name = "chk" id = "chk8" onclick="fncChkClick(this)" value=  "아">아
		<input type = "checkbox" class="select"  name = "chk" id = "chk9" onclick="fncChkClick(this)" value=  "자">자
	</div>
	<div id = "dvCont">
	
	</div>
</form>
</body>
</html>