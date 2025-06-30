package com.kh.practice3.model;

import com.kh.list.model.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Music implements Comparable<Music>{

	private String artist;
	private String song;

	@Override
	public int compareTo(Music m) {
		return this.artist.compareTo(m.artist);
		
		// 컨트롤러에서 리버스 안하고 this 와 o 의 위치를 바꾸기만해도 내림차순 정렬됨.
	}
}
