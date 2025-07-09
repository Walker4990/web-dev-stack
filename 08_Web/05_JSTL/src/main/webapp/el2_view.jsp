<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>1. 기존 방식</h1>
	<%
		String id = request.getParameter("id");
		String[] hobby = request.getParameterValues("hobby");
		%>
		<ul>
			<li>아이디 : <%= id %></li>
			<% for(String h : hobby) {%>
			<li>취미 : <%=h %></li>
			<%} %>
		</ul>

	<h1>2. EL</h1>
	<ul>
		<li>아이디 : ${param.id}</li>
		<li>취미 : ${paramValues.hobby[0]}</li>
		<%-- EL로 배열을 대체하긴 어렵다. --%>
	</ul>
	
</body>
</html>