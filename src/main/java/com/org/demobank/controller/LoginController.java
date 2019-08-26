package com.org.demobank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.demobank.bean.User;
import com.org.demobank.service.AccountService;

@Controller
public class LoginController {
	
	@Autowired
	AccountService accountService;
	
	
	@RequestMapping("/")
	public String home(ModelMap model) {
		String userName="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		User user= accountService.getAccountInfo(userName);
		model.addAttribute(user);
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "login.jsp";
	}
	
	@RequestMapping("/logout-sucess")
	public String logout() {
		
		return "logout.jsp";
	}
	
}
