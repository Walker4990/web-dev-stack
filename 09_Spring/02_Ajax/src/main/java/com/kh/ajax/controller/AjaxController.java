package com.kh.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.mapper.MemberMapper;
import com.kh.ajax.model.vo.Member;
import com.kh.ajax.service.MemberService;

@Controller
public class AjaxController {

    private final PageController pageController;

	@Autowired
	private MemberService service;
	
	
	
	private int count = 0;

    AjaxController(PageController pageController) {
        this.pageController = pageController;
    }
	
	@ResponseBody
	@GetMapping("/count")
	public int count() {
		return ++count;
	}
	
	@ResponseBody
	@GetMapping("/encoding")
	public String encoding(String nickname) {
		return nickname;
	}
	@ResponseBody
	@PostMapping("/idCheck")
	public boolean idCheck(String id) {
//		Member member=service.idCheck(id);
//		if(member!=null) return true;
		return service.idBoolCheck(id);
	}
	@ResponseBody
	@PostMapping("/signup")
	public void signUp(String id, String pwd) {
		System.out.println(id);
		System.out.println(pwd);
	}
}
