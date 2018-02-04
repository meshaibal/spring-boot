package com.shaibal.elastic.search.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaibal.elastic.search.model.Book;
import com.shaibal.elastic.search.repository.BookRepository;
import com.shaibal.elastic.search.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;

	@Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public void save(Book book) {
		bookRepository.save(book);
	}
	
	public Book findOne(String id) {
		return bookRepository.findOne(id);
	}
	
	
}
