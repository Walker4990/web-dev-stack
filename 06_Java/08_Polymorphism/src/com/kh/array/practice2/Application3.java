package com.kh.array.practice2;

import java.util.Scanner;

import com.kh.array.practice2.model.Member;

public class Application3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Member[] members = new Member[3];
		int count = 0;
		boolean check = true;
		
		
		while(check) {
		System.out.println("최대 등록 가능한 회원 수는 "+ members.length + "명입니다.");
		System.out.println("현재 등록된 회원 수는 " + count + "명입니다.");
		
		if(count < members.length) {
		System.out.println("1. 새 회원 등록");
		} else System.out.println("회원수가 꽉 찼기 때문에 일부 메뉴만 오픈합니다.");
		
		System.out.println("2. 회원 정보 수정");
		System.out.println("3. 전체 회원 정보 출력");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		int num= Integer.parseInt(sc.nextLine());
		

		switch(num) {
		case 1:
	
			Member m = new Member();
			while(true) {
			System.out.println("아이디 입력해주세요. : ");
			String inputId = m.setId(sc.nextLine());
			 boolean sameId = false;//  false - 중복 x
			/*
			 * 1. 새 회원 등록
		 * 		 -> 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 있는 경우
		 * 			"중복된 아이디입니다. 다시 입력해주세요." 출력 후
		 * 			다시 아이디 입력부터 나올 수 있게 처리
		 * 
		 *          아이디 : 
		 *          이름 : 
		 *          비밀번호 : 
		 *          이메일 : 
		 *          성별(M/F) : 
		 *          나이 : 
			 * */
//			    for (int i = 0; i < count; i++) {
//			        if (members[i] != null && members[i].getId().equals(inputId)) {
//			            System.out.println("이미 같은 아이디가 있습니다. 다시 입력해주세요.");
//			            sameId = true; // 같은 아이디 찾았다! true로 바꿈
//			            break; // 찾았으니 더 볼 필요 없음
//			        }
//			    }
//
//			    if (sameId) { // sameId =true
//			        continue; // 다시 아이디 입력부터 시작
//			    }
//
//			   
//			    m.setId(inputId);
//			    break;
//			}
			boolean idCheck = true;
			for(Member member : members) {
				if(member != null && member.getId().equals(m.getId())) {
					idCheck = false;
				}
			}
			// 아이디 이외에 내용이 아이디가 하나라도 있는 경우 안나오게 처리
			if(idCheck) {
				System.out.println("이름을 입력해주세요. : ");
				m.setName(sc.nextLine());
				System.out.println("비밀번호를 입력해주세요. : ");
				m.setPwd(sc.nextLine());
				System.out.println("이메일을 입력해주세요. : ");
				m.setEmail(sc.nextLine());
				System.out.println("성별을 입력해주세요. : (M/F)");
				m.setGender(sc.nextLine().charAt(0));
				System.out.println("나이를 입력해주세요. : ");
				m.setAge(Integer.parseInt(sc.nextLine()));
				members[count++] = m;
			}
			}	
			/*
			2. 회원 정보 수정
			 * 		-> 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우
			 * 			"회원 정보가 없습니다." 출력 후 다시 메인 화면으로
			 * 			
			 * 		   수정할 회원의 아이디 : 
			 * 		   수정할 이름 : 
			 *         수정할 이메일 : 
			 *         수정할 비밀번호 :
			*/
		case 2:
			System.out.println("수정할 회원의 아이디 : ");
			String id = sc.nextLine();
			boolean idFind = true;
//			for(int i =0; i < members.length; i++) {
//			if(members[i]!= null && members[i].getId().equals(id)) {
//				System.out.println("수정할 회원의 이름 : ");
//				String name = sc.nextLine();
//				System.out.println("수정할 회원의 이메일 : ");
//				String email = sc.nextLine();
//				System.out.println("수정할 회원의 비밀번호 : ");
//				String pwd = sc.nextLine();
//			}
//			
//			}if (idFind = false) {
//				System.out.println("아이디가 없습니다.");
//			} break;
		for(Member member : members) {
			if(member != null && member.getId().equals(id)) {
				idFind = false;
			}
		}
			if (idFind) {
				System.out.println("회원 정보가 없습니다.");
			} else {
				System.out.println("수정할 회원의 이름 : ");
				String name = sc.nextLine();
				System.out.println("수정할 회원의 이메일 : ");
				String email = sc.nextLine();
				System.out.println("수정할 회원의 비밀번호 : ");
				String pwd = sc.nextLine();
			}
			
//			for(int i=0; i < members.length; i++) {
//				if(members[i]!=null && members[i].getId().equals(id))
//					members[i].setName(name);
//					members[i].setEmail(email);
//					members[i].setPwd(pwd);
//			}
//			
		
			
		case 3:
			for(Member member : members) {
				if(member!=null) {
				System.out.println(member);
				}
			}
			break;
		case 9:
			System.out.println("프로그램 종료");
			check = false;
			break;
			
		default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		 break;
		}
		}
		/*
		 * 회원 수가 3명이 최대 등록 가능
		 * 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다."와 함께
		 * '1. 새 회원 등록 하지 못하게' 화면상 보이지 않게 처리!
		 * 
		 * 최대 등록 가능한 회원 수는 3명입니다.
		 * 현재 등록된 회원 수는 ~명입니다.
		 * 
		 * 2. 회원 정보 수정
		 * 		-> 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우
		 * 			"회원 정보가 없습니다." 출력 후 다시 메인 화면으로
		 * 			
		 * 		   수정할 회원의 아이디 : 
		 * 		   수정할 이름 : 
		 *         수정할 이메일 : 
		 *         수정할 비밀번호 :
		 * 3. 전체 회원 정보 출력
		 * 		-> 반복문 사용해서 끝!
		 * 9. 끝내기 -> 프로그램 종료
		 * 그 외의 번호 -> 잘못 입력하셨습니다. 다시 입력해주세요
		 * 
		 * 메뉴 번호 : 
		 * */
	}
	
}



