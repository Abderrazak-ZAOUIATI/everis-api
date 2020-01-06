package com.everis.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String applicationDate;
	private String status;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "offerId", referencedColumnName = "id")
	private Offer offer;

	public Application() {
	}

	public Application(int id, String applicationDate, String status, User user, Offer offer) {
		super();
		this.id = id;
		this.applicationDate = applicationDate;
		this.status = status;
		this.user = user;
		this.offer = offer;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", applicationDate=" + applicationDate + ", status=" + status + "]";
	}

}