package com.kh.step5;

import com.kh.step5.model.Book;

public class Application {

	public static void main(String[] args) {
		// 생성자 방식으로 값을 담아낼 수 있다.
		Book book = new Book("고독한 용의자", 19500, 0.1, "찬호께이");
		System.out.println(book);
		
		// setter 방식으로 값을 담아낼 수 있다.
		Book book2 = new Book();
		book2.setTitle("토막 난 우주를 안고서");
		book2.setPrice(17000);
		book2.setDiscount(0.2);
		book2.setAuthor("김초엽");
		System.out.println(book2);
		
		/*
		 * getter 메서드는 개체의 필드 값을 읽어올 때 사용
		 * 할인된 가격 = 원래 가격 - (원래가격 * 할인율)
		 * */
		// [책 제목]의 [할인된 가격]은 [00000]원 입니다.
		
		
		int discount = (int) (book.getPrice() - (book.getPrice() * book.getDiscount()));
//		book.setPrice((int) (book.getPrice() - book.getPrice() * book.getDiscount()));
//		System.out.println(book.getTitle() + "의 할인된 가격은 " + book.getPrice() + "원 입니다.");
//																discount 넣어도 됨.
//		book2.setPrice((int) (book2.getPrice() - book2.getPrice() * book2.getDiscount()));
//		System.out.println(book2.getTitle() + "의 할인된 가격은 " + book2.getPrice() + "원 입니다.");
		
		
		
		
		
		
		
		
		
	}

}
