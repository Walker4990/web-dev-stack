package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookDAO;
import vo.Book;

public class BookController {
	private BookDAO dao = new BookDAO();

	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() {
		
		try {
			return dao.printBookAll();
		} catch (SQLException e) {
			return null;
		}
	}

	// 2. 책 등록
	public boolean registerBook(String title, String author, int accessAge) throws SQLException {
		// 기존 제목, 저자, 제한 나이까지 동일한 책이 있으면 안됨
		Book book = new Book(title, author, accessAge);

		if(dao.duplicateBook(book)) {
			System.out.println("이미 등록된 책입니다.");
			return false;
		}
		boolean result = dao.insertBook(title, author, accessAge);
		if(result) {
			System.out.println("책이 등록되었습니다.");
		} else System.out.println("책 등록 실패");
		return result;

	}

	private Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	// 3. 책 삭제
	public boolean sellBook(int bookNo) {
		// 누군가 빌려있는 책은 삭제 불가
		try {
			return dao.sellBook(bookNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}


	}

}
