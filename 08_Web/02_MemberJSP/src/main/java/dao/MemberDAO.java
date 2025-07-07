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
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	public void register (String id, String name, String pwd, int age) throws SQLException {
		Connection connect = connect();
		String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, pwd);
		ps.setInt(4, age);
		ps.executeUpdate();
	}
}
