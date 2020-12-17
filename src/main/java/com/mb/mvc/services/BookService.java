package com.mb.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mb.mvc.models.Book;
import com.mb.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// return all books
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	// create a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	// retrieve one book
	public Book  findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else {
			return null;
		}
	}
	
	// delete a book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	public Book updateBook(Book b) {
		return bookRepository.save(b);
	}
}
