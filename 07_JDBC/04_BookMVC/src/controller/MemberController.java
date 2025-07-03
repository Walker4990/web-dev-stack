package controller;

import java.sql.SQLException;

import dao.MemberDAO;
import vo.Member;

public class MemberController {
	private MemberDAO dao = new MemberDAO();
	// 4. 회원가입
	public void register(Member member) {
		// id가 primary key 여서 에러가 남 -> 활용ㄱㄱ
		try {
			dao.register(member);
		} catch (SQLException e) {
			System.out.println("실패!");
		}
		 
		
	}
	
	// 5. 로그인
	public Member login(String id, String pwd) {
		try {
			Member member = dao.login(id, pwd);
			if(member != null) {
				System.out.println("로그인 성공!");
			}else System.out.println("로그인 실패!");
		} catch (SQLException e) {
			return null;
		}
		
		return null;
	}
	
	// 6. 회원 탈퇴
	public void delete(String id) {
		// 회원 탈퇴 시 대여중인 책 모두 기록 삭제
		try {
			dao.delete(id);
		} catch (SQLException e) {
			System.out.println("관리자에게 문의하세요.");
		}
	}
}
