<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 목록</title>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>

</head>
<body>
		<div class="container">
				<h1>상세정보</h1>
				  <p> ${board.title}</p> 
				  <p> ${board.content}</p> 
				 <img src="http://192.168.0.35:8081/${board.url}" width="100px" height="100px">
				    <tr><th>작성일</th><td>${board.formatDate}</td></tr>
				  </table>
		</div>
			<button type="button" id="updateBtn" class="btn btn-dark">수정</button> 
			<button type="button" id="deleteBtn" class="btn btn-dark">삭제</button>
	
			<script>
					
				$("#updateBtn").click(() => {
					const boardNo = "${board.no}";
					location.href = "/update?no=" + boardNo;
				});
				
				$("#deleteBtn").click(() => {
					$.ajax({
						type:"POST",
						url :"/delete",
						data: {no:"${board.no}",
								url : "${board.url}"},
						success: function(){
							alert("삭제완료");
							location.href = "/list";
						},
						error: function(){
							alert("오류발생");
						}
					});
								});
			</script>
</body>
</html>
