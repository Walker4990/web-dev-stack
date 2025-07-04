package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.BookController;
import controller.MemberController;
import controller.RentController;
import vo.Book;
import vo.Member;
import vo.Rent;

public class BookRentApp {

	private Scanner sc = new Scanner(System.in);

	// 로그인 했을 시 사용자 정보 담을 객체!
	private Member member = null;

	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();

	public static void main(String[] args) {
		BookRentApp app = new BookRentApp();
		app.menu();
	}

	public void menu() {
		while (true) {
			if (member == null) { // 로그인 X
				menu1();
			} else if ("admin".equals(member.getId()) && "1234".equals(member.getPwd())) {
				menu2(); // 관리자
			} else {
				menu3(); // 일반 회원
			}
		}
	}


	public void menu1() {
		System.out.println("1. 전체 책 조회");
		System.out.println("2. 회원가입");
		System.out.println("3. 로그인");
		System.out.print("선택 > ");
		switch (Integer.parseInt(sc.nextLine())) {
		case 1:
			printBookAll();
			break;
		case 2:
			register();
			break;
		case 3:
			login();
			break;
		}
	}

	// 관리자로 로그인 했을 때
	public void menu2() {
		System.out.println("1. 책 등록");
		System.out.println("2. 책 삭제");
		System.out.println("3. 로그아웃");
		System.out.print("선택 > ");
		switch (Integer.parseInt(sc.nextLine())) {
		case 1:
			registerBook();
			break;
		case 2:
			deleteBook();
			break;
		case 3:
			this.member = null;
			break;
		}
	}

	// 일반 회원인 경우
	public void menu3() {

		System.out.println("1. 회원탈퇴");
		System.out.println("2. 로그아웃");
		System.out.println("3. 책 대여");
		System.out.println("4. 내가 대여한 책 조회");
		System.out.println("5. 대여 취소");
		System.out.print("선택 > ");
		switch (Integer.parseInt(sc.nextLine())) {
		case 1:
			delete();
			break;
		case 2:
			this.member = null;
			break;
		case 3:
			rentBook();
			break;
		case 4:
			printRentBook();
			break;
		case 5:
			deleteRent();
			break;
		}
	}
//	public void menu() {
//		while (true) {
//			// 메뉴
//			// 1. 전체 책 조회 - 로그인 X
//			// 2. 회원가입 - 로그인 X
//			// 3. 로그인 - 로그인 X
//
//			// 관리자로 로그인 했을 때
//			// 1. 책 등록 - 로그인 O (관리자 : admin, 1234)
//			// 2. 책 삭제 - 로그인 O (관리자 : admin, 1234)
//			// 3. 로그아웃 - 로그인 O
//
//			// 1. 회원탈퇴 - 로그인 O (관리자 X)
//			// 2. 책 대여 - 로그인 O
//			// 3. 내가 대여한 책 조회 - 로그인 O
//			// 4. 대여 취소 - 로그인 O
//
//			// 일반회원이 들어왔을 때
//			// 1. 회원탈퇴 - 로그인 O (관리자 X)
//			// 2. 로그아웃 - 로그인 O
//			// 3. 책 대여 - 로그인 O
//			// 4. 내가 대여한 책 조회 - 로그인 O
//			// 5. 대여 취소 - 로그인 O
//
//			System.out.println("1. 전체 책 조회");
//			// 로그인 x
//			System.out.println("2. 책 등록");
//			// 로그인 x
//			System.out.println("3. 책 삭제");
//			// 로그인 x
//			System.out.println("4. 회원가입");
//			System.out.println("5. 로그인");
//			System.out.println("6. 회원 탈퇴");
//			System.out.println("7. 책 대여");
//			System.out.println("8. 내가 대여한 책 조회");
//			System.out.println("9. 대여 취소");
//
//			System.out.println("번호 입력 > ");
//			int select = Integer.parseInt(sc.nextLine());
//			switch (select) {
//			case 1:
//				printBookAll();
//				break;
//			case 2:
//				registerBook();
//				break;
//			case 3:
//				deleteBook();
//				break;
//			case 4:
//				register();
//				break;
//			case 5:
//				login();
//				break;
//			case 6:
//				delete();
//				break;
//			case 7:
//				rentBook();
//				break;
//			case 8:
//				printRentBook();
//				break;
//			case 9:
//				deleteRent();
//				break;
//			}
//
//		}
//	}

