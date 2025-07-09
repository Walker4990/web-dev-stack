<%@page import="vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 회원 조회</h1>
	<%
	List<Member> member = (List<Member>) request.getAttribute("member");
	%>
	<table border = "1">
	<tr>
		<th>아이디 </th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>나이</th>
	</tr>

<%if (member !=null) { %>
<%for(Member m : member) {%>
<tr>
	<td><%=m.getId() %></td>
	<td><%=m.getPwd() %></td>
	<td><%=m.getName() %></td>
	<td><%=m.getAge() %></td>
</tr>
<%}%>

<%} else {%>
<a href="/">메인 페이지로 이동</a>
<%} %>
</table>
<a href="/">메인 페이지로 이동</a>
</body>
</html>