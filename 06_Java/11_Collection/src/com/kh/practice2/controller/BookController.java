package com.kh.practice2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kh.practice2.Application;
import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class BookController {
	
	

	// (선택사항) 책 제목 기준으로 현재 대여 인원 수 파악Add commentMore actions
		private Map<String, Integer> bookCount = new HashMap<>();
		
		// 책 대여
		public String rentBook(Book book, Member member) {
			List<Book> rent = member.getBookList();
			if(rent.size() > 4) return "더 이상 대여할 수 없습니다.";
			
			 for(Book b : rent) {
				 if(b.getTitle().equals(book.getTitle())) {
					  return "이미 대여한 책입니다.";
				 }
				 if(book.getAccessAge() > member.getAge()) {
					 return "나이 제한으로 대여 불가능합니다.";
					 
				 }
				 if (book.getAccessAge() > member.getAge() && member.getCoupon() > 0) {
					 continue;
				 }
			 }
			
	/*	
	 * -> 1. 한 사람 당 대여할 수 있는 책은 총 3권
			 *              "더 이상 대여할 수 없습니다."a
			 *      -> 2. 해당 사람이 대여한 책은 대여 불가능
			 *      		"이미 대여한 책입니다."a
			 *      -> 3. 나이 제한에 걸리는 책들 대여 불가능
			 *              "나이 제한으로 대여 불가능합니다." a
			 *      -> 4. 쿠폰이 있는 경우 나이 제한 걸려도 대여 가능a
			 *      -> (선택사항) 5. 각 책들마다 가능한 대여가 3권까지만
			 *                     HashMap -> getOrDefault(키, 초기값)
			 *      -> 대여 가능한 경우 : "성공적으로 대여되었습니다."	
	 * */
			return null;
			
			
			
		}
		
		
		
		
	}
