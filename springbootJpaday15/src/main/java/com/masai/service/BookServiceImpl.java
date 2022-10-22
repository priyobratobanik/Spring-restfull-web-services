package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BookNotFoundException;

import com.masai.model.Book;

import com.masai.repository.BookDao;


@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao dao;

	@Override
	public List<Book> getAllbooks() throws BookNotFoundException {
		
		List<Book> allBooks =dao.findAll();
		
		
		return allBooks;
	}

	@Override
	public Book getBookbyId(Integer bookId) throws BookNotFoundException {
		
		return dao.findById(bookId).orElseThrow( () -> new BookNotFoundException("book not found by id"));
//		return bookbyid;
	}

	@Override
	public Book registerBook(Book b) {
		
		return dao.save(b);
	}

	@Override
	public Book deletebookById(Integer bookId) throws BookNotFoundException {
	
		 
		 Book exist =dao.findById(bookId).orElseThrow( () -> new BookNotFoundException("book not found by id"));
		 dao.delete(exist);
		 
		 return exist;
	}

	@Override
	public Book updateBook(Book b) throws BookNotFoundException {
		
        Optional<Book> opt=dao.findById(b.getBookId());
		
		if(opt.isPresent()) {
			return dao.save(b);
		}
		else{
			throw new BookNotFoundException("Invalid product Deatils");
		}
	}

	
	
}
