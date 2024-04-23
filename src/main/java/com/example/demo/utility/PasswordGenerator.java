package com.example.demo.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PasswordGenerator {
	public String generatePassword() {
		 
        // Generate current date and month
 
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMM");
 
        String currentDate = dateFormat.format(new Date()).toLowerCase();
 
        // Generate a random special character (# or @ or $)
 
        String[] specialChars = {"#", "@", "$"};
 
        String randomSpecialChar = specialChars[(int) (Math.random() * specialChars.length)];
 
        // Generate a random 3-digit number
 
        int randomDigits = (int) (Math.random() * 900) + 100;
 
        return currentDate + randomSpecialChar + randomDigits;
 
    }
 
    // Determine citizen type based on age

}
