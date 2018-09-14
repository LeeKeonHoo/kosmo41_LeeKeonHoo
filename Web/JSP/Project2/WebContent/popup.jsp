<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>팝업 창</title>

<script>
	function setCookie(name, value, expiredays){
		var todayDate = new Date();
	    todayDate = new Date(parseInt(todayDate.getTime() / 86400000) * 86400000 + 54000000);  
	    if ( todayDate > new Date() )  
	    { 
	    expiredays = expiredays - 1;
	    }	//하루가 지나면 팝업창 띄움
		document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
	}

	function closePop(){
		setCookie("close","close",1);
		window.close();
	}
</script>




</head>
<body>

	<img src="../Project2/image/baemin.png" width="100%" height="100%" border="0">
	<input type="checkbox" onClick="closePop();">오늘 하루 동안 열지 않음
	<td style="font-size:11px;"><a href="javascript:self.close();" onfocus="this.blur()">[닫기]</a></td>

</body>
</html>