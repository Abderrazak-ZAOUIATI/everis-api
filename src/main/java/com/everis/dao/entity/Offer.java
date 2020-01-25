package com.everis.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String description;
	private String status;
	private String publicationDate;
	private int numberOfApplications;

	@OneToMany(mappedBy = "offer", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Application> applications;

	public Offer() {
	}

	public Offer(int id, String title, String description, String status, String publicationDate,
			int numberOfApplications, List<Application> applications) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.publicationDate = publicationDate;
		this.numberOfApplications = numberOfApplications;
		this.applications = applications;
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

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", publicationDate=" + publicationDate + ", numberOfApplications=" + numberOfApplications + "]";
	}

}