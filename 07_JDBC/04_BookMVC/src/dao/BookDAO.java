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
	
		public BookDAO() {
			try {
				Class.forName(ServerInfo.DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		public Connection connect() throws SQLException {
			return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		}

	
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException{
		Connection connect = connect();
		String query = "SELECT * FROM book";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<Book> list = new ArrayList<>();
		
		while (rs.next()) {
			Book book = new Book(rs.getInt("book_no"), 
					rs.getString("title"),
					rs.getString("author"), 
					rs.getInt("accessAge"));
			list.add(book);
		
	}
		return list;
	}
	// 2. 책 등록(중복검사)
	public boolean duplicateBook(Book book) throws SQLException {
		Connection connect = connect();
		String query = "SELECT COUNT(*) FROM book WHERE title =?, author =?, accessAge =?";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		ps.setString(1, book.getTitle());
		ps.setString(2, book.getAuthor());
		ps.setInt(3, book.getAccessAge());
		
		if(rs.next() && rs.getInt(1) > 0 ) {
			return true;
		}
		return false;
	
	}
	
	public boolean insertBook(String title, String author, int accessAge) throws SQLException {
		Connection connect = connect();
		String query = "INSERT INTO book(title, author, access_age) VALUES (?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		ps.setString(1, title);
		ps.setString(2, author);
		ps.setInt(3, accessAge);
		return  ps.executeUpdate() == 1;
	}

	
	// 3. 책 삭제
	public boolean sellBook(int bookNo) throws SQLException {
		Connection connect = connect();
		String query = "DELETE FROM book where book_no =?";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		ps.setInt(1, bookNo);
		
		int result = ps.executeUpdate();

		return result == 1;
	}
		
		
	
	}

