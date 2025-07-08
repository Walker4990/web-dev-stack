<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList" 
 import="vo.Member" 
    %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 전체 회원</h1>
<%-- 임포트할때 그냥 컨트롤 스페이스로 추가 --%>
<% ArrayList<Member> member = (ArrayList<Member>) request.getAttribute("member"); %>
<%--ViewServlet 의 Member값 가져오기 --%>
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

	<%}
} else {%>
<p>회원 정보가 없습니다.</p>
<%} %>
	</table>
</body>
</html>