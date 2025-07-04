package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookDAO;
import dao.MemberDAO;
import dao.RentDAO;
import vo.Rent;

public class RentController {
	RentDAO instance = RentDAO.getInstance();
	// 로그인된 경우만 접근 가능! -> View 에서 조건 걸어서 안보이게 하면 됨

	// 7. 책 대여
	public String rentBook(String id, int bookNo) {
		// 한 사람 당 대여할 수 있는 책은 총 5권 v
		// 한 사람이 중복 책 대여 불가능 v
		// 나이 제한 걸리는 책 대여 불가능 v
		// 각 책들마다 가능한 대여가 2권까지만 v

		
		try {
			
			if (!instance.ageCheck(id, bookNo)) return "나이제한에 걸립니다.";
			if (!instance.bookCheck(id, bookNo)) return "이미 대여한 책입니다.";
			if (!instance.rentCountCheck(id)) return "더이상 대여 불가능합니다.";
			if (!instance.bookCountCheck(id, bookNo)) return "이 책은 더 이상 대여가 불가능합니다.";
			if (instance.rentBook(id, bookNo)) {
				return "대여 성공!";
			} else return "대여 실패";
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		return "관리자에게 문의하세요.";

	}

	// 8. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook(String id) {
		ArrayList<Rent> list = new ArrayList<>();
		try {
			list = instance.printRentBook(id);
			for (Rent r : list)
				System.out.println(r);

			if (list.isEmpty())
				System.out.println("대여한 책이 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 9. 대여 취소
	public boolean deleteRent(int rentNo) {
		try {
			instance.deleteRent(rentNo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
