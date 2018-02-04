package com.shaibal.elastic.search.service;

import com.shaibal.elastic.search.model.Book;

public interface BookService {

	public void save(Book book);
	
	public Book findOne(String id);
}
