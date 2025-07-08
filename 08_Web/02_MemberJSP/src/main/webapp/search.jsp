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
<%-- SearchServelt 생성, search.jsp에서 결과 확인 --%>


	<%
	Member member = (Member) request.getAttribute("member");
	String id = request.getParameter("id");
	// 서블릿에서 request에 담아두면 jsp에서도 사용이 가능하다.
	if(member != null) {
	%>
	<h2>회원 조회</h2>
		<p>아이디 : <%=member.getId() %></p>
		<p>비밀번호 : <%=member.getPwd() %></p>
		<p>이름 : <%=member.getName() %></p>
		<p>나이 : <%=member.getAge() %></p>
	<%} else {%>
		<h3>아이디가 <%=id %>인 입력하신 아이디의 회원 정보가 없습니다.</h3>
	<%} %>
</body>
</html>