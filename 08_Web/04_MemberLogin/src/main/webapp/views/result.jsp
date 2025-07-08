<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--views/result.jsp에서
						성공하면 해당 정보 출력
						실패하면 "검색에 실패했습니다." --%>
	<% 
	boolean check = (boolean) request.getAttribute("check");
	Member member = (Member) request.getAttribute("member");
	
	if(check && member != null) {
	%>
	<h1>아이디 : <%=member.getId() %></h1>
	<h1>비밀번호 : <%=member.getPwd() %></h1>
	<h1>이름 : <%=member.getName() %></h1>
	<h1>나이 : <%=member.getAge() %></h1>
	<%} else{ %>
	<h2>검색에 실패했습니다.</h2>
	<%} %>
</body>
</html>