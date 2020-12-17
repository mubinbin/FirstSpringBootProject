package com.mb.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mb.mvc.models.Book;
import com.mb.mvc.services.BookService;

@RestController
public class BookApi {
	private final BookService bookService;

	public BookApi(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}

	@RequestMapping(value = "/api/books", method = RequestMethod.POST)
	public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
			@RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numberOfPages) {
		Book newBook = new Book(title, desc, lang, numberOfPages);
		return bookService.createBook(newBook);
	}

	@RequestMapping("/api/books/{id}")
	public Book showOneBook(@PathVariable("id") Long id) {
		Book theBook = bookService.findBook(id);
		return theBook;
	}
	
	@RequestMapping(value="/api/books/{id}", method = RequestMethod.DELETE)
	public Book deleteOneBook(@PathVariable("id") Long id) {
		Book bookToDelete = bookService.findBook(id);
		bookService.deleteBook(id);
		return bookToDelete;
	}
	
	@RequestMapping(value="/api/books/{id}", method = RequestMethod.PUT)
	public Book upateOneBook(@PathVariable("id") Long id, @RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
			@RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numberOfPages) {
		Book bookToUpdate = bookService.findBook(id);
		bookToUpdate.setDescription(desc);
		bookToUpdate.setLanguage(lang);
		bookToUpdate.setNumberOfPages(numberOfPages);
		bookToUpdate.setTitle(title);
		return bookService.updateBook(bookToUpdate);
	}
}
