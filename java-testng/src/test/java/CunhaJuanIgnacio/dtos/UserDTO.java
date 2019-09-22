package CunhaJuanIgnacio.dtos;

import org.apache.commons.lang3.RandomStringUtils;

public class UserDTO {
	
	private String mail;
	
	private String gender;
	private String name;
	private String lastName;
	private String password;
	
	private Integer birthDay;
	private Integer birthMonth;
	private Integer birthYear;
	
	
	private String adressCompany;
	private String adress1;
	private String adress2;
	private String city;
	private String state;
	
	private Integer postalCode;
	private String country;
	private String additionalInfo;
	private Integer homePhone;
	private Integer mobilePhone;
	private String addresFutureReference;
	
	
	public UserDTO() {
		this.mail = RandomStringUtils.randomAlphabetic(3) + "@" + RandomStringUtils.randomAlphabetic(3) + ".com";
		this.password = RandomStringUtils.randomAlphabetic(5);

	}


	public UserDTO(String gender, String name, String lastName, String password, Integer birthDay,
			Integer birthMonth, Integer birthYear, String adressCompany,
			String adress1, String adress2, String city, String state, Integer postalCode, String country,
			String additionalInfo, Integer homePhone, Integer mobilePhone, String addresFutureReference) {
		super();
		this.mail = RandomStringUtils.randomAlphabetic(3) + "@" + RandomStringUtils.randomAlphabetic(3) + ".com";
		this.gender = gender;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.adressCompany = adressCompany;
		this.adress1 = adress1;
		this.adress2 = adress2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.additionalInfo = additionalInfo;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.addresFutureReference = addresFutureReference;
	}
	
	


	public UserDTO(String mail, String gender, String name, String lastName, String password, Integer birthDay,
			Integer birthMonth, Integer birthYear, String adressCompany,
			String adress1, String adress2, String city, String state, Integer postalCode, String country,
			String additionalInfo, Integer homePhone, Integer mobilePhone, String addresFutureReference) {
		super();
		this.mail = mail;
		this.gender = gender;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;		
		this.adressCompany = adressCompany;
		this.adress1 = adress1;
		this.adress2 = adress2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.additionalInfo = additionalInfo;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.addresFutureReference = addresFutureReference;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getBirthDay() {
		return birthDay;
	}


	public void setBirthDay(Integer birthDay) {
		this.birthDay = birthDay;
	}


	public Integer getBirthMonth() {
		return birthMonth;
	}


	public void setBirthMonth(Integer birthMonth) {
		this.birthMonth = birthMonth;
	}


	public Integer getBirthYear() {
		return birthYear;
	}


	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}	


	public String getAdressCompany() {
		return adressCompany;
	}


	public void setAdressCompany(String adressCompany) {
		this.adressCompany = adressCompany;
	}


	public String getAdress1() {
		return adress1;
	}


	public void setAdress1(String adress1) {
		this.adress1 = adress1;
	}


	public String getAdress2() {
		return adress2;
	}


	public void setAdress2(String adress2) {
		this.adress2 = adress2;
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


	public Integer getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getAdditionalInfo() {
		return additionalInfo;
	}


	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}


	public Integer getHomePhone() {
		return homePhone;
	}


	public void setHomePhone(Integer homePhone) {
		this.homePhone = homePhone;
	}


	public Integer getMobilePhone() {
		return mobilePhone;
	}


	public void setMobilePhone(Integer mobilePhone) {
		this.mobilePhone = mobilePhone;
	}


	public String getAddresFutureReference() {
		return addresFutureReference;
	}


	public void setAddresFutureReference(String addresFutureReference) {
		this.addresFutureReference = addresFutureReference;
	}


	@Override
	public String toString() {
		return "UserDTO [mail=" + mail + ", gender=" + gender + ", name=" + name + ", lastName=" + lastName
				+ ", password=" + password + ", birthDay=" + birthDay + ", birthMonth=" + birthMonth + ", birthYear="
				+ birthYear	+ ", adressCompany=" + adressCompany + ", adress1=" + adress1 + ", adress2=" + adress2 + ", city="
				+ city + ", state=" + state + ", postalCode=" + postalCode + ", country=" + country
				+ ", additionalInfo=" + additionalInfo + ", homePhone=" + homePhone + ", mobilePhone=" + mobilePhone
				+ ", addresFutureReference=" + addresFutureReference + "]";
	}
	
	
	
	
	
}
