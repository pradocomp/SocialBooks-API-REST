package com.librarysocial.socialbooks.domain;

public class DetailsError {
	
	private String Title;
	private Long status;
	private Long timestamp;
	private String messageDeveloper;
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessageDeveloper() {
		return messageDeveloper;
	}
	public void setMessageDeveloper(String messageDeveloper) {
		this.messageDeveloper = messageDeveloper;
	}
	
}
