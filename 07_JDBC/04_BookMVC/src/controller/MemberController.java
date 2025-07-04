package controller;

import java.sql.SQLException;

import dao.BookDAO;
import dao.MemberDAO;
import vo.Member;

public class MemberController {
	MemberDAO instance = MemberDAO.getInstance();
	
	// 4. 회원가입
	public void register(Member member) {
		// id가 primary key 여서 에러가 남 -> 활용ㄱㄱ
		try {
			instance.register(member);
		} catch (SQLException e) {
			System.out.println("실패!");
		}
		 
		
	}
	
	// 5. 로그인
	public Member login(String id, String pwd) {
		try {
			Member member = instance.login(id, pwd);
			if(member != null) {
				return member;
			}
		} catch (SQLException e) {
			
		}
		return null;
	}
	
	// 6. 회원 탈퇴
	public boolean delete(String id) {
		// 회원 탈퇴 시 대여중인 책 모두 기록 삭제
		try {
			instance.delete(id);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
