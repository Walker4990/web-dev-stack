package com.kh.array.practice2.view;

import java.util.Scanner;

import com.kh.array.practice2.controller.MemberController;
import com.kh.array.practice2.model.Member;

public class MemberView {
	MemberController mc = new MemberController();
	Scanner sc = new Scanner(System.in);
	// 새 회원 등록 - > 꽉 차면 거절
	public void newMember() {
		Member[] arr = new Member[3];
		int count =0;
		
		for(int i = 0; i < arr.length; i++) {
			if(count==arr.length) {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다.");
				break;
			}
		}
		System.out.println("최대 등록 가능한 회원수는" + arr.length + "명입니다.");
		System.out.println("현재 등록된 회원 수는" +count+ "명입니다.");
		
		Member m = new Member();
		
		for (int i = 0; i<arr.length; i++) {
			System.out.println("아이디를 입력해주세요. : ");
			String id = m.setId(sc.nextLine());
			if (arr[i].getId().equals(m.getId())) {
				System.out.println("중복된 아이디입니다. 다시입력해주세요.");
				break;
			}
		
		}
		System.out.println("이름을 입력해주세요. : ");
		String name = m.setName(sc.nextLine());
		System.out.println("비밀번호를 입력해주세요. : ");
		String pwd = m.setPwd(sc.nextLine());
		System.out.println("이메일을 입력해주세요. : ");
		String email = m.setEmail(sc.nextLine());
		System.out.println("성별을 입력해주세요. : (M/F)");
		char gender = m.setGender(sc.nextLine().charAt(0));
		System.out.println("나이를 입력해주세요. : ");
		int age = m.setAge(sc.nextInt());
		
		arr[count++] = m;
		System.out.println("회원등록이 완료되었습니다.");
		
		
}
}
