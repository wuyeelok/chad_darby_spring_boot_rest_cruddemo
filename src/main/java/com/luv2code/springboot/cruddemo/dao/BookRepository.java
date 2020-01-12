package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	// Not case sensitive
	Book findByIsbn(String isbn);

	List<Book> findByIsbnContaining(String isbn);

}
