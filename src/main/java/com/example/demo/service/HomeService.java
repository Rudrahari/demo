package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PassportRenewal;
import com.example.demo.model.User;
import com.example.demo.repositories.HomeRepository;

@Service
public class HomeService {
	@Autowired
	private HomeRepository homeRepository;
	public void saveData(PassportRenewal passport) {
		
		homeRepository.save(passport);
		
		
		
	}
	
	public Optional<PassportRenewal> getPassportData(String userId)
	{
		return homeRepository.getOldPassport(userId);
	}
	public void updateData(PassportRenewal passport) {
		//PassportRenewal oldpassport= homeRepository.findById(passport.getPassportId()).orElse(passport);
		Optional<PassportRenewal> old=homeRepository.getOldPassport(passport.getUserid());
	    PassportRenewal oldpassport=old.get();
	    PassportRenewal newpassport=new PassportRenewal();
	    newpassport.setBooklettype(passport.getBooklettype());
	    newpassport.setCity(passport.getCity());
	    newpassport.setCountry(passport.getCountry());
	    newpassport.setExpirydate(passport.getExpirydate());
	    newpassport.setIssuedate(passport.getIssuedate());
	    newpassport.setPassportId(passport.getPassportId());
	    newpassport.setReason(passport.getReason());
	    newpassport.setReceivedissuedate(passport.getReceivedissuedate());
	    newpassport.setState(passport.getState());
	    newpassport.setTypeofservice(passport.getTypeofservice());
	    newpassport.setUserid(passport.getUserid());
	    newpassport.setPin(oldpassport.getPin());
	    newpassport.setTransactionId(passport.getTransactionId());
	    homeRepository.delete(oldpassport);
		homeRepository.save(newpassport);
		
	}
	public  String generatePassportId(String booklettype)
	{
		Optional<List<PassportRenewal>> passport=homeRepository.getLastPassportId(booklettype);
		
		if(booklettype.equals("30 Pages"))
		{
		
		if(passport.isPresent())
		{
			List<PassportRenewal> passports=passport.get();
			if(passports.isEmpty())
			{
				return "FPS-301000";
				
			}
			int result=0;
			for(PassportRenewal p:passports)
			{
				String val=p.getPassportId();
				String id=val.substring(val.length()-4);
				System.out.println(id);
				
				Integer pass=Integer.valueOf(id);
				if(pass>result)
				{
					result=pass;
				}
			}
			
			
			return "FPS-30"+(result+1);
			
		}
		else
		{
			return "FPS-301000";
			
			
		}
		
	} 
	else 
	{
		if(passport.isPresent())
		{
			List<PassportRenewal> passports=passport.get();
			if(passports.isEmpty())
			{
				return "FPS-601000";
				
			}
			int result=0;
			for(PassportRenewal p:passports)
			{
				String val=p.getPassportId();
				String id=val.substring(val.length()-4);
				Integer pass=Integer.valueOf(id);
				if(pass>result)
				{
					result=pass;
				}
			}
			
			
			return "FPS-60"+(result+1);
			
			
			
		}
		else
		{
			return "FPS-601000";
			
		}
		
	}
}

}
