<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 수정</title>
<script>
	function send(f){
        let deptno = f.deptno.value;
        let dname  = f.dname.value;
        let loc    = f.loc.value;

        if (deptno === "") {
            alert("부서 번호를 입력하세요");
            return;
        }
        if (dname === "") {
            alert("부서명을 입력하세요");
            return;
        }
        if (loc === "") {
            alert("위치를 입력하세요");
            return;
        }
		f.action = 'dept_modify_fin.do';
		f.submit();
	}
</script>
</head>
<body>
<form>
	<table border="1">
	<caption>부서 정보 수정</caption>
		<input type="hidden" value="${ vo.deptno }" name="ori_deptno" />
		<tr>
			<th>부서 번호</th>
			<td><input name="deptno" value="${vo.deptno}" readonly /></td>
		</tr>
		<tr>
			<th>부서명</th>
			<td><input name="dname" /></td>
		</tr>
		<tr>
			<th>위치</th>
			<td><input name="loc" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정완료" onclick="send(this.form);" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>
