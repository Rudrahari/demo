package com.example.demo.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Login;
import com.example.demo.model.PassportRenewal;
import com.example.demo.model.User;
import com.example.demo.service.HomeService;
import com.example.demo.service.UserService;
import com.example.demo.utility.TransactionIdGenerator;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	@Autowired 
	private UserService userService;
	@GetMapping("/")
	
	public String getHome1()
	{
		return "home1";
	}
	
	@GetMapping("/home2")
	public String getHome2 ()
	{
		return "home2";
	}
	@GetMapping("/applyPassport")
	public String getApplyPassport ()
	{
		return "applypassport";
	}
	@GetMapping("/applyVisa")
	public String getApplyVisa ()
	{
		return "applyvisa";
	}
	@GetMapping("/passportRenewal")
	public String getPassportRenewal ()
	{
		return "passportrenewal";
	}
	@GetMapping("/cancelVisa")
	public String getCancelVisa()
	{
		return "cancelvisa";
	}
	@GetMapping("/registration")
	public String getRegistration()
	{
		return "registration";
	}
	@GetMapping("/loginUser")
	
	public String getLogin()
	{
		return "home1";
	}
	@GetMapping("/logout")
	public String userLogout(HttpSession session)
	{
		session.invalidate();
		
		return "home1";
	}
	
	@PostMapping("/login")
	public String userLogin (Login login,  HttpSession session)
	{
	
		Optional<User> user = userService.getUserData(login.getEmail());
		if(user.isPresent())
		{
			if(login.getPassword().equals(user.get().getPassword()))
			{
				
				User userinfo=user.get();
				Optional<PassportRenewal> pass=homeService.getPassportData(userinfo.getUserId());
				PassportRenewal passport=pass.get();
				session.setAttribute("userdata", userinfo);
				session.setAttribute("passportinfo", passport);
				return "home2";
			}
			else {
				return "home1";
			}
		}
		return "home1";
		
	}
	@PostMapping ("/registerUser")
	public String handleUserRegistrationData()
	{
		//update the form data to database
		return "home2";
	
		
	}
	@PostMapping ("/registerPassportData")
	public String handleregisterPassportData(PassportRenewal passport)
	{
		Date date=Date.valueOf(passport.getReceivedissuedate());
		passport.setIssuedate(date);
		TransactionIdGenerator generate=new TransactionIdGenerator();
		String id=generate.generateTransactionId();
		passport.setTransactionId(id);
		//passport.setPassportId("passid");
		LocalDate localDate = date.toLocalDate();
		LocalDate updatedLocalDate = localDate.plusYears(10);
		Date updatedSqlDate = Date.valueOf(updatedLocalDate);
		passport.setExpirydate(updatedSqlDate);
		System.out.println(date);
		System.out.println(passport);
		String passpoertid=homeService.generatePassportId(passport.getBooklettype());
		passport.setPassportId(passpoertid);
		homeService.saveData(passport);
		return "home2";
	
		
	}
	@PostMapping ("/updatePassportData")
	public String handleUpdatePassportData(PassportRenewal passport)
	{
		//update the form data to database
		Date date=Date.valueOf(passport.getReceivedissuedate());
		passport.setIssuedate(date);
		TransactionIdGenerator generate=new TransactionIdGenerator();
		String id=generate.generateTransactionId();
		passport.setTransactionId(id);
		//passport.setPassportId("passid");
		LocalDate localDate = date.toLocalDate();
		LocalDate updatedLocalDate = localDate.plusYears(10);
		Date updatedSqlDate = Date.valueOf(updatedLocalDate);
		passport.setExpirydate(updatedSqlDate);
		System.out.println(date);
		System.out.println(passport);
		String passpoertid=homeService.generatePassportId(passport.getBooklettype());
		passport.setPassportId(passpoertid);
		homeService.updateData(passport);
		return "home2";
	
		
	}
	
}
