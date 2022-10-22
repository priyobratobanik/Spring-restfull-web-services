package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Book;

public interface BookDao extends JpaRepository<Book, Integer>{

}
