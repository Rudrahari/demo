package com.example.demo.utility;

import java.util.Random;

public class TransactionIdGenerator {
	public String generateTransactionId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(9);
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }
        return sb.toString();
    }

}
