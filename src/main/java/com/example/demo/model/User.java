package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")


public class User {
	

	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public User(String userId, String firstName, String surName, Date dob, String address, String contactNo,
			String email, String qualification, String gender, String applyType, String citizenType,
			String hintQuestion, String hintAnswer, String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.surName = surName;
		this.dob = dob;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.qualification = qualification;
		this.gender = gender;
		this.applyType = applyType;
		this.citizenType = citizenType;
		this.hintQuestion = hintQuestion;
		this.hintAnswer = hintAnswer;
		this.password = password;
	}
	


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getSurName() {
		return surName;
	}


	public void setSurName(String surName) {
		this.surName = surName;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getApplyType() {
		return applyType;
	}


	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}


	public String getCitizenType() {
		return citizenType;
	}


	public void setCitizenType(String citizenType) {
		this.citizenType = citizenType;
	}


	public String getHintQuestion() {
		return hintQuestion;
	}


	public void setHintQuestion(String hintQuestion) {
		this.hintQuestion = hintQuestion;
	}


	public String getHintAnswer() {
		return hintAnswer;
	}


	public void setHintAnswer(String hintAnswer) {
		this.hintAnswer = hintAnswer;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	@Id

    

    @Column(name = "User_Id")

    private String userId;

    @Column(name = "First_Name", length = 15)

    private String firstName;

    @Column(name = "Sur_Name", length = 15)

    private String surName;

    @Column(name = "DOB")

    private Date dob;

    @Column(name = "Address", length = 100)

    private String address;

    @Column(name = "Contact_No", length = 20)

    private String contactNo;

    @Column(name = "Email", length = 50)

    private String email;

    @Column(name = "Qualification", length = 25)

    private String qualification;

    @Column(name = "Gender", length = 6)

    private String gender;

    @Column(name = "Apply_Type", length = 8)

    private String applyType;

    @Column(name = "Citizen_Type", length = 15)

    private String citizenType;

    @Column(name = "Hint_Ques", length = 25)

    private String hintQuestion;
    
    @Column(name = "Hint_Ans", length = 25)

    private String hintAnswer;

    @Column(name = "Password", length = 50)

    private String password;

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", surName=" + surName + ", dob=" + dob
				+ ", address=" + address + ", contactNo=" + contactNo + ", email=" + email + ", qualification="
				+ qualification + ", gender=" + gender + ", applyType=" + applyType + ", citizenType=" + citizenType
				+ ", hintQuestion=" + hintQuestion + ", hintAnswer=" + hintAnswer + ", password=" + password + "]";
	}

	
	/*
	 * public Long getUserId() { // TODO Auto-generated method stub return userId; }
	 * 
	 * public String getPassword() { // TODO Auto-generated method stub return
	 * password; }
	 * 
	 * public String getApplyType() { // TODO Auto-generated method stub return
	 * applyType; }
	 * 
	 * public String getCitizenType() { // TODO Auto-generated method stub return
	 * citizenType; }
	 * 
	 * public String address() { // TODO Auto-generated method stub return
	 * address(); }
	 */
    
}

