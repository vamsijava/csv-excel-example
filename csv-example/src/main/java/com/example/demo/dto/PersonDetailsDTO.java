package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import lombok.Data;
/**
 * 
 * @author vamsir
 *
 */
public class PersonDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int personId;
	private String personName;
	private int personAge;
	private String phoneNumber;
	private String personEmail;
	private String state;
	private String country;
	private String pinCode;
	private String postOffice;
	private String doorNumber;
	private String mandal;
	private String city;
	private Date createDate;
	private Date modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private Boolean active;
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "PersonDetailsDTO [personId=" + personId + ", personName=" + personName + ", personAge=" + personAge
				+ ", phoneNumber=" + phoneNumber + ", personEmail=" + personEmail + ", state=" + state + ", country="
				+ country + ", pinCode=" + pinCode + ", postOffice=" + postOffice + ", doorNumber=" + doorNumber
				+ ", mandal=" + mandal + ", city=" + city + ", createDate=" + createDate + ", modifiedDate="
				+ modifiedDate + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", active=" + active + "]";
	}
	
}
