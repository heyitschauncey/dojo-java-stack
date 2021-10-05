package com.saconverse.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saconverse.mvc.models.Book;
import com.saconverse.mvc.services.BookService;

@RestController
public class BookApi {
	public final BookService bServ;
	
	public BookApi(BookService serv) {
		this.bServ = serv;
	}

	@GetMapping("/api/books")
	public List<Book> getAllBooks() {
		List<Book> allBooks = bServ.getAll();
		
		return allBooks;
		
//		return bServ.getAll();
	}
	
	@PostMapping("/api/books/create")
	public Book createBook(
		@RequestParam("title") String title,
		@RequestParam("description") String description,
		@RequestParam("language") String language,
		@RequestParam("numberOfPages") Integer numberOfPages
	) {
		Book book = new Book(title, description, language, numberOfPages);
		
		return bServ.create(book);
	}
	
	@GetMapping("/api/books/{id}")
	public Book getOneBook(@PathVariable("id") Long id) {
		return bServ.getOne(id);
	}
}











