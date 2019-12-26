package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Book;
import com.luv2code.springboot.cruddemo.entity.Page;

public interface PageRepository extends JpaRepository<Page, Long> {

	List<Page> findByBook(Book book, Sort sort);
	
}
