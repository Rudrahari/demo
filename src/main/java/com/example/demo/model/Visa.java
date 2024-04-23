package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="visa")
public class Visa {
	
	@Id

	@Column(name = "visa_id")

	private String visaId;

	@Column(name = "user_id")

	private String userId;

	@Column(name = "country")

	private String country;

	@Column(name = "occupation")

	private String occupation;

	@Column(name = "date_of_application")

	private Date dateOfApplication;

	@Column(name = "date_of_issue")

	private Date dateOfIssue;

	@Column(name = "date_of_expiry")

	private Date dateOfExpiry;

	@Column(name = "registration_cost")

	private double registrationCost;

	public Visa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Visa(String visaId, String userId, String country, String occupation, Date dateOfApplication,
			Date dateOfIssue, Date dateOfExpiry, double registrationCost) {
		super();
		this.visaId = visaId;
		this.userId = userId;
		this.country = country;
		this.occupation = occupation;
		this.dateOfApplication = dateOfApplication;
		this.dateOfIssue = dateOfIssue;
		this.dateOfExpiry = dateOfExpiry;
		this.registrationCost = registrationCost;
	}

	public String getVisaId() {
		return visaId;
	}

	public void setVisaId(String visaId) {
		this.visaId = visaId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Date getDateOfApplication() {
		return dateOfApplication;
	}

	public void setDateOfApplication(Date dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public double getRegistrationCost() {
		return registrationCost;
	}

	public void setRegistrationCost(double registrationCost) {
		this.registrationCost = registrationCost;
	}

	@Override
	public String toString() {
		return "Visa [visaId=" + visaId + ", userId=" + userId + ", country=" + country + ", occupation=" + occupation
				+ ", dateOfApplication=" + dateOfApplication + ", dateOfIssue=" + dateOfIssue + ", dateOfExpiry="
				+ dateOfExpiry + ", registrationCost=" + registrationCost + "]";
	}

	
	

   	
	

}
