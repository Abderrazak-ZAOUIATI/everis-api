package com.everis.service.dto;

import java.util.List;
public class UserDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private String address;
	private String type;

	private List<ApplicationDTO> applications;

	private List<ArticleDTO> articles;

	public UserDTO() {
	}

	public UserDTO(int id, String firstName, String lastName, String email, String password, String phoneNumber,
			String address, String type, List<ApplicationDTO> applications, List<ArticleDTO> articles) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.type = type;
		this.applications = applications;
		this.articles = articles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ApplicationDTO> getApplications() {
		return applications;
	}

	public void setApplications(List<ApplicationDTO> applications) {
		this.applications = applications;
	}

	public List<ArticleDTO> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleDTO> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", address=" + address + ", type=" + type
				+ ", applications=" + applications + ", articles=" + articles + "]";
	}

}