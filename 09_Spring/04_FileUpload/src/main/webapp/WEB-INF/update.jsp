<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 목록</title>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<!--
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
	-->
</head>
<body>

<h1>상세정보</h1>
		
			
				<form action="/update" method="post" enctype="multipart/form-data">
				번호: <input type="text" value="${board.boardNo}" readonly /><br>
					  <input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo}"  />
				      제목 : <input type="text" id="title" name="title" value="${board.title}"></br> 
				      내용 : <input type="text"id="content" name="content" value="${board.content}"></br>
				      파일 : <input type="file" id="file" name="file"></br>
				작성일 : <input type="date" id=
				        <button id="update" type="submit">수정</button>
						<button id="cancel" type="button">취소</button>
				</form>
			  </table>
</body>
</html>