package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import vo.Book;

public class BookDAO {
	private static BookDAO instance = new BookDAO();
	
	public BookDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public static BookDAO getInstance() {
	    return instance;
	}

	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM book";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<Book> list = new ArrayList<>();

		while (rs.next()) {
			Book book = new Book(rs.getInt("book_no"), 
					rs.getString("title"), 
					rs.getString("author"),
					rs.getInt("access_age"));
			
			list.add(book);

		}
		return list;
	}

	// 2. 책 등록(중복검사)
	public boolean duplicateBook(String title, String author, int accessAge) throws SQLException {
		Connection connect = connect();

		String query1 = "SELECT COUNT(*) FROM book WHERE title = ? AND author = ? AND access_age = ?";
		PreparedStatement ps1 = connect.prepareStatement(query1);
		ps1.setString(1, title);
		ps1.setString(2, author);
		ps1.setInt(3, accessAge);
		ResultSet rs = ps1.executeQuery();


			if (rs.next()) {
				return rs.getInt(1) > 0;
			}
		
		return false;
	}

	// 2. 등록 처리
	  public boolean registerBook(Book book) throws SQLException {
	     Connection connect = connect();
	        String sql = "INSERT INTO book (title, author, access_age) VALUES (?, ?, ?)";
	        PreparedStatement ps = connect.prepareStatement(sql);
	        System.out.println(book);
	        ps.setString(1, book.getTitle());
	        ps.setString(2, book.getAuthor());
	        ps.setInt(3, book.getAccessAge());

	        int result = ps.executeUpdate();

	     
	        return result == 1;
	    }
	// 제목으로 책조회 -->PK로 어떤 항목을 선택하는 일은 없기 때문에 제목으로 책을 조회한다.
	  public int searchBook(String title) throws SQLException {
			Connection connect = connect();
			String query = "SELECT book_no FROM book where title =?";
			PreparedStatement ps = connect.prepareStatement(query);

			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				return rs.getInt("book_no");
				
			}
			return -1;
		}

	// 3. 책 삭제
	public boolean deleteBook(int bookNo) throws SQLException {
		Connection connect = connect();
		String query = "DELETE FROM book where book_no =?";
		PreparedStatement ps = connect.prepareStatement(query);

		ps.setInt(1, bookNo);

		int result = ps.executeUpdate();

		return result == 1;
	}

//	 boolean result = bc.deleteBook(bookNo);
//	 if (result) {
//		 list.remove(bookNo);
//		 System.out.println("삭제 완료");
//		 return true;

}
