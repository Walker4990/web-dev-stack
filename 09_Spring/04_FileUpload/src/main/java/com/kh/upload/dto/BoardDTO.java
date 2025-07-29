package com.kh.upload.dto;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data 
public class BoardDTO {
// vo -> 테이블이랑 1:1 매칭
	// dto -> 한꺼번에 보내는 역할
	private int no;
	private String title;
	private String content;
	private String url;
	private Date formatDate;
	private MultipartFile file;
	
	
}
