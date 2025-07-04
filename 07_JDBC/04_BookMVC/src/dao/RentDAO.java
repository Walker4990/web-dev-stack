package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import config.ServerInfo;
import vo.Book;
import vo.Rent;

public class RentDAO {
	private static RentDAO instance = new RentDAO();

	public RentDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	public static RentDAO getInstance() {
		return instance;
	}

	// 7. 책 대여

//		String query1 = "SELECT access_age FROM book WHERE book_no = ?";
//		PreparedStatement ps1 = connect.prepareStatement(query1);
//		ps1.setInt(1, bookNo);
//		ResultSet rs1 = ps1.executeQuery();
//		
//		if (!rs1.next()) {
//			System.out.println("책이 존재하지 않습니다.");
//		}
//		int accessAge = rs1.getInt("access_age");
//		
//		
//		String query2 = "SELECT age FROM member WHERE id =?";
//		PreparedStatement ps2 = connect.prepareStatement(query2);
//		ps2.setString(1, id);
//		ResultSet rs2 = ps2.executeQuery();
//		if(!rs2.next()) System.out.println("회원이 존재하지 않습니다.");
//		int memberAge = rs2.getInt("age");
//		if(accessAge > memberAge) {
//			System.out.println("연령 제한으로 책 대여 불가");
//			return;
//		}

	// 렌트 시 나이제한 체크
	public boolean ageCheck(String id, int bookNo) throws SQLException {
		Connection connect = connect();
		String query1 = "SELECT m.age, b.access_age FROM member m, book b WHERE m.id = ? AND b.book_no = ?";
		try (PreparedStatement ps = connect.prepareStatement(query1)) {
			ps.setInt(1, bookNo);
			ps.setString(2, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int memberAge = rs.getInt("age");
				int accessAge = rs.getInt("access_age");
				if (memberAge < accessAge)
					return false;
			}
		}
		return true;
	}

	// 렌트 시 중복 대여 체크
	public boolean bookCheck(String id, int bookNo) throws SQLException {
		Connection connect = connect();
		String query3 = "SELECT * FROM rent WHERE id = ? AND book_no = ?";
		PreparedStatement ps3 = connect.prepareStatement(query3);
		ps3.setString(1, id);
		ps3.setInt(2, bookNo);

		ResultSet rs3 = ps3.executeQuery();
		if (rs3.next()) {
			System.out.println("이미 대여한 책입니다.");
			return false;
		}
		return true;
	}

	// 렌트 가능여부 체크
	public boolean rentCountCheck(String id) throws SQLException {
		Connection connect = connect();
		String query4 = "SELECT COUNT(*) COUNT FROM rent WHERE id = ?";
		PreparedStatement ps4 = connect.prepareStatement(query4);
		ps4.setString(1, id);

		ResultSet rs4 = ps4.executeQuery();

		if (rs4.next()) {
			int rentCount = rs4.getInt("COUNT");
			if (rentCount >= 5) {
				System.out.println("더 이상 대여할 수 없습니다.");
				return false;
			}
		}
		return true;
	}

	// 책 렌트 갯수 제한 체크
	public boolean bookCountCheck(String id, int bookNo) throws SQLException {
		Connection connect = connect();
		String query5 = "SELECT COUNT(*) COUNT FROM rent WHERE book_no = ?";
		PreparedStatement ps5 = connect.prepareStatement(query5);
		ps5.setInt(1, bookNo);

		ResultSet rs5 = ps5.executeQuery();

		if (rs5.next()) {
			int bookCount = rs5.getInt("COUNT");
			if (bookCount >= 3) {
				System.out.println("이 책은 더 이상 대여가 불가능합니다.");
				return false;
			}
		}
		return true;
	}

	// 책 대여
	public boolean rentBook(String id, int bookNo) throws SQLException {
		Connection connect = connect();
		String query6 = "INSERT INTO rent(id, book_no, rent_date) VALUES (?, ?, ?)";
		PreparedStatement ps6 = connect.prepareStatement(query6);
		ps6.setString(1, id);
		ps6.setInt(2, bookNo);
		ps6.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
		int result = ps6.executeUpdate();

		return result == 1;
	}

	// 8. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook(String id) throws SQLException {
		Connection connect = connect();
		ArrayList<Rent> list = new ArrayList<>();

		String query = "SELECT * FROM rent JOIN book USING (book_no) WHERE id =?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int bookNo = rs.getInt("book_no");
			LocalDate rentDate = rs.getDate("rent_date").toLocalDate();

//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			LocalDate rentLocal = LocalDate.parse(rentDate, formatter);
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			LocalDate date = format.parse(rentDate);
			Rent rent = new Rent();
			rent.setId(id);
			rent.setBookNo(bookNo);
			rent.setRentDate(rentDate);
			rent.setBook(new Book(rs.getInt("bookNo"), rs.getString("title"), rs.getString("author"), rs.getInt("access_age")));
			list.add(rent);
		}

		return list;
	}

	private DateTimeFormatter DateTimeFormatter(String string) {
		return null;
	}

	// 9. 대여 취소
	public void deleteRent(int rentNo) throws SQLException {
		Connection connect = connect();
		String query = "DELETE FROM rent WHERE rent_no=?;";
		PreparedStatement ps = connect.prepareStatement(query);

		ps.setInt(1, rentNo);

		int result = ps.executeUpdate();
		if (result == 1) {
			System.out.println("삭제되었습니다.");
		}

	}
	// 대여중인 책 조회
	public boolean rentedBook() throws SQLException {
		Connection connect = connect();
		String query = "SELECT COUNT(*) CNT FROM rent WHERE rent_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getInt("CNT") >0;
		}return false;
	}

}
