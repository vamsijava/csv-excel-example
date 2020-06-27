package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.common.AuditModel;

/*
 * @Auther 
 * V@M$I
 */

@Entity
@Table(name = "person_details")
public class PersonDetails extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private int personId;

	@Column(name = "person_name", length = 1024, nullable = false)
	private String personName;

	@Column(name = "person_age", nullable = false)
	private int personAge;

	@Column(name = "phone_number", length = 15, nullable = false)
	private String phoneNumber;

	@Column(name = "person_email", length = 256, nullable = false)
	private String personEmail;

	@Column(name = "person_state", length = 256, nullable = false)
	private String state;

	@Column(name = "country", length = 256, nullable = false)
	private String country;

	@Column(name = "pin_code", length = 10, nullable = false)
	private String pinCode;

	@Column(name = "post_office", length = 256, nullable = false)
	private String postOffice;

	@Column(name = "door_number", length = 256, nullable = false)
	private String doorNumber;

	@Column(name = "mandal", length = 256, nullable = false)
	private String mandal;

	@Column(name = "city", length = 256, nullable = false)
	private String city;

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

	@Override
	public String toString() {
		return "PersonDetails [personId=" + personId + ", personName=" + personName + ", personAge=" + personAge
				+ ", phoneNumber=" + phoneNumber + ", personEmail=" + personEmail + ", state=" + state + ", country="
				+ country + ", pinCode=" + pinCode + ", postOffice=" + postOffice + ", doorNumber=" + doorNumber
				+ ", mandal=" + mandal + ", city=" + city + "]";
	}

}
