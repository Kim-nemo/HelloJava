<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인화면(signInForm.jsp)</title>
</head>
<body>
	<h3>로그인화면작성하세요..</h3>
	<form action="./signIn.do" method="post">
		ID: <input type="text" name="id"><br>
		PW: <input type="password" name="passwd"><br>
		<input type="submit" value="로그인"><br>
		<input type="reset" value="초기화"><br>
	</form>
	
	<a href="passwdReForm.do">비밀번호 재전송</a> <!-- 보여주는 화면 만드는 곳 -->
	<!-- passwdRe.jsp: 아이디를 입력하고 재전송 : 메일주소로 변경된 비번 
		 passwdRe.do: 아이디를 받아서 이메일정보로 메일을 발송하도록.
	-->
</body>
</html>