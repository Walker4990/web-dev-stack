package com.kh.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice2.controller.BookController;
import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookController bc = new BookController();
        ArrayList<Member> members = new ArrayList<>();

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
            Member member = null;
            while (true) {
                System.out.print("이름을 입력하세요 : ");
                String name = sc.nextLine();
                System.out.print("나이를 입력하세요 : ");
                int age = Integer.parseInt(sc.nextLine());

                boolean duplicate = false;
                for (Member m : members) {
                    if (m.getName().equals(name)) {
                        duplicate = true;
                        System.out.println("이미 존재하는 이름입니다. 다시 입력해주세요.");
                        break;
                    }
                }

                if (!duplicate) {
                    member = new Member(name, age);
                    members.add(member);
                    bc.inputInfo(name, age); // 컨트롤러에 저장
                    break;
                }
            }

            // 메뉴 화면
            while (true) {
                try {
                    System.out.println("\n===== 메뉴 =====");
                    System.out.println("1. 마이페이지");
                    System.out.println("2. 도서 대여");
                    System.out.println("3. 로그아웃");
                    System.out.println("4. 프로그램 종료");
                    System.out.println("=================");
                    System.out.print("이용하실 목록을 골라주세요 : ");
                    int menu = Integer.parseInt(sc.nextLine());

                    switch (menu) {
                        case 1:
                            System.out.println("회원 이름 : " + member.getName());
                            System.out.println("회원 나이 : " + member.getAge());
                            break;
                        case 2:
                            // 도서 대여 로직은 추후 구현
                            System.out.println("도서 대여 기능은 준비 중입니다.");
                            break;
                        case 3:
                            System.out.println("로그아웃 합니다.\n");
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