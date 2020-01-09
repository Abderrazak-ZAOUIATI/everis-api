package com.everis.service.dto;

public class ApplicationDTO {

	private int id;
	private String applicationDate;
	private String status;

	private UserDTO userDto;

	private OfferDTO offerDto;

	public ApplicationDTO() {
	}

	public ApplicationDTO(int id, String applicationDate, String status, UserDTO userDto, OfferDTO offerDto) {
		super();
		this.id = id;
		this.applicationDate = applicationDate;
		this.status = status;
		this.userDto = userDto;
		this.offerDto = offerDto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

	public OfferDTO getOfferDto() {
		return offerDto;
	}

	public void setOfferDto(OfferDTO offerDto) {
		this.offerDto = offerDto;
	}

	@Override
	public String toString() {
		return "ApplicationDTO [id=" + id + ", applicationDate=" + applicationDate + ", status=" + status + ", userDto="
				+ userDto + ", offerDto=" + offerDto + "]";
	}

	
}