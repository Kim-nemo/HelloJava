<%@page import="co.edu.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록(memberList.jsp)</title>
</head>
<body>

	<%
		List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList");
	%>
	<h3>회원정보 리스트보기</h3>
	<% if(list.size() > 0) {%>
		<table border='1'>
			<tr><th>회원아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th></tr>
			<% for (MemberVO vo : list) {%>
				<tr>
					<td><a href="./memberSearchForm.do?id=<%=vo.getId() %>&job=search"><%=vo.getId() %></a></td>
					<td><%=vo.getPasswd() %></td>
					<td><a href="./memberModifyForm.do?name=<%=vo.getName() %>&job=update"><%=vo.getName() %></a></td>
					<td><%=vo.getEmail() %></td>
				</tr>
			<%} %>
		</table>
	<%}else{ %>
		<p>조회된 정보가 없습니다</p>
	<%} %>

</body>
</html>