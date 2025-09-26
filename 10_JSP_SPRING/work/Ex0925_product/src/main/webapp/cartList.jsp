<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="index.jsp"/>
		
		<table align="center" width="600" border="1">
			<tr bgcolor="#dedede">
				<th width= "20%">제품코드</th>
				<th width="20%">이미지 </th>
				<th width="30%">제품명</th>
				<th width="30%">단가</th>
				<th width="10%">수량</th>
				<th colspan="2" width="30%" >금액</th>
				
			</tr>
			<c:forEach var="list" items="${ list }">
			<tr align="center">
				<td>${ list.p_num }</td>
				<td><img src="images/${ list.p_image_s }"width="50" /></td>
				<td>${list.p_name }</td>
				<td>단가: <fmt:formatNumber value="${ list.p_price }"></fmt:formatNumber>원 <br>
				<font color="red">
					세일 가격 : <b><fmt:formatNumber value="${ list.p_saleprice }"></fmt:formatNumber>원</b>
				</font>
				
				</td>
				<td>
					<form>
						<input type="hidden"/>
						<input type="text" value="${ list.c_cnt }" size="3" /><br>
						<input type="submit" value="수정" />
					</form>
				</td>
				<td><fmt:formatNumber value="${ list.amount }"></fmt:formatNumber>원</td>
				<td>
					<input type="button" value="삭제" />
				</td>
			</tr>
				</c:forEach>
			<tr>
				<td colspan="6" align="right">
					총 결제금액 &nbsp;
				</td>
				
				<td align="center" ><fmt:formatNumber value="${ total }"></fmt:formatNumber>원</td>
			</tr>
		
		</table>
	</body>
</html>