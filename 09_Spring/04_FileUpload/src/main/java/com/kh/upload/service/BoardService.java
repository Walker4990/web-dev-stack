package com.kh.upload.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.dto.BoardDTO;
import com.kh.upload.mapper.BoardMapper;
import com.kh.upload.vo.Board;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	
	public void insertBoard(Board board) {
		mapper.insertBoard(board);
	}
	public List<BoardDTO> allBoard() {
		List<Board> list = mapper.allBoard();
		List<BoardDTO> dtoList = new ArrayList<BoardDTO>();
		for(Board b : list) {
			BoardDTO dto = new BoardDTO();
			dto.setNo(b.getNo());
			dto.setTitle(b.getTitle());
			Date formatDate = Date.from(b.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
			dto.setFormatDate(formatDate);
			dtoList.add(dto);
		}
		return dtoList;
	}
	public BoardDTO searchBoard(int no) {
		 BoardDTO dto = new BoardDTO();
		 Board board = mapper.searchBoard(no);
		    dto.setNo(board.getNo());
		    dto.setTitle(board.getTitle());
		    dto.setContent(board.getContent());
		    dto.setUrl(board.getUrl());
		    Date formatDate = Date.from(board.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
		    dto.setFormatDate(formatDate); // 만약 Date 변환 필요 시
		    return dto;
	}
	public void deleteBoard(int no) {
		mapper.deleteBoard(no);
	}
	public void updateBoard(Board board) {
		mapper.updateBoard(board);
	}
}
