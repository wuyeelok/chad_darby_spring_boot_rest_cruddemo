package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Book findByIsbn(String isbn);

}
