package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void saveData(User user) {
		System.out.println(user);
//		String userid=generateUserId(user.getApplyType());
//		user.setUserId(userid);
		userRepository.save(user);
	}
	public boolean emailExists(String email)
	{
		Optional<User> user=userRepository.ifEmailAlreadyExists(email);
		if(user.isPresent())
		{
			return true;
		}
		return false;
	}
	public Optional<User> getUserData(String email)
	{
		Optional<User> user=userRepository.ifEmailAlreadyExists(email);
		if(user.isPresent())
		{
			return user;
		}
		return user;
	}
	public String generateUserId(String applyType)
	{
		Optional<User> user=userRepository.getLastUserId(applyType);
		if(applyType.equals("Passport"))
		{
		
		if(user.isPresent())
		{
			String id= user.get().getUserId();
			String lastuserid=id.substring(5);
			Integer userid=(Integer.valueOf(lastuserid))+1;
			String result="PASS-"+userid;
			return result;
		}
		else
		{
			return "PASS-1000";
			
			
		}
		
	} 
	else 
	{
		if(user.isPresent())
		{
			String id= user.get().getUserId();
			String lastuserid=id.substring(5);
			String value=lastuserid.replace(".","");
			Integer userid=(Integer.valueOf(value))+1;
			String val=String.valueOf(userid);
			String first=val.substring(0,val.length()-4);
			String second=val.substring(4);
			
			String result="VISA-"+first+"."+second;
			return result;
		}
		else
		{
			return "VISA-1000.1000";
			
		}
		
	}
}
	
	
	

}
