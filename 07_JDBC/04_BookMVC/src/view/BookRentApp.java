package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.BookController;
import controller.MemberController;
import controller.RentController;
import vo.Book;
import vo.Member;

public class BookRentApp {

	private Scanner sc = new Scanner(System.in);

	// 로그인 했을 시 사용자 정보 담을 객체!
	private Member client = new Member();

	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();

	public static void main(String[] args) {
		BookRentApp app = new BookRentApp();
		app.menu();
	}

	public void menu() {
		while (true) {
			// 1. 전체 책 조회 - 로그인 X
			// 2. 회원가입 - 로그인 X
			// 3. 로그인 - 로그인 X
			
			// 관리자로 로그인 했을 때
			// 1. 책 등록 - 로그인 O (관리자 : admin, 1234)
			// 2. 책 삭제 - 로그인 O (관리자 : admin, 1234)
			// 3. 로그아웃 - 로그인 O
			
			// 1. 회원탈퇴 - 로그인 O (관리자 X)
			// 2. 책 대여 - 로그인 O
			// 3. 내가 대여한 책 조회 - 로그인 O
			// 4. 대여 취소 - 로그인 O

			// 일반회원이 들어왔을 때
			// 1. 회원탈퇴 - 로그인 O (관리자 X)
			// 2. 로그아웃 - 로그인 O
			// 3. 책 대여 - 로그인 O
			// 4. 내가 대여한 책 조회 - 로그인 O
			// 5. 대여 취소 - 로그인 O

			System.out.println("1. 전체 책 조회");
			// 로그인 x
			System.out.println("2. 책 등록");
			// 로그인 x
			System.out.println("3. 책 삭제");
			// 로그인 x
			System.out.println("4. 회원가입");
			System.out.println("5. 로그인");
			System.out.println("6. 회원 탈퇴");
//		System.out.println("7. 책 대여");
//		System.out.println("8. 내가 대여한 책 조회");
//		System.out.println("9. 대여 취소");

			System.out.println("번호 입력 > ");
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				printBookAll();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				deleteBook();
				break;
			case 4:
				membership();
				break;
			case 5:
				login();
				break;
			case 6:
				withdraw();
				break;
			}

		}
	}

	public void printBookAll() {
		ArrayList<Book> list = bc.printBookAll();
		if(list.isEmpty()) {
			System.out.println("등록된 책이 없습니다.");
		return;
		}
		
		for (Book b : list) {
			System.out.println(b);
		}
	}

	public boolean registerBook() {

	

		try {
			System.out.println("등록할 책 이름 : ");
			String title = sc.nextLine();

			System.out.println("등록할 저자명 : ");
			String author = sc.nextLine();

			System.out.println("등록할 제한 나이 : ");
			int accessAge = Integer.parseInt(sc.nextLine());
			boolean result = bc.registerBook(title, author, accessAge);
			
			if(result) {
				System.out.println("책 등록 완료");
			} else System.out.println("책 등록 불가");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
		
	}

	public void deleteBook() {

	}

	public void membership() {

	}

	public void login() {

	}

	public void withdraw() {

	}
}
