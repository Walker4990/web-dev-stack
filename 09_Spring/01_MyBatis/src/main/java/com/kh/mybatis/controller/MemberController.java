package com.kh.mybatis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;
import com.sun.net.httpserver.Request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("/")
	public String index(SearchDTO dto, Model model) {
	List<Member> list = new ArrayList<>();
	String select = dto.getSelect();
	String keyword = dto.getKeyword();
	// 전체 출력하다가 만약에 입력시 그 해당하는걸로 출력
	
	
	
	if (keyword == null || keyword.trim().isEmpty()) {
		list = service.allMember();
	} else {
		list = service.search(dto);
	}
	
//	if (select == null||select.equals("all") || 
//			keyword == null|| dto.getKeyword().trim().isEmpty()) {
//		
//	}
//	else {
//		list = service.search(dto);
//	}
//	
	
	model.addAttribute("list", list);
	model.addAttribute("dto", dto);
	return "index";
	}
	
	

	@GetMapping("/register")
	public String register() {
		return "mypage/register";
	}

	@PostMapping("/register")
	public String register(Member vo) {
		service.register(vo);
		return "redirect:/";
	}

	@GetMapping("/login")
	public String login() {
		return "/mypage/login";
	}

	// dao -> mapper -> Service -> Controller 순으로 작성하면 흐름대로 작성가능
	@PostMapping("/login")
	public String login(Member vo, HttpServletRequest request) {
		Member member = service.login(vo);
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		return "redirect:/";

	}
	
	@GetMapping("/update")
	public String update() {
		return"/";
	}
	
	@PostMapping("/update")
	public String update(Member vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		vo.setId(member.getId());
		// 이렇게 조건문을 사용하는 방법도 있음
//		if(vo.getName()==null) vo.setName(member.getName());
//		if(vo.getAge()==0) vo.setAge(member.getAge());
		service.update(vo);
		
		Member result = service.login(vo);
		session.setAttribute("member", result);
		return "redirect:/";
	}
	
//	@PostMapping("/update")
//	public String update(String pwd, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		Member member = (Member) session.getAttribute("member");
//		member.setId(member.getId());
//		member.setName(member.getName());
//		member.setAge(member.getAge());
//		service.update(pwd);
//		session.setAttribute("member", member);
//		return "redirect:/";
//	}
//	
	@GetMapping ("/delete")
	public String delete(String id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		service.delete(member.getId());
		session.invalidate();
		return "redirect:/";
	}
	
	
}