	public void printBookAll() {
		ArrayList<Book> list = bc.printBookAll();
		if (list == null && list.isEmpty()) {
			System.out.println("등록된 책이 없습니다.");
			return;
		}

		for (Book b : list) {
			System.out.println(b);
		}
	}

	public void registerBook() {
		if (member.getId() == null || !member.getId().equals("admin")) {
			System.out.println("관리자만 책 등록이 가능합니다.");
			return;
		}

		System.out.println("등록할 책 이름 : ");
		String title = sc.nextLine();

		System.out.println("등록할 저자명 : ");
		String author = sc.nextLine();

		System.out.println("등록할 제한 나이 : ");
		int accessAge = Integer.parseInt(sc.nextLine());

		System.out.println(title + " / " + author + " / " + accessAge);
		
		  boolean result = bc.registerBook(title, author, accessAge);

		    if (result) {
		        System.out.println(title + "책 등록 완료!");
		    } else {
		        System.out.println("책 등록 실패!");
		    }
	}

	public void deleteBook() {
		
		System.out.println("--------전체 책 조회--------");
		printBookAll();
		System.out.print("삭제할 책 제목 > ");
//		int bookNo = Integer.parseInt(sc.nextLine());
		String title = sc.nextLine();
		if(bc.deleteBook(title)) {
			System.out.println(title +"이 삭제되었습니다.");
		} else System.out.println("책 삭제 실패");
//		boolean result = bc.deleteBook(bookNo);
//		if (result)
//			System.out.println(bookNo + "번의 책이 삭제되었습니다.");
//		else
//			System.out.println("해당 번호의 책이 없습니다.");
	}

	public void register() {
		System.out.print("아이디 입력 > ");
		String id = sc.nextLine();
		System.out.print("이름 입력 > ");
		String name = sc.nextLine();
		System.out.print("비밀번호 입력 > ");
		String pwd = sc.nextLine();
		System.out.print("나이 입력 > ");
		int age = Integer.parseInt(sc.nextLine());

		Member member = new Member(id, name, pwd, age);

		mc.register(member);
	}

	public void login() {
		System.out.print("아이디 입력 > ");
		String id = sc.nextLine();
		System.out.print("비밀번호 입력 > ");
		String pwd = sc.nextLine();

		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		Member result = mc.login(id, pwd);
		if (result != null) {
		    this.member = result; //
		    System.out.println(member.getName() + "님 로그인 성공!");
		} else {
		    System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
		}
	}

	public String delete() {
		System.out.print("아이디 입력 > ");
		String id = sc.nextLine();
		boolean result = mc.delete(id);
		if (result) {
			member = null;
			menu1();
			
		}
		
		return "탈퇴 완료";
	}

	public void rentBook() {
		System.out.print("아이디를 입력하세요 >");
		String id = sc.nextLine();

		System.out.println("--------전체 책 조회--------");
		printBookAll();
		
		System.out.println("대여할 책 번호를 입력하세요 > ");
		int bookNo = Integer.parseInt(sc.nextLine());

		String result = rc.rentBook(id, bookNo);
		System.out.println(result);
		
	}

	public void printRentBook() {
		System.out.print("아이디를 입력하세요 >");
		String id = sc.nextLine();
		ArrayList<Rent> list = rc.printRentBook(id);
		for(Rent r : list) {
			System.out.println(r.getBook());
		}
	}

	public void deleteRent() {
		ArrayList<Rent> list = rc.printRentBook(this.member.getId());
		for(Rent r : list) {
			System.out.println(r);
		}
		System.out.print("대여 취소할 책 대여번호 > ");
		int rentNo = Integer.parseInt(sc.nextLine());
		rc.deleteRent(rentNo);
	}
}
