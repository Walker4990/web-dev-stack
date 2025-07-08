package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {
	public MemberDAO() {
		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	public void register(String id, String pwd, String name, int age) throws SQLException {
		Connection connect = connect();
		String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, pwd);
		ps.setInt(4, age);
		
		ps.executeUpdate();
	}
	public Member login(String id, String pwd) throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM member WHERE id= ? AND pwd = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		
		Member member = null;
		if(rs.next()) {
			member = new Member(rs.getString("id"), rs.getString("pwd"),
					rs.getString("name"), rs.getInt("age"));
		}
		
		return member;
		
	}
	public Member search(String id) throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM member WHERE id= ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
	
		ResultSet rs = ps.executeQuery();
		Member member=null;
		if(rs.next()) {
			member = new Member(rs.getString("id"), rs.getString("pwd"),
					rs.getString("name"), rs.getInt("age"));
		}
		return member;
	}
	public List<Member> searchAll() throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM member";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Member> list = new ArrayList<>();
		while(rs.next()) {
			list.add(new Member(rs.getString("id"), rs.getString("name"), 
					rs.getString("pwd"), rs.getInt("age")));
		}
		return list;
	}
}
