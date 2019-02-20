<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src = "./resources/js/jquery-3.3.1.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
	<meta name="google-signin-client_id" content="105485682983-j7e7jmfg959n53m7vuai8mh58ulh9ap0.apps.googleusercontent.com">
   <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">

function onSignIn(googleUser) {
	var profile = googleUser.getBasicProfile();
	console.log('ID: ' + profile.getId());
	console.log('Name: ' + profile.getName());
	console.log('Image URL: ' + profile.getImageUrl());
	console.log('Email: ' + profile.getEmail());

	$('#login1').css('display', 'none');
	$('#logout1').css('display', 'block');
	$('#upic1').attr('src', profile.getImageUrl());
	$('#uname1').html('[ ' +profile.getName() + ' ]');
}

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
    	console.log('User signed out.');
    
    	$('#login1').css('display', 'block');
    	$('#logout1').css('display', 'none');
    	$('#upic1').attr('src', '');
    	$('#uname1').html('');
    });
}

//페북
window.fbAsyncInit = function() {
FB.init({
  appId      : '335267650363269',
  cookie     : true,
  xfbml      : true,
  version    : 'v3.1'
});

FB.getLoginStatus(function(response) {
	console.log(response);
  statusChangeCallback(response);
});
};

// Load the SDK asynchronously
(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = 'https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v3.2&appId=1473607346073633&autoLogAppEvents=1';
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

function statusChangeCallback(response) {
if (response.status === 'connected') {
  getINFO();
} else {
  $('#login2').css('display', 'block');
  $('#logout2').css('display', 'none');
  $('#upic2').attr('src', '');
  $('#uname2').html('');
}
}
  
function fbLogin () {
FB.login(function(response){
  statusChangeCallback(response);
}, {scope: 'public_profile, email'});
}

function fbLogout () {
FB.logout(function(response) {
  statusChangeCallback(response);
});
}

function getINFO() {
FB.api('/me?fields=id,name,picture.width(100).height(100).as(picture_small)', function(response) {
  console.log(response);
  $('#login2').css('display', 'none');
  $('#logout2').css('display', 'block');
  $('#upic2').attr('src', response.picture_small.data.url );
  $('#uname2').html('[ ' + response.name + ' ]');
});
}


//카카오

Kakao.init('2d144bdf664020766a81ed700d77ea7e');
function loginWithKakao() {
// 로그인 창을 띄웁니다.
Kakao.Auth.login({
  success: function(authObj) {
    //alert(JSON.stringify(authObj));
    signIn2(authObj);
  },
  fail: function(err) {
    alert(JSON.stringify(err));
  }
});
};

function signIn2(authObj) {
  //console.log(authObj);
  Kakao.API.request({
      url: '/v2/user/me',
      success: function(res) {
          //console.log(res);
          console.log(res.id);
          $('#login3').css('display', 'none');
         	$('#logout3').css('display', 'block');
          $('#upic3').attr('src', res.properties.thumbnail_image );
         	$('#uname3').html('[ ' + res.properties.nickname + ' ]');
       }
   })
}

function signOut2() {
    Kakao.Auth.logout(function () {
    	$('#login3').css('display', 'block');
    	$('#logout3').css('display', 'none');
    	$('#upic3').attr('src', '');
    	$('#uname3').html('');
    });
}



</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<hr>
<div id="login1" class="g-signin2" data-onsuccess="onSignIn"></div>
<div id="logout1" style="display: none;">
    <input type="button" onclick="signOut();" value="로그아웃" /><br>

    <img id="upic1" src=""><br>
    <span id="uname1"></span>
</div>
	
	<hr>
	
	<div id="fb-root"></div>
	<div class="fb-login-button" data-size="large" data-button-type="login_with" data-auto-logout-link="true" data-use-continue-as="false"></div>


<div id="login2" style="display: block;">
    <input type="button" onclick="fbLogin();" value="로그인" /><br>
</div>

<div id="logout2" style="display: none;">
    <input type="button" onclick="fbLogout();" value="로그아웃" /><br>

    <img id="upic2" src=""><br>
    <span id="uname2"></span>
</div>

<hr>

<div id="login3" style="display: block">
    <a id="custom-login-btn" href="javascript:loginWithKakao()">
    <img src="//mud-kage.kakao.com/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg" width="300"/>
    </a>
</div>

<div id="logout3" style="display: none;">
    <input type="button" class="btn btn-success" onclick="signOut2();" value="로그아웃" /><br>

    <img id="upic3" src=""><br>
   	<span id="uname3"></span>
</div>

<hr>
<input type="button" onclick="location.href='/project/join'" value="메일인증">

</body>
</html>
