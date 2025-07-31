package com.kh.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.security.vo.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {

	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
}
