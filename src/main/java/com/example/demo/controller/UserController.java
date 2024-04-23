package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utility.PasswordGenerator;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/registerUserData")
	public String insertUserData(User user,HttpSession session)
	{
		String userid=userService.generateUserId(user.getApplyType());
		System.out.println(userid);
		boolean present=userService.emailExists(user.getEmail());
		if(present)
		{
			return "registration";
		}
		PasswordGenerator generate=new PasswordGenerator();
		String password=generate.generatePassword();
		String id=userService.generateUserId(user.getApplyType());
		session.setAttribute("userid", id);
		session.setAttribute("password", password);
		user.setPassword(password);
		user.setUserId(id);
		userService.saveData(user);
		System.out.println(user);
		return "afterregistration";
		
		
		
	}
	@GetMapping("/gohome")
	public String getHomePage(HttpSession session)
	{
		session.invalidate();
		return "home1";
		
	}
	
	

}
