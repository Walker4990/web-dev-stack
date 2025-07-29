package com.kh.upload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.dto.BoardDTO;
import com.kh.upload.vo.Board;

@Mapper
public interface BoardMapper {

	void insertBoard(Board board); // insert
	List<Board> allBoard(); // selectAll
	Board searchBoard(int no);  // select
	void deleteBoard(int no);	//delete
	void updateBoard(Board board);	//update
}
