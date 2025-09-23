<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function send(f){
        let deptno = f.deptno.value;
        let patt = /^[0-9\]*$/;
        if ( !patt.test(dept.no)|| deptno=''){
        	alert('부서번호는 정수로 입력하세요.')
        }
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
		f.action = 'register.do';
		f.submit();
	}
</script>
<body>
<form>
		<table border="1">
		
		<tr>
			<th>부서 번호</th>
			<td><input name="deptno" /></td>
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
			<td colspan="2"><input type="button" value="확인" 
			onclick="send(this.form);" /></td>
		</tr>
		</table>
	</form>
</body>
</html>