package com.everis.service.dto;

public class ArticleDTO {

	private int id;
	private String title;
	private String content;
	private String image;
	private String publicationDate;
	private String status;

	private UserDTO userDto;

	public ArticleDTO() {
	}

	public ArticleDTO(int id, String title, String content, String image, String publicationDate, String status,
			UserDTO userDto) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.image = image;
		this.publicationDate = publicationDate;
		this.status = status;
		this.userDto = userDto;
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

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

	@Override
	public String toString() {
		return "ArticleDTO [id=" + id + ", title=" + title + ", content=" + content + ", image=" + image
				+ ", publicationDate=" + publicationDate + ", status=" + status + ", userDto=" + userDto + "]";
	}

}