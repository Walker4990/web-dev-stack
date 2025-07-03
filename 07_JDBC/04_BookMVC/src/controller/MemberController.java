package controller;

import vo.Member;

public class MemberController {

	// 4. 회원가입
	public void register(Member client) {
		// id가 primary key 여서 에러가 남 -> 활용ㄱㄱ
	}
	
	// 5. 로그인
	public Member login(String id, String pwd) {
		return null;
	}
	
	// 6. 회원 탈퇴
	public void delete(String id) {
		// 회원 탈퇴 시 대여중인 책 모두 기록 삭제
	}
}
