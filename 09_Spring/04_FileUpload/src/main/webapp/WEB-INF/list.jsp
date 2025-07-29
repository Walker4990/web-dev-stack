<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<h1>List Page</h1>
			<thead>
				
				  <table class="vertical-table mb-4">
					
				    <tr>
				      <th>번호</th>
					  <th>제목</th>
					  <th>작성시간</th>
				    </tr>
					</thead>
					<tbody>
					<c:forEach var="b" items="${list}">
						<!-- view.jsp 
						경로는 /view?no=1 상세페이지로 이동
						 타이틀만 클릭했을 때 상세정보출력
						-->
					<tr>
					  <td>${b.no}</td>
				      <td><a href="/view?no=${b.no}">${b.title}</a></td>
					  <!-- fmt: formatDate : 날짜형식을 마음대로 바꿀수 있는 JSTL-->
					  <td><fmt:formatDate value="${b.formatDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    </tr>
					</c:forEach>
				  </table>
				
			</tbody>
					
		</table>
		<button type="button" class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#writeModal">글 추가</button>
		<!-- Button trigger modal -->

		<!-- Modal -->
		<div class="modal fade" id="writeModal" tabindex="-1" aria-labelledby="writeModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="writeModalLabel">게시글 등록</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
			  
			  <form action="/write" method="post" enctype="multipart/form-data">
		      <div class="modal-body">
		      
					<div class="mb-3">
					<label class="form-label">Title</label>
					<input type="text" class="form-control" name="title">
					</div>
					<div class="mb-3">
					<label class="form-label">Content</label>
					<textarea class="form-control" rows="3" name="content"></textarea>
					</div>
					<div class="mb-3">
					<label class="form-label">Add File</label>
					<input class="form-control" name="file" type="file" accept="image/*">
					</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">취소</button>
		        <button type="submit" class="btn btn-dark">등록</button>
		      </div>
			  </form>
		    </div>
		  </div>
		</div>
	</div>
	<style>
	.vertical-table {
	  width: 100%;
	  border-collapse: collapse;
	}
	.vertical-table th, .vertical-table td {
	  border: 1px solid #ddd;
	  padding: 10px;
	  vertical-align: top;
	}
	.vertical-table th {
	  width: 100px;
	  background-color: #f5f5f5;
	  text-align: left;
	}
	</style>
	
</body>
</html>
