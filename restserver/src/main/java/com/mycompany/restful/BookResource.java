package com.mycompany.restful;

import java.io.Serializable;
import javax.persistence.Entity;


@Entity
public class BookResource implements Serializable {

	private static final long serialVersionUID = 686774175556365789L;
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
