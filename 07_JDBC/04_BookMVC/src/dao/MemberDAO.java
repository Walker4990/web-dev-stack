package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {
	public MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	
	
	// 4. 회원가입
	public void register(Member member) throws SQLException {
		Connection connect = connect();
		String query = "";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, member.getId());
		
	}
	
	// 5. 로그인
	public Member login(String id, String pwd) {
		return null;
	}
	
	// 6. 회원 탈퇴
	public void delete(String id) {
		
	}
}
