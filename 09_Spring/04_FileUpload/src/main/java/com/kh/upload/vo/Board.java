package com.kh.upload.vo;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Board {
	private int no;
	private String title;
	private String content;
	private String url;
	private LocalDateTime createdAt;
	public Date getFormatDate() {
	    if (createdAt == null) return null;
	    return java.sql.Timestamp.valueOf(createdAt);
	}
	
}
