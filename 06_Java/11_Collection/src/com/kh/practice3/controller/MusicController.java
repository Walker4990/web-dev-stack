package com.kh.practice3.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.kh.practice3.compare.SongAscending;
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
		if (artist.trim().equals("") && song.trim().equals("")) {
			// 띄어쓰기 불가능하게 만들기
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
			if (m.getArtist().toLowerCase().contains(keyWord.toLowerCase())
					|| m.getSong().toLowerCase().contains(keyWord.toLowerCase())) {
				// .toLowerCase :
				// 대소구분 없이 하기위해 그냥 아예 바꿔버리게 만들어버림 --> 키워드 검색 시 많이 사용함.
				result.add(m); // 이 조건에 만족하는 m 값 결과창에 추가
				System.out.println(m.getArtist() + " - " + m.getSong());
			} else
				System.out.println("검색할 곡을 찾지 못했습니다.");
		}
		return result; // 키워드 검색한 것 출력
	}

	// 곡 검색 시 중복된 경우
	public List<Music> checkMusic(String song) {
		List<Music> result = new ArrayList<>();
		for (Music music : list) {
			if (music.getSong().equals(song)) {
				result.add(music);
			}
		}
		return result;
	}

	// 4. 특정 곡 수정
//		public Music updateMusic(String searchMusic, String updateSong, String updateArtist) {
//		for (Music m : list) {
//			if (m.getSong().equals(searchMusic)) {
//				// .equalsIgnoreCase -> 대소구분 무시
//				Music before = new Music(m.getArtist(), m.getSong());
//				m.setArtist(updateArtist);
//				m.setSong(updateSong);
//				return before;
//			}
//		}
	// 강사님 버전
	public Music updateMusic(String searchMusic, String searchArtist, Music update) {
		for (Music m : list) {

			if (searchArtist == null && m.getSong().equals(searchMusic)
					|| m.getSong().equals(searchMusic) && m.getArtist().equals(searchArtist)) {
				// 기존 리스트에서 수정할 값이 있는 경우 - 수정 못하게
				if (m.getSong().equals(update.getSong()) && m.getArtist().equals(update.getArtist()))
					return null;
			}
			return list.set(list.indexOf(searchMusic), update);
		}
		return null;
	}

	// 5. 특정 곡 삭제
	public Music removeMusic(String title) { // 삭제할 변수 담기
		for (int i = 0; i < list.size(); i++) {
			if (title.equals(list.get(i).getSong())) {
				System.out.println(list.get(i).getSong() + " - " + list.get(i).getArtist() + "의 곡이 삭제되었습니다.");
				return list.remove(i);
			}
			if (!title.equals(list.get(i).getSong())) {
				System.out.println("삭제할 곡이 없습니다.");
			}
		}

		return null;

	}
	public List<Music> descArtist() {
		List<Music> clone = (List<Music>) list.clone();
		 Collections.sort(clone);
		 Collections.reverse(clone);
		 return clone;
	}// 7번에서만 내림차순 정렬하고 싶어서 클론으로 복제 후 정렬 후 출력
	
	// 곡명 오름차순
	public List<Music> ascSong() {
		List<Music> clone = (List<Music>) list.clone();
		Collections.sort(clone, new SongAscending());
		//Comparator : 정렬 기준
		return clone;
	}
}
	
