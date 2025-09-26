<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="js/httpRequest.js"></script>
<script>
	function send(f){
		f.action = "insert.do";
		f.submit();
	}
</script>
<body>
	<jsp:include page="index.jsp"/>
	<!-- 이미지 업로드는 post로 보내야함. 배열 단위로 쪼개서 스트림하기 때문 -->
	<form method="post" 
		enctype="multipart/form-data">
		<table border="1"
			   align = "center"
			   width = "600">
			<tr>
				<td>제품 카테고리</td>
				<td>
					<select name="category">
						<option>카테고리 선택</option>
						<option value="com001">컴퓨터</option>
						<option value="ele002">생활가전</option>
						<option value="sp003">스포츠</option>
					</select>
				</td>
			</tr>
				
			<tr>
				<td>제품 코드</td>
				<td>
					<input name="p_num"/>
				</td>
			</tr>
			<tr>
				<td>제품명</td>
				<td>
					<input name="p_name"/>
				</td>
			</tr>
			<tr>
				<td>제조사</td>
				<td>
					<input name="p_company"/>
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input name="p_price"/>
				</td>
			</tr>
			<tr>
				<td>할인가격</td>
				<td>
					<input name="p_saleprice"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">제품설명</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea row="5" cols="80" style="resize:none"
							name="p_content"></textarea>
				</td>
			</tr>
			<tr>
				<td>썸네일 이미지</td>
				<td><input type="file" name="p_image_s" ></td>
			</tr>
			
			<tr>
				<td>상세보기 이미지</td>
				<td><input type="file" name="p_image_l"/></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="button" value="등록" onClick="send(this.form)" />
				<input type="button" value="취소" onclick="history.go(-1)" />
			</tr>
			
		</table>
	</form>
</body>
</html>