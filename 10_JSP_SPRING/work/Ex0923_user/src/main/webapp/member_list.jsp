<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="js/httpRequest.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function del(idx){
	if(!confirm('정말로 삭제하시겠습니까?'))
		return;
	
	let url = "member_del.do";
	let param = "idx=" +idx;
	// 특수문자가 포함되어있는 것을 보내려면 encodeURIComponent()로 감싸서 보내면 된다.
	sendRequest(url, param, resDel, "post");
}	

function resDel(){
	if (xhr.readyState == 4 && xhr.status == 200){
		let data = xhr.responseText;
		let json = JSON.parse(data);
		
		if ( json[0].result =='yes' ){
			alert(json[0].idx + '번 회원 삭제 완료')
			location.reload();
		} else {
			alert(json[0].idx + '번 회원 삭제 불가')
		}
	}
}



	</script>
<body>
	
	<table border='1'>
	<caption>:: 회원목록 ::</caption>
		<tr>
			<th>회원번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach var="vo" items="${ list }">
		<tr>
			<td>${ vo.idx }</td>
			<td>${ vo.name }</td>
			<td>${ vo.userid }</td>
			<td>${ vo.pwd }</td>
			<td>${ vo.email }</td>
			<td>${ vo.addr }</td>
			<td><input type='button' value="삭제" onClick="del(${vo.idx})" /></td>
			<td>     <input type="button" value="수정"
             onClick="location.href='select.one?idx=${vo.idx}'" /></td>
		</tr>
		</c:forEach>
		<td colspan="7"><input type='button' value="추가" onClick="location.href='member_register.jsp'" /></td>
	</table>
</body>
</html>