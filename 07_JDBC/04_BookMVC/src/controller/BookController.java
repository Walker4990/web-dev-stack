package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookDAO;
import dao.MemberDAO;
import dao.RentDAO;
import vo.Book;

public class BookController {
	
	
	BookDAO instance = BookDAO.getInstance();
	RentDAO instance2 = RentDAO.getInstance();
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() {

		try {
			return instance.printBookAll();
		} catch (SQLException e) {
			return new ArrayList<>();
		}
	}

	// 2. 책 등록
	public boolean registerBook(String title, String author, int accessAge) {
		try {
			if (instance.duplicateBook(title, author, accessAge)) {
				System.out.println("이미 등록된 책입니다.");
				return false;
			}
			Book book = new Book(title, author, accessAge);
			boolean success = instance.registerBook(book);
			if (success) {
				return success;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	// 3. 책 삭제
//	public boolean deleteBook(int bookNo) {
//		// 누군가 빌려있는 책은 삭제 불가
//		try {
//	if (!instance2.rentedBook()) {
//		System.out.println("삭제 불가능");
//	}
//			return instance.deleteBook(bookNo);
//		} catch (SQLException e) {
//			return false;
//		}
//
//	}
	public boolean deleteBook(String title) {
		// 누군가 빌려있는 책은 삭제 불가
		try {
			if (!instance2.rentedBook()) {
				System.out.println("삭제 불가능");
			}
			return instance.deleteBook(instance.searchBook(title));
		} catch (SQLException e) {
			return false;
		}

	}

}
