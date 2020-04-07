package com.mycompany.restful;

import java.io.Serializable;

public class Book implements Serializable {
	private static final long serialVersionUID = 6535788271499457190L;
	private String bookId;
	private String name;
	private java.time.LocalDate publishedDate;
	
	public void setBookId(String id) {
		bookId = id;
	}
	public void setName(String n) {
		name = n;
	}
	public void setPublishedDate(java.time.LocalDate date) {
		publishedDate = date;
	}
	
	public String getBookId() {
		return bookId;
	}
	public String getName() {
		return name;
	}
	public java.time.LocalDate getPublishedDate() {
		return publishedDate;
	}
	
}
