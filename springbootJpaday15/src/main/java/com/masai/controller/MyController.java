package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BookNotFoundException;
import com.masai.model.Book;
import com.masai.service.BookService;

@RestController
public class MyController {

	@Autowired
	private BookService bs;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBookHandler() throws BookNotFoundException{
		
		List<Book> books =bs.getAllbooks();
		
		return new ResponseEntity<List<Book>> (books,HttpStatus.OK); 
	}
	
	@GetMapping("/books/{bid}")
	public ResponseEntity<Book> getBookbyIdHandler( @PathVariable("bid") Integer bookId) throws BookNotFoundException{
		
		Book b =bs.getBookbyId(bookId);
		return new ResponseEntity<Book> (b,HttpStatus.OK);
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> registerBookHandler(@RequestBody Book book){
		
		Book b =bs.registerBook(book);
		return new ResponseEntity<Book> (b,HttpStatus.CREATED);
	}
	@DeleteMapping("/books/{bid}")
	public ResponseEntity<Book> deleteBookbyIdHandler( @PathVariable("bid") Integer bookId) throws BookNotFoundException{
		
		Book b =bs.deletebookById(bookId);
		return new ResponseEntity<Book> (b,HttpStatus.ACCEPTED);
	}	
	
	@PutMapping("/books")
	public ResponseEntity<Book> updateBookHandler(@RequestBody Book book) throws BookNotFoundException{
		
		Book b =bs.updateBook(book);
		return new ResponseEntity<Book> (b,HttpStatus.CREATED);
	}
	
}
