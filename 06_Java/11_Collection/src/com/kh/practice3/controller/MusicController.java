package com.kh.practice3.controller;

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
		return list;

	}

	// 3. 특정 곡 검색
	public List<Music> searchMusic() {
		return list;
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
	public void removeMusic() {

	}

}