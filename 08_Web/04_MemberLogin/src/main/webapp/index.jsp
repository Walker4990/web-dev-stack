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

	<%
	Member login = (Member) session.getAttribute("member");
	%>
	<h1>회원 관리</h1>
	<%
	if (login == null) {
	%>
	<ul>
		<%--로그인 되어 있지 않은 경우 --%>
		<li><a href="/views/register.jsp">회원가입</a></li>
		<%-- 슬래시를 안하면 현재 위치에서 상대경로로 타고 들어감. 
 		-> 	슬래시 안붙이면 view/view/login.jsp로 감
 			why? view 안에서 view/login.jsp를 찾으려고 하기 때문
 			그래서 경로를 찾을땐 앞에 / 를 붙여주는 게 좋음
 	--%>
		<li><a href="/views/login.jsp">로그인</a></li>
		<%
		} else {
		%>
		<%--로그인 된 경우 --%>
		<li><a href="/views/search.jsp">회원 검색</a></li>

		<li><a href="/allMember">전체 회원 보기</a></li>
		<%-- 전체 회원 보기 : AllMemberServlet 
				views/allMember.jsp에 리스트 출력 --%>
		<li><a href="/logout">로그아웃</a></li>
		<%-- 로그아웃 : 로그아웃하고 index.jsp로! LogoutServlet 
		--%>
		<%
		}
		%>
	</ul>
</body>
</html>