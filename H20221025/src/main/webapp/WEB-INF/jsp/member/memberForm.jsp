<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h3>회원 가입</h3>
	<form action="./signUp.do" method="post">
		ID: <input type="text" name="id"><br>
		PW: <input type="password" name="passwd"><br>
		NAME: <input type="text" name="name"><br>
		EMAIL: <input type="email" name="email"><br>
		<input type="submit" value="등록"><br>
		<input type="reset" value="초기화"><br>
	</form>
</body>
</html>