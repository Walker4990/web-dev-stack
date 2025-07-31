package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.dto.BoardDTO;
import com.kh.upload.dto.PagingDTO;
import com.kh.upload.service.BoardService;
import com.kh.upload.vo.Board;

@Controller
public class BoardController {

	private String path ="\\\\192.168.0.10\\upload\\";
	
	@Autowired
	private BoardService service;
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	public String fileUpload(MultipartFile file) {
		// 중복 방지를 위한 UUID 적용
		 UUID uuid = UUID.randomUUID();
				 
		 String fileName = uuid.toString() + "_" + file.getOriginalFilename();
				 
		 File copyFile= new File(path + fileName);
				 
				 
		 try {
			file.transferTo(copyFile);
		} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
		}
			return fileName;
		
	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) {
//		 System.out.println("파일 이름 : " + file.getOriginalFilename());
//		 System.out.println("파일 사이즈 : " + file.getSize());
//		 System.out.println("파일 파라미터명 : " + file.getName());
		 
		 String fileName = fileUpload(file);
		 // http://localhost:8081/ + fileName <- url
		return "redirect:/";
	}
	
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) {
		for(MultipartFile file : files) {
			String fileName = fileUpload(file);
		}
		return "redirect:/";
		
	}
	
	@GetMapping("/list")
	public String list(Model model, PagingDTO paging) {
		int total = service.total(paging.getKeyword());
		List<Board> list = service.allBoard(paging);
		model.addAttribute("list", list);
		model.addAttribute("paging", new PagingDTO(paging.getPage(), total));
		return "list";
	}
	
	@PostMapping("/write")
	public String write(BoardDTO dto, Board vo) {
		// 이미지 업로드 추가
		MultipartFile file= dto.getFile();
		String fileName = fileUpload(file);
		// board 테이블에 데이터 추가
		Board board = new Board();
		board.setTitle(dto.getTitle());
		board.setContent(dto.getContent());
		board.setUrl(fileName);
		
		service.insertBoard(board);
		
		System.out.println(board);
		return  "redirect:/view?no=" + board.getNo();
		
	}
	
	
	@GetMapping("/view")
	public String allBoard(int no, Model model) {
		BoardDTO board = service.searchBoard(no);
		model.addAttribute("board", board);
		return "view";
	}
	
	@GetMapping("/update")
	public String updateBoard(int no, Model model) {
		BoardDTO dto = service.searchBoard(no);
		model.addAttribute("board", dto);
		return "update";
	}
	@PostMapping("/update")
	public String updateBoard(BoardDTO dto, MultipartFile newFile) {
		// 새로운 파일로 수정 -> 기존 파일은 삭제하고 해당파일을 업로드하고 DB URL을 수정
		if(newFile!=null && !newFile.isEmpty()) {
		// 1. 기존 파일 삭제
		File file = new File(path + dto.getUrl());
		file.delete();
		
		String url = fileUpload(newFile);
		dto.setUrl(url);
		}
		service.updateBoard(dto);
		// 2. 해당 파일 업로드
		
//		Board board = new Board();
//		board.setContent(content);
//		board.setTitle(title);
//		board.setNo(no);
//		
//		String fileName = fileUpload(file);
//		board.setUrl(fileName);
//		service.updateBoard(board);
//		return "redirect:/view?no="+no;
//		
		return "redirect:/view?no=" + dto.getNo();
	}
	@PostMapping("/delete")
	public String delete(int no, String url) {
 		File file = new File(path + url);
		file.delete();
		service.deleteBoard(no);
		return "redirect:/list";
	}
	
	
}
