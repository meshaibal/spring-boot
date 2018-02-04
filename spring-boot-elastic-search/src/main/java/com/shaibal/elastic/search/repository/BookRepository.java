package com.shaibal.elastic.search.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.shaibal.elastic.search.model.Book;

public interface BookRepository extends ElasticsearchRepository<Book, String>{

}
