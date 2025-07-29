package com.kh.paging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.paging.dto.PagingDTO;
import com.kh.paging.service.FilmService;
import com.kh.paging.vo.Film;



@Controller
public class FilmController {

	@Autowired
	private FilmService service;
	
	@GetMapping("/list")
	public String showFilm(Model model, PagingDTO paging) {
		System.out.println(paging);
		List<Film> list = service.showFilm(paging);
		int total = service.total(); 
		model.addAttribute("list", list);
		model.addAttribute("paging", new PagingDTO(paging.getPage(), total)); // 앞단에서 받을게 필요함
		return "list";
	}
}
