package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import dao.PersonDAO;
import vo.Person;

// DAO - Controller - View의 중간관리자 역할 -> MyBatis, JPA로 변환
public class PersonController {

	private PersonDAO dao = PersonDAO.getInstance();

	// person 테이블에 데이터 추가 - INSERT
	public String addPerson(String name, int age, String addr) {
		// 이름, 나이, 주소가 모두 다 같은 경우 "이미 정보가 있습니다." -> 가입 x

		try {
			boolean check = dao.checkName(name, age, addr);
			if (check) {
				return "이미 정보가 있습니다.";
			}
			return dao.addPerson(name, age, addr);
			
		} catch (SQLException e) {
			return "회원가입 실패";
		}

		
	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public List<Person> searchAllPerson() {
		try {
			return dao.searchAllPerson();
		} catch (SQLException e) {
			return null;
		}
		
	}

	// person 테이블에서 데이터 한개만 가져오기 - SELECT -> id로!
	public Person searchPerson(int id) {
		try {
			return dao.searchPerson(id);
		} catch (SQLException e) {
			return null;
		}
	}

	// person 테이블에 데이터 수정 - UPDATE
	public int updatePerson(String newName, int newAge, String newAddr) {
		try {
			return dao.updatePerson(newName, newAge, newAddr);
		} catch (SQLException e) {
				return 0;
		}
	}

	// person 테이블에 데이터 삭제 - DELETE
	public String removePerson(int id) {
		try {
			if(dao.removePerson(id)) {
			return "삭제 완료 되었습니다.";
			}
			return "삭제 실패";
		} catch (SQLException e) {
			return "문제가 심각하니 관리자에게 문의해주세요";
		}
	}
}
