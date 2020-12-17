package com.mb.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mb.mvc.models.Book;
import com.mb.mvc.services.BookService;


@Controller
public class BookController {
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/books")
	public String index(Model model){
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/books/new.jsp";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) return "/books/new.jsp";
		
		bookService.createBook(book);
		return "redirect:/books";
	}
	
	@RequestMapping("/books/{id}")
	public String bookDetail(@PathVariable("id") Long id, Model model) {
		Book currentBook = bookService.findBook(id);
		model.addAttribute("currentBook", currentBook);
		return "/books/show.jsp";
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
	@RequestMapping("/books/edit/{id}")
	public String editPage(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "/books/edit.jsp";
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	public String edit(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) return "/books/edit.jsp";
		
		bookService.updateBook(book);
		return "redirect:/books/"+id;
	}
	
}
