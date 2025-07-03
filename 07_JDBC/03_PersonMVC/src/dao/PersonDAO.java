package dao;
/*
 * DAO (Data Access Object)
 * - 데이터베이스에 접근해서 CRUD를 처리하는 객체
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import vo.Person;

public class PersonDAO {
	
	// 싱글톤 패턴 : 실제로 생성되는 객체는 하나!
	// 1. private static 객체(instance) 생성
	private static PersonDAO instance = new PersonDAO();
	
	// 2. private 생성자가 있어야함.
	private PersonDAO() {
		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 3. public static 메서드로 인스턴스 제공
	public static PersonDAO getInstance() {
		return instance;
	}
	
	// 고정적으로 반복 -- 디비 연결, 자원반납
	// 2. 디비 연결
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	// 오버로딩!
	public void close(PreparedStatement ps, Connection connect) throws SQLException {
		ps.close();
		connect.close();
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException {
		rs.close();
		close(ps, connect);
	}
	// ------- 변동적인 반복 : DAO(Database Access Object)

	public boolean checkName(String name, int age, String addr) throws SQLException {
		Connection connect = getConnect();

		String query = "SELECT name, age, addr FROM person where name = ? AND age = ? AND addr = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);

		ResultSet rs = ps.executeQuery();
		// rs.next() - 존재하면 true, 존재하지 않으면 false
		return rs.next();

	}

	// person 테이블에 데이터 추가 - INSERT
	public String addPerson(String name, int age, String addr) throws SQLException {
		// 하나의 메서드로 데이터베이스와 연결해서 그 정보만 가져옴.
		Connection connect = getConnect();

		// 3. PreparedStatement 객체 생성 - 쿼리
		String query = "INSERT INTO person(name, age, addr) VALUES(?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);

		// 4. 쿼리 실행
		int result = ps.executeUpdate(); // COMMIT

		// 5. 자원 반납
		close(ps, connect);

		return name + "님, 회원가입 완료";
	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public List<Person> searchAllPerson() throws SQLException {
		Connection connect = getConnect();

		String query = "SELECT * FROM person";
		PreparedStatement ps = connect.prepareStatement(query);

		ResultSet rs = ps.executeQuery();
		List<Person> list = new ArrayList<>();
		while (rs.next()) {
			Person person = new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("addr"));
			list.add(person);
		}

		close(rs, ps, connect);
		return list;
	}

	// person 테이블에서 데이터 한개만 가져오기 - SELECT -> id로!
	public Person searchPerson(int id) throws SQLException {
		Connection connect = getConnect();

		String query = "SELECT * FROM person where id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, id);
		// --> 개발 추가 예정

		ResultSet rs = ps.executeQuery();
		Person person = null;
		if (rs.next()) {
			person = new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("addr"));
		}

		close(rs, ps, connect);

		return person;
	}

	// person 테이블에 데이터 수정 - UPDATE
	public int updatePerson(String newName, int newAge, String newAddr) throws SQLException {
		Connection connect = getConnect();

		String query = "UPDATE person SET name= ?, age = ?, addr = ? where id= ?";
		PreparedStatement ps = connect.prepareStatement(query);

		ps.setString(1, newName);
		ps.setInt(2, newAge);
		ps.setString(3, newAddr);

		// --> 로직 추가 예정
		int result = ps.executeUpdate(); // SQL문이 실행되고 영향을 받은 행의 갯수를 반환
		if (result > 0)
			System.out.println("수정 완료");
		else
			System.out.println("수정 불가");

		close(ps, connect);
		return result;
	}

	// person 테이블에 데이터 삭제 - DELETE
	public boolean removePerson(int id) throws SQLException {
		Connection connect = getConnect();
		String query = "DELETE FROM person WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, id);

		ps.executeUpdate();

		close(ps, connect);
		
		return true;
	}
}
