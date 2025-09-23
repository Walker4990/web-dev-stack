<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>0922 복습</title>
</head>

<body>
<table border="1">
        <caption>부서목록</caption>
        <tr>
            <th>부서 번호</th>
            <th>부서 이름</th>
            <th>위치</th>
           	<th>비고</th>
           	<th>수정</th>
        </tr>
        
        <c:forEach var="dept" items="${list}">
            <tr>
                <td>${dept.deptno}</td>
                <td>${dept.dname}</td>
                <td>${dept.loc}</td>
                <td><input type="button" value="삭제" onClick="location.href='delete.do?deptno=${dept.deptno}'"  /></td>
                <td><input type="button" value="수정" onClick="location.href='update.do?deptno=${dept.deptno}'"  /></td>
            </tr>
        </c:forEach>
        
        <tr>
            <td colspan="5">
                <input type="button" value="등록" onClick="location.href='dept_form.jsp'">
            </td>
        </tr>
    </table>
</body>
</html>