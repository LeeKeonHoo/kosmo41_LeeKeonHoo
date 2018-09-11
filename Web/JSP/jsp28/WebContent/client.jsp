<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<%
	String name = (String) session.getAttribute("name");
	String id =(String) session.getAttribute("id");

	if(id == null){
%>
	<jsp:forward page="login.jsp" />
<%
	} else {
		session.setAttribute("bId", id);
	}
%>
	<div>
		사용자 아이디 : <%= id %>
		<button type ="button" onclick="openSocket();">채팅방 접속</button>
	</div>
	<div>
		<input type ="text" id="messageinput" onkeyup="enterkey()" />
		<button type ="button" onclick="send();">메세지 보내기</button>
	</div>
	<div>
		<button type ="button" onclick="closeSocket();">채팅방 닫기</button>
		<button type ="button" onclick="javascript:window.location='list.do'">메뉴로 돌아가기</button>
	</div>
	<!--  Server responses get written here -->
	<div class="alert alert-success" role="alert">
	<h4 class="alert-heading">채팅방</h4>
	<div id="messages"></div>
	</div>
	
	<!-- Script to utilise the WebSocket -->
	<script type ="text/javascript">
		var webSocket;
		var messages = document.getElementById("messages");
		
		function openSocket(){
			//Ensures only one connection is open at a time
			if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
				writeResponse("[SYSTEM]이미 접속되어 있습니다");
				return;
			}
			
			//Create a new instance of the websocket
			//webSocket = new WebSocket("ws://localhost/ *ProjectName* /echo");
			webSocket = new WebSocket("ws://localhost:8081/jsp28/websocketendpoint2");
			
			/**
			* Binds functions to the listeners for the websocket
			*/
			webSocket.onopen = function(event){
				//For reasons I can't determine, onopen gets calles twice
				//and the first time event.data is undefined
				//Leave a comment if you know the answer
				if(event.data === undefined)
					return;
				
				writeResponse(event.data);
			};
			
			webSocket.onmessage = function(event){
				writeResponse(event.data);
			};
			
			webSocket.onclose = function(event){
				writeResponse("[SYSTEM]채팅방에 나가셨습니다");
			};
		}
		
		/**
		* Sends the value of the text input to the server
		*/
		function send(){
			var id = "<%= id %>";
			var text = document.getElementById("messageinput").value;
			if(id == "admin"){
				webSocket.send("[운영진](" + id + ") : " + text);
			}else{
				webSocket.send("(" + id + ") : " + text);
			}
		}
		
		function closeSocket(){
			webSocket.close();
		}
		
		function writeResponse(text){
			messages.innerHTML += "<br>" + text;
		}
		
	    /** 엔터키를 통해 send함 **/
	    function enterkey() {
	        if (window.event.keyCode == 13) {
	            send();
	        }
	    }

	</script>	
</body>
</html>