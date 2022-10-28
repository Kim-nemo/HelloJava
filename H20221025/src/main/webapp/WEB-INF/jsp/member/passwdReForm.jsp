<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
	<h3>비밀번호 재전송</h3>
	<form action="./passwdRe.do" method="post">
		ID: <input type="text" name="id"><br>
		
		<input type="submit" value="이메일 발송"><br>
		<input type="reset" value="초기화"><br>
	</form>
</body>
</html>