package com.yiwxine.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yiwxine.service.UserService;
import com.yiwxine.util.Result;
import com.yiwxine.util.UserFrom;

@Controller
public class RegisterController {

	@Resource
	private UserService userService;
	
	@GetMapping("/register")
	public String register(){
		return "register";
	}
	

	@PostMapping("/register")
	public String Register(@Valid UserFrom userfrom){
		userService.Register(userfrom);
		return "success";
	}
	
}
