package com.kh.practice2_1.model;

import java.util.ArrayList;

import com.kh.practice2_1.model.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
// 롬복은 아무것도 없거나 전부다 있는 생성자만 생성되어있음.
public class Member {
	private String name;
	private int age;
	private int coupon;
	private ArrayList<Book> bookList = new ArrayList<>();
	
	// 모델에 값을 담아야 하는데
	// 첫번째 방식은 생성자로!
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
}