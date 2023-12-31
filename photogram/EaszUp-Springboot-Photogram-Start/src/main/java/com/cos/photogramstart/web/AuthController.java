 package com.cos.photogramstart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

@Controller  //1. IoC 2.파일을 리턴하는 컨트롤러 
public class AuthController {
	
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	
	private AuthService authService;
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}
	
	//회원가입버튼 -> /auth/signup -> /auth/signin
	//회원가입버튼X
	@PostMapping("/auth/signup")
	public String signup(SignupDto signupDto) { // key = value(x-www-form-urlencoded)
		System.out.println("signup 실행됨?");
		log.info(signupDto.toString());
		// User <- SignupDto 

		return "auth/signin";
	}
}
