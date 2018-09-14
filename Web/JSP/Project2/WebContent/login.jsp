<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("ValidMem") != null){ %>
	<jsp:forward page="list.jsp"></jsp:forward>
<% } %>
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
	
	<!-- ------------------------------------------------ -->
	    <script src="http://code.jquery.com/jquery.js"></script>
    
    <script src="https://apis.google.com/js/platform.js" async defer></script>
	<meta name="google-signin-client_id" content="105485682983-u7954einnd0lb8ersmkfj79v1r0tiqk2.apps.googleusercontent.com">
	<!-- ------------------------------------------------ -->
	

<script language="javascript"> 
//ENTER 안먹게 하는것 
function captureReturnKey(e) { 
    if(e.keyCode==13 && e.srcElement.type != 'textarea') 
    return false; 
} 
 
///////////////////////////아이디 기억하기
$(document).ready(function(){
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var userInputId = getCookie("userInputId");
    $("input[name='id']").val(userInputId); 
     
    if($("input[name='id']").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
        $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
            var userInputId = $("input[name='id']").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("userInputId");
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("input[name='id']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            var userInputId = $("input[name='id']").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }
    });
});
 
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}
/////////////// 구글 로그인
var ggID;
var ggName;
var ggImageURL;
var queryString = "";

function onSignIn(googleUser) {
	
	var profile = googleUser.getBasicProfile();
	console.log('ID: ' + profile.getId());
	console.log('Name: ' + profile.getName());
	console.log('Image URL: ' + profile.getImageUrl());
	
	ggID = profile.getId();
	ggName =profile.getName();
	ggImageURL =profile.getImageUrl();
	queryString = "ggID="+ggID+"&ggName="+ggName+"&ggImageURL="+ggImageURL;
	
	
	$('#login').css('display', 'none');
	$('#logout').css('display', 'block');
	$('#upic').attr('src', profile.getImageUrl());
	$('#uname').html('[ ' +profile.getName() + ' ]');
	
	submit_ajax(); 

	location.replace("list.do");
}
function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
    	console.log('User signed out.');
    
    	$('#login').css('display', 'block');
    	$('#logout').css('display', 'none');
    	$('#upic').attr('src', '');
    	$('#uname').html('');
    });
	submit2_ajax(); 

	location.replace("login.jsp");

}

function submit_ajax() {
      $.ajax({
         url : 'google.go',
         type : 'POST',
         data : queryString,
         dataType : 'json',
         success : function(json) {
            var result = eval(json);
            if (result[0].result == "ok") {
               alert("setOK");
            } else {
               alert(result[0].desc);
            }
         }
      })
   }

function submit2_ajax() {
    $.ajax({
       url : 'googledel.go',
       type : 'POST',
       data : queryString,
       dataType : 'json',
       success : function(json) {
          var result = eval(json);
          if (result[0].result == "ok") {
             alert("setOK");
          } else {
             alert(result[0].desc);
          }
       }
    })
 }


</script>

</head>
 <body class="text-center">
    <form class="form-signin" action = "loginOk.go" method ="post" onkeydown="return captureReturnKey(event)">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="text" id="inputEmail" name="id" class="form-control" placeholder="Email address" required autofocus
      				value="<% if(session.getAttribute("id") != null)
								out.println(session.getAttribute("id"));
								%>">
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword"  name ="pw" class="form-control" placeholder="Password" required><br />
   
     <input type="checkbox" id="idSaveCheck">아이디 기억하기
      
      
      <button class="btn btn-lg btn-primary btn-block" type="button" data-target="#layerpop" data-toggle="modal">Sign in</button>

<div class="modal fade" id="layerpop" >
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- header -->
      <div class="modal-header">
        <!-- header title -->
        <h4 class="modal-title">광고 영상</h4>
      </div>
      <!-- body -->
      <div class="modal-body">
		<iframe width="470" height="300" src="https://www.youtube.com/embed/videoseries?list=PL37pgZBaROlsJugsbuDQysLIgaiACHPDk&autoplay=1&mute=1;rel=0&amp;controls=0&amp;showinfo=0"
  		frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
      </div>
      <!-- Footer -->
      <div class="modal-footer">
        시청해 주셔서 감사합니다
	
        <button type="submit" class="btn btn-default">로그인</button>
      </div>
    </div>
  </div>
</div>


      <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="javascript:window.location='join.jsp'">Sign up</button>
	
		<div id="login" class="g-signin2" data-onsuccess="onSignIn" ></div>
	
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>

 </body>
</html>