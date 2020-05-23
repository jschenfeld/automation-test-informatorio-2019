package com.rodrigo.itegrador.dto;

public class UserDto {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String adressFirstName;
	private String adressLastName;
	private String adress;
	private String city;
	private String state;
	private String codePostal;
	private String country;
	private String mobilePhone;
	private String adressAlias;
	private String aditionalInformation;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombreCompleto() {
		return this.firstName + " " + this.lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAdressFirstName() {
		return adressFirstName;
	}
	public void setAdressFirstName(String adressFirstName) {
		this.adressFirstName = adressFirstName;
	}
	public String getAdressLastName() {
		return adressLastName;
	}
	public void setAdressLastName(String adressLastName) {
		this.adressLastName = adressLastName;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getAdressAlias() {
		return adressAlias;
	}
	public void setAdressAlias(String adressAlias) {
		this.adressAlias = adressAlias;
	}
	public String getAditionalInformation() {
		return aditionalInformation;
	}
	public void setAditionalInformation(String aditionalInformation) {
		this.aditionalInformation = aditionalInformation;
	}
	
}
