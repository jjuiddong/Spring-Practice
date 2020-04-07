package com.mycompany.restful;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class BookService {
	private final Map<String, Book> bookRepository = new ConcurrentHashMap<String, Book>();
	
	@PostConstruct
	public void loadDummyData()
	{
		Book book = new Book();
		book.setBookId("9791158390747");
		book.setName("�������� �����ϱ�");
		book.setPublishedDate(LocalDate.of(2020, 4, 7));
		bookRepository.put(book.getBookId(), book);		
	}
	
	public Book find(String bookId) 
	{
		Book book = bookRepository.get(bookId);
		return book;
	}

}
