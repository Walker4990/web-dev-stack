package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
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

	public static MemberDAO getInstance() {
	    return instance;
	}

	// 4. 회원가입
	public void register(Member member) throws SQLException {
		Connection connect = connect();
		String query1 = "SELECT * FROM member where id = ?";
		PreparedStatement ps1 = connect.prepareStatement(query1);

		String query2 = "INSERT INTO member(id, name, pwd, age) VALUES (?, ?, ?, ?)";
		PreparedStatement ps2 = connect.prepareStatement(query2);

		ps1.setString(1, member.getId());
		ResultSet rs = ps1.executeQuery();

		if (rs.next()) {
			System.out.println("이미 존재하는 아이디입니다.");
			return;
		}
		ps2.setString(1, member.getId());
		ps2.setString(2, member.getName());
		ps2.setString(3, member.getPwd());
		ps2.setInt(4, member.getAge());

		int result = ps2.executeUpdate();

		if (result == 1) {
			System.out.println("회원 가입 성공!");
		} else
			System.out.println("회원가입 실패!");

	}

	// 5. 로그인
	public Member login(String id, String pwd) throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM member where id = ? AND pwd = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Member member = new Member();
			member.setId(rs.getString("id"));
			member.setPwd(rs.getString("pwd"));
			member.setPwd(rs.getString("pwd"));
			member.setAge(rs.getInt("age"));
			return member;
		} else
			return null;
	}

	// 6. 회원 탈퇴
	public void delete(String id) throws SQLException {
		Connection connect = connect();
		String query1 = "DELETE FROM member where id = ?";
		String query2 = "DELETE FROM rent where id= ?";
		PreparedStatement ps1 = connect.prepareStatement(query1);
		ps1.setString(1, id);
		PreparedStatement ps2 = connect.prepareStatement(query2);
		ps2.setString(1, id);

		int result = ps1.executeUpdate();
		if (result == 1) {
			System.out.println(id + "님이 회원 탈퇴하였습니다.");
		} else
			System.out.println("다시 입력해주세요.");

	}

}
