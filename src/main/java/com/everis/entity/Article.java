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
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String content;
	private String image;
	private String publicationDate;
	private String status;
	    
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="userId",referencedColumnName = "id")
	private User user;
	  
	public Article() {
	}

	public Article(int id, String title, String content, String image, String publicationDate, String status,
			User user) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.image = image;
		this.publicationDate = publicationDate;
		this.status = status;
		this.user = user;
	}

	public Article(String title, String content, String image, String publicationDate, String status, User user) {
		super();
		this.title = title;
		this.content = content;
		this.image = image;
		this.publicationDate = publicationDate;
		this.status = status;
		this.user = user;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
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

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", image=" + image
				+ ", publicationDate=" + publicationDate + ", status=" + status + "]";
	}    
  
}