<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!--  Ajax사용을 위한 js파일을 참조 -->
<script src="js/httpRequest.js"></script>

<script>
    // 아이디 중복여부 체크
    function che() {
    // 아이디 입력창에 값이 바뀔 때마다 중복체크 상태 초기화
    b_idCheck = false;
}

    function send(f){
        let userid = f.userid.value;
        if (userid == "") {
            alert('아이디를 입력하세요');
            return;
        }

        let name = f.name.value;
        if (name == "") {
            alert("이름을 입력하세요");
            return;
        }

        // 아이디 중복체크 여부 확인
        if (!b_idCheck) {
            alert('아이디 중복체크를 하세요');
            return;
        }

        f.action = "register.do";
        f.method = "post";
        f.submit();
    }

    function check_id(){
        let userid = document.getElementById("userid").value.trim();

        if (userid == "") {
            alert('아이디를 입력해주세요');
            return;
        }

        let url = "check_id.do";
        let param = "userid=" +userid;
        sendRequest(url, param, resFn, "post")
    }
    // 삭제 하면 삭제 성공을 ajax로 띄워보자
  
    function resFn(){
    	// 콜백 메서드
    	// xhr.readyState
    	// 0 : 초기화
    	// 1~3 : 로딩중
    	// 4 : 로드 완료
    	
    	// xhr.status
    	// 200 : 이상없음
    	// 404, 500 : 에러메시지
    	if( xhr.readyState == 4 && xhr.status == 200){
    		// data = "[{ result:yes, userid:three }]" -> 문자열로 넘어옴, 진짜 json형태는 아님
    		let data = xhr.responseText;
    		
    		let json = eval( data );
    		
    		if ( json[0].result == 'no' ){
    			alert(json[0].userid + "은 이미 사용중입니다.")
    		} else {
    			alert(json[0].userid + '은 사용 가능합니다.')
    			b_idCheck = true;
    		}
    	}
    }
</script>
<body>
	<form>
	<table border ='1'>
		
		<tr>
			<th>이름</th>
			<td><input name="name" /></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input name="userid" onInput="che()" id='userid' />
				<input type="button" value="중복체크" 
				onClick="check_id()" />
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input name="pwd" type = "password"/></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input name="email" /></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input name="addr" /></td>
		</tr>
			<tr>
			<td colspan="2"><input type="button" value="등록" 
			onclick="send(this.form);" />
			<input type="button" value="취소" onClick="history.go(-1)"/></td>
		</tr>
	</table>
	</form>
</body>
</html>