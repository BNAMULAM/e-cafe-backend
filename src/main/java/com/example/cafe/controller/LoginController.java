package com.example.cafe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafe.dto.LoginDTO;
import com.example.cafe.entity.Login;
import com.example.cafe.service.ILoginService;

@RestController
@RequestMapping("/Login")
public class LoginController {
	
	@Autowired
	ILoginService iLoginService;
	
	@PostMapping("/register")
	public String register(@Valid @RequestBody LoginDTO loginDTO) {
		return iLoginService.register(loginDTO);
	}
	
	@GetMapping("/login")
	public Login login(@RequestParam String userName, @RequestParam String password) {
		return iLoginService.login(userName,password);
		
	}

}
