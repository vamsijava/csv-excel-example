package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import com.opencsv.bean.CsvBindByName;

public class PersonDetailsCSV implements Serializable {

	private static final long serialVersionUID = 1L;
	@CsvBindByName(column = "Person Name")
	private String personName;
	@CsvBindByName(column = "Person Age")
	private int personAge;
	@CsvBindByName(column = "Phone Number")
	private String phoneNumber;
	@CsvBindByName(column = "Person Email")
	private String personEmail;
	@CsvBindByName(column = "State")
	private String state;
	@CsvBindByName(column = "Country")
	private String country;
	@CsvBindByName(column = "Pin Code")
	private String pinCode;
	@CsvBindByName(column = "Post Office")
	private String postOffice;
	@CsvBindByName(column = "Door Number")
	private String doorNumber;
	@CsvBindByName(column = "Mandal")
	private String mandal;
	@CsvBindByName(column = "City")
	private String city;
	@CsvBindByName(column = "Create Date")
	private String createDate;
	@CsvBindByName(column = "Created By")
	private String createdBy;
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPersonEmail() {
		return personEmail;
	}
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getPostOffice() {
		return postOffice;
	}
	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}
	public String getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getMandal() {
		return mandal;
	}
	public void setMandal(String mandal) {
		this.mandal = mandal;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Override
	public String toString() {
		return "PersonDetailsCSV [personName=" + personName + ", personAge=" + personAge + ", phoneNumber="
				+ phoneNumber + ", personEmail=" + personEmail + ", state=" + state + ", country=" + country
				+ ", pinCode=" + pinCode + ", postOffice=" + postOffice + ", doorNumber=" + doorNumber + ", mandal="
				+ mandal + ", city=" + city + ", createDate=" + createDate + ", createdBy=" + createdBy + "]";
	}

}
