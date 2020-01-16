package com.everis.service.dto;

import java.util.List;

public class OfferDTO {

	private int id;
	private String title;
	private String description;
	private String status;
	private String publicationDate;
	private int numberOfApplications;
	    
	private List<ApplicationDTO> applicationsDto;
	 
	public OfferDTO() {
	}

	public OfferDTO(int id, String title, String description, String status, String publicationDate,
			int numberOfApplications, List<ApplicationDTO> applicationsDto) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.publicationDate = publicationDate;
		this.numberOfApplications = numberOfApplications;
		this.applicationsDto = applicationsDto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}



	public int getNumberOfApplications() {
		return numberOfApplications;
	}

	public void setNumberOfApplications(int numberOfApplications) {
		this.numberOfApplications = numberOfApplications;
	}

	public List<ApplicationDTO> getApplicationsDto() {
		return applicationsDto;
	}

	public void setApplicationsDto(List<ApplicationDTO> applicationsDto) {
		this.applicationsDto = applicationsDto;
	}

	@Override
	public String toString() {
		return "OfferDTO [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", publicationDate=" + publicationDate + ", numberOfApplications=" + numberOfApplications
				+ ", applicationsDto=" + applicationsDto + "]";
	}


}