package com.shaibal.elastic.search.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shaibal.elastic.search.model.Book;
import com.shaibal.elastic.search.service.BookService;

@SpringBootApplication(scanBasePackages = "com.shaibal.elastic.search")
public class SpringBootConfiguration implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	
	@Override
	public void run(String... arg0) throws Exception {
		bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
        bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
        bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));
		
        System.out.println(bookService.findOne("1001").getAuthor());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfiguration.class, args);
	}
}
