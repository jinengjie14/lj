package com.yiwxine.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yiwxine.dao.UserDao;
import com.yiwxine.domain.User;
import com.yiwxine.service.UserService;
import com.yiwxine.util.UserFrom;

@Controller
public class LoginController {

	@Resource
	private UserService userService;
	
	@Resource
	private UserDao userDao;
	
	@GetMapping("/login")
    public String login(){
			return "login";
		}
		
	
	@PostMapping("/login")
	public String login(HttpSession session,@Valid UserFrom userFrom){
		userService.login(session,userFrom);
		return "index";
	}
	
}
