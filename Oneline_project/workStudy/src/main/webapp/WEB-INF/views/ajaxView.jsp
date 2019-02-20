<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src = "/resources/js/jquery-3.2.1.min.js"></script>
<script>
asdnf
adklfna
flka
askndf
asfdlkasndf
adsflknasldfnalksnf
$(function(){
	$("#btn").click(function(){
		$.ajax({
			data:{"txt":$("#txt").val()},
	        url:'ajax.do',
	        type:'post',
	        success:function(data){
	        	alert(data);
	        	$("#dv").text(data);
	        },
	        error:function(data){
	        	alert("오류");
	        },a slfnalk
	        alk;nsfa
	        alknfa
	        alknfklanfa
	        lskdnflkasnf
	        
	    });
	});
	
	$("#btn1").click(function(){
		$.ajax({
			data:{"txt":$("#txt").val()},
	        url:'ajax1.do',
	        type:'post',
	        success:function(data){
	        	alert(data);
	        	$("#dvTable").html(data);
	        },
	        error:function(data){
	        	alert("오류");
	        }
	        
	    });
	});
})
</script>
</head>
<body>

	<input type= "button" name = "btn" id = "btn" value= "버튼">
	<input type= "button" name = "btn1" id = "btn1" value= "버튼1">
	
	<input type = "text" name = "txt" id = "txt" value = "">
	
	<div id = "dv">
		
	</div>
	<div id = "dvTable">
		<table border="1" bordercolor="black">
			<tr>
				<td>1</td>
				<td>2</td>
				<td>3</td>
			</tr>
		</table>
	</div>
</body>
</html>