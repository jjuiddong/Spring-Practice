package com.mycompany.restful;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("books")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BookService bookService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "{bookId}", method = RequestMethod.GET)
	public @ResponseBody List<BookResource> home( @PathVariable String bookId) {

		logger.info("Welcome home! bookId=" + bookId);
		
		//Book book = bookService.find(bookId);
		Book book = new Book();
		book.setBookId("9791158390747");
		//book.setName("book name");
		book.setName("슬랙으로 협업하기");
		book.setPublishedDate(LocalDate.of(2020, 4, 7));
		
		List<BookResource> lst = new ArrayList<BookResource>();
		BookResource resource = new BookResource();
		resource.setBookId(book.getBookId());
		resource.setName(book.getName());
		resource.setPublishedDate(book.getPublishedDate());
		lst.add(resource);
		return lst;
	}
	
}
