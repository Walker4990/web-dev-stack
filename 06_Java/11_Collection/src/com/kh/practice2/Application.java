package com.kh.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice2.controller.BookController;
import com.kh.practice2.controller.MemberController;
import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookController bc = new BookController();
        ArrayList<Member> members = new ArrayList<>();
        MemberController mc = new MemberController();
        Member m = new Member();
        Book book = new Book();
        // 도서 목록 (미사용이지만 향후 대여 기능에 필요)
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("디스 이즈 이탈리아", false, 0));
        books.add(new Book("리얼 런던", true, 0));
        books.add(new Book("집에서 즐기는 스페인 요리 여행", false, 0));
        books.add(new Book("사퀴트리 샌드위치", false, 0));
        books.add(new Book("원피스 111", true, 15));
        books.add(new Book("귀멸의 칼날 23", false, 19));
        books.add(new Book("진격의 거인 Before the fall 16", false, 19));

        while (true) {
            // 로그인
        	 System.out.print("이름을 입력하세요: ");
             String name = sc.nextLine();
             
             System.out.print("나이를 입력하세요: ");
             int age = Integer.parseInt(sc.nextLine());
             
             
            if(!mc.registerAndLogin(name, age)) {
            	 continue;
            }
            // 메뉴 화면
            while (true) {
                try {
                    System.out.println("===== 메뉴 =====");
                    System.out.println("1. 마이페이지");
                    System.out.println("2. 도서 대여");
                    System.out.println("3. 로그아웃");
                    System.out.println("4. 프로그램 종료");
                    System.out.println("=================");
                    System.out.print("이용하실 목록을 골라주세요 : ");
                    int menu = Integer.parseInt(sc.nextLine());

                    switch (menu) {
                        case 1:
                        	Member me = mc.getMember();
                        	if (m != null) {
                            System.out.println("회원 이름 : " + me.getName());
                            System.out.println("회원 나이 : " + me.getAge());
                        	}
                            break;
                        case 2:
                            // 도서 대여 로직은 추후 구현
                        	for(int i =0; i < books.size(); i++)
                        		System.out.println((i+1)+"번 : "+ books.get(i).getTitle() + ", " +books.get(i).isCoupon() +", "+books.get(i).getAccessAge());
                        	System.out.println("도서 번호를 선택해주세요 : ");
                        	int bookNum = Integer.parseInt(sc.nextLine()) -1 ;
                        	if (bookNum >= 0 && bookNum < books.size()) {
                        		Book select = books.get(bookNum);
                        		String result = bc.rentBook(select, mc.getMember());
                        		System.out.println("대여 완료되었습니다.");
                        	} else System.out.println("도서가 없습니다.");
                            break;
                        case 3:
                            System.out.println("로그아웃 합니다.");
                            break; // 로그인으로 돌아감
                        case 4:
                            System.out.println("프로그램 종료");
                            return;
                        default:
                            System.out.println("1~4번 중에서 선택해주세요.");
                    }

                    if (menu == 3) break; // 로그아웃 시 바깥 while로 이동

                } catch (Exception e) {
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                }
            }
        }
    }
} 