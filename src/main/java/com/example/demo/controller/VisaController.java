package com.example.demo.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Visa;
import com.example.demo.model.VisaCancel;
import com.example.demo.service.VisaCancelService;
import com.example.demo.service.VisaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class VisaController {
	
	@Autowired
	VisaService visaService;
	
	@Autowired
	VisaCancelService visaCancelService;
	
	@PostMapping("/applyVisa")
	public String handleApplyVisaData(@RequestParam("userId") String userId,
			   @RequestParam("country") String country,
			   @RequestParam("occupation") String occupation,
			   @RequestParam("dateOfApplication") String dateOfApplication,
			   HttpSession session)
	{
		
		Visa visa=new Visa();
		visa.setUserId(userId);
		visa.setCountry(country);
		visa.setOccupation(occupation);
		String visaId=visaService.generateVisaId(visa);
		visa.setVisaId(visaId);
		double expiryYears=visaService.getExpiryDate(visa);
	
		
		Date applicationDate=Date.valueOf(dateOfApplication);
		LocalDate issue=applicationDate.toLocalDate();
		LocalDate issuedate=issue.plusDays(10);
		Date dateOfIssue=Date.valueOf(issuedate);
		Date dateOfExpiry;
		if(expiryYears==1.5)
		{
			LocalDate expiry=dateOfIssue.toLocalDate();
			LocalDate exp=expiry.plusYears(1).plusMonths(6);
			 dateOfExpiry=Date.valueOf(exp);
		}
		else
		{
		    Integer	ex=(int) expiryYears;
			LocalDate expiry=dateOfIssue.toLocalDate();
			LocalDate exp=expiry.plusYears(ex);	
			 dateOfExpiry=Date.valueOf(exp);
		}
		
		double cost=visaService.calculateRegistrationCost(visa);
		visa.setRegistrationCost(cost);
		visa.setDateOfExpiry(dateOfExpiry);
		
		visa.setDateOfIssue(dateOfIssue);
		visa.setDateOfApplication(applicationDate);
		
		visaService.saveVisaData(visa);
		session.setAttribute("visadetails", visa);
		return "aftervisa";
	}
	
	@PostMapping(value="/cancelvisadetails", produces = "text/html")
	public String getCancelVisaDetails(@RequestBody VisaCancel visaCancel)
	{
	
		System.out.println(visaCancel);
		
		visaCancelService.cancelVisa(visaCancel);
		return "home2";
	}
	

}
