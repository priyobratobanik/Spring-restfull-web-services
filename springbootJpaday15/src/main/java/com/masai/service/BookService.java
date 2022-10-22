package com.masai.service;

import java.util.List;

import com.masai.exception.BookNotFoundException;
import com.masai.model.Book;

public interface BookService {

	
	public List<Book> getAllbooks()throws BookNotFoundException;
	
	public Book getBookbyId(Integer bookId) throws BookNotFoundException;
	
	public Book registerBook(Book b);
	
	public Book deletebookById(Integer bookId) throws BookNotFoundException;
	
	public Book updateBook(Book b) throws BookNotFoundException;
}
