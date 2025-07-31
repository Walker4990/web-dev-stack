package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.security.service.UserService;
import com.kh.security.vo.User;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public String register(User user) {
		service.register(user);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(String id, Model model) {
		User user = service.login(id);
		model.addAttribute("user", user);
		return "index";
	}
	
}
