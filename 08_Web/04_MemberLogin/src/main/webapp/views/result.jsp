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
	<h1>회원 정보</h1>
	<% 
	boolean check = (boolean) request.getAttribute("check");
	Member member = (Member) request.getAttribute("member");
	
	if(check && member != null) {
	%>
	<h3>아이디 : <%=member.getId() %></h3>
	<h3>비밀번호 : <%=member.getPwd() %></h3>
	<h3>이름 : <%=member.getName() %></h3>
	<h3>나이 : <%=member.getAge() %></h3>
	<a href="/">메인 페이지로 이동</a>
	<%} else{ %>
	<h2>검색에 실패했습니다.</h2>
	<a href="/">메인 페이지로 이동</a>
	<%} %>
</body>
</html>