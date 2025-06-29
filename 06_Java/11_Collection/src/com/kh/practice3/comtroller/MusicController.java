package com.kh.practice3.comtroller;

import java.util.ArrayList;
import java.util.List;

import com.kh.practice3.model.Music;

public class MusicController {
	Music m = new Music();
	private ArrayList<Music> list = new ArrayList<>();

	// 1. 특정 곡 추가
	public boolean addList(String artist, String song) {
		Music newMusic = new Music(artist, song);
		if (list.contains(newMusic)) {
			return false;
		}
		list.add(newMusic);
		return true;
	}

	// 2. 전체 곡 목록 출력
	public List<Music> printAll() {
		if (list.isEmpty()) {
			System.out.println("목록이 비었습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(i + "." + list.get(i).getSong() + " - " + list.get(i).getArtist());
			}
		}
		
		
		return list;

	}

	// 3. 특정 곡 검색
	public List<Music> searchMusic(String keyWord) {
		
		List<Music> result = new ArrayList<>();
		for (Music m : list) {
			if (m.getArtist().contains(keyWord) || m.getSong().contains(keyWord)) {
				result.add(m); // 이 조건에 만족하는 m 값 결과창에 추가
				System.out.println(m.getArtist() + " - " + m.getSong());
			} 
			}
		return result; // 키워드 검색한 것 출력
	}

	// 4. 특정 곡 수정
	public Music updateMusic(String searchMusic, String updateSong, String updateArtist) {
		for (Music m : list) {
			if (m.getSong().equals(searchMusic)) {
				Music before = new Music(m.getArtist(), m.getSong());
				m.setArtist(updateArtist);
				m.setSong(updateSong);
				return before;
			}
		}
		return null;
	}

	// 5. 특정 곡 삭제
	public Music removeMusic(String title) { //  삭제할 변수 담기
		for (int i = 0; i < list.size(); i++) {
			if (title.equals(list.get(i).getSong())) {
				System.out.println(list.get(i).getSong() + " - " + list.get(i).getArtist() + "의 곡이 삭제되었습니다.");
			return	list.remove(i);
			}
			if (!title.equals(list.get(i).getSong())) {
				System.out.println("삭제할 곡이 없습니다.");
			}
	} 
		
		return null;
		
	}
}