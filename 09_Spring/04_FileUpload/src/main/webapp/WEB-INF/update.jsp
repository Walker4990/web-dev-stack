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
				<input type="hidden" name="no" value="${board.no}" readonly /><br>
					  <div class="form-group">
						<label>Title</label>
						<input class="form-control" name="title" value="${board.title}">
						</div>
						<div class="form-group">
							<label>Content</label>
							<textarea class="form-control" name="content" >
								${board.content}
								</textarea>
						</div>
						<img src="http://192.168.0.35:8081/${board.url}" width="100px" height="100px">
						<div class="form-group">
							<label>Update File</label>
							<input class="form-control" name="file" type="file" accept="image/*"  />
							
						</div>
						<!--수정 시 file이 있다면 기존 파일은 삭제하고 새로 추가된 파일로 업로드
							파일 삭제 : File 객체의 delete() 메서드 사용
						-->
						
				        <button id="update" type="submit" class="btn btn-dark">수정</button>
						<button id="cancel" type="button" class="btn btn-dark">취소</button>
						</form>
</body>
</html>