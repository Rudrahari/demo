package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table

public class PassportRenewal {
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="userid")
	private String userid;
	
	@Id
	@Column(name="passportid")
	private String passportId;
	@Column(name="transactionid")
	private String transactionId;
	
	@Column(name="pin")
	private String pin;
	
	@Column(name="country")
	private String country;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="typeofservice")
	private String typeofservice;
	
	@Column(name="booklettype")
	private String booklettype;
	
	@Column(name="issuedate")
	private Date issuedate;
	
	@Transient
	private String receivedissuedate;
	
	
	
	@Column(name="expirydate")
	private Date expirydate;



	public PassportRenewal() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PassportRenewal(String reason, String userid, String passportId, String transactionId, String pin,
			String country, String state, String city, String typeofservice, String booklettype, Date issuedate,
			String receivedissuedate, Date expirydate) {
		super();
		this.reason = reason;
		this.userid = userid;
		this.passportId = passportId;
		this.transactionId = transactionId;
		this.pin = pin;
		this.country = country;
		this.state = state;
		this.city = city;
		this.typeofservice = typeofservice;
		this.booklettype = booklettype;
		this.issuedate = issuedate;
		this.receivedissuedate = receivedissuedate;
		this.expirydate = expirydate;
	}



	public String getReason() {
		return reason;
	}



	public void setReason(String reason) {
		this.reason = reason;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getPassportId() {
		return passportId;
	}



	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}



	public String getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}



	public String getPin() {
		return pin;
	}



	public void setPin(String pin) {
		this.pin = pin;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getTypeofservice() {
		return typeofservice;
	}



	public void setTypeofservice(String typeofservice) {
		this.typeofservice = typeofservice;
	}



	public String getBooklettype() {
		return booklettype;
	}



	public void setBooklettype(String booklettype) {
		this.booklettype = booklettype;
	}



	public Date getIssuedate() {
		return issuedate;
	}



	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}



	public String getReceivedissuedate() {
		return receivedissuedate;
	}



	public void setReceivedissuedate(String receivedissuedate) {
		this.receivedissuedate = receivedissuedate;
	}



	public Date getExpirydate() {
		return expirydate;
	}



	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}



	@Override
	public String toString() {
		return "PassportRenewal [reason=" + reason + ", userid=" + userid + ", passportId=" + passportId
				+ ", transactionId=" + transactionId + ", pin=" + pin + ", country=" + country + ", state=" + state
				+ ", city=" + city + ", typeofservice=" + typeofservice + ", booklettype=" + booklettype
				+ ", issuedate=" + issuedate + ", receivedissuedate=" + receivedissuedate + ", expirydate=" + expirydate
				+ "]";
	}




}	