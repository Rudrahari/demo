package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.VisaCancel;
import com.example.demo.repositories.VisaCancelRepository;

@Service
public class VisaCancelService {
	
	@Autowired
	private VisaCancelRepository visaCancelrepository;
	
	public VisaCancel cancelVisa(VisaCancel visaCancellation) {

		 

     
 

        // Calculate cancellation charge based on date difference

 

        double cancellationCharge = calculateCancellationCharge(visaCancellation.getDateOfIssue());

 

        // Set cancellation charge and status to visaCancellation object

 

        visaCancellation.setCancellationCharge(cancellationCharge);

 

        visaCancellation.setStatus("Cancelled");

 

        // Save visa cancellation details to database

 

        return visaCancelrepository.save(visaCancellation);

 

    }

 

 

 

    
 

    // Business logic to calculate cancellation charge based on date difference

 

    private double calculateCancellationCharge(Date dateOfIssue) {

 

        LocalDate currentDate = LocalDate.now();

 

        LocalDate issueDate = new java.sql.Date(dateOfIssue.getTime()).toLocalDate();

 

        Period period = Period.between(issueDate, currentDate);

 

        int monthsDifference = period.getMonths();

 

        // Logic to calculate cancellation charge based on months difference

 

        if (monthsDifference < 6) {

 

            return 50.0; // Example charge for less than 6 months

 

        } else if (monthsDifference >= 6 && monthsDifference < 12) {

 

            return 100.0; // Example charge for 6 to 11 months

 

        } else {

 

            return 200.0; // Example charge for 12 or more months

 

        }

 

    }

}
