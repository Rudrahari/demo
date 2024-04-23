package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="visa_cancellation")
public class VisaCancel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "passport_number")
    private String passportNumber;

   @Column(name = "visa_number")
    private String visaNumber;

    @Column(name = "date_of_issue")
    private Date dateOfIssue;

    @Column(name = "cancellation_charge")
    private double cancellationCharge;

    @Column(name = "status")
    private String status;

	public VisaCancel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VisaCancel(Long id, String userId, String passportNumber, String visaNumber, Date dateOfIssue,
			double cancellationCharge, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.passportNumber = passportNumber;
		this.visaNumber = visaNumber;
		this.dateOfIssue = dateOfIssue;
		this.cancellationCharge = cancellationCharge;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getVisaNumber() {
		return visaNumber;
	}

	public void setVisaNumber(String visaNumber) {
		this.visaNumber = visaNumber;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public double getCancellationCharge() {
		return cancellationCharge;
	}

	public void setCancellationCharge(double cancellationCharge) {
		this.cancellationCharge = cancellationCharge;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "VisaCancel [id=" + id + ", userId=" + userId + ", passportNumber=" + passportNumber + ", visaNumber="
				+ visaNumber + ", dateOfIssue=" + dateOfIssue + ", cancellationCharge=" + cancellationCharge
				+ ", status=" + status + "]";
	}

	
    
    

}
