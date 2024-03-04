package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;	

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");

			Category category0 = new Category("Fiction");
			Category category1 = new Category("Non-fiction");
			Category category2 = new Category("Mystery");
			Category category3 = new Category("Thriller");
			Category category4 = new Category("Science fiction");
			Category category5 = new Category("Historical fiction");
			Category category6 = new Category("Fantasy");
			Category category7 = new Category("Romance");
			
			crepository.save(category0);
			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);
			crepository.save(category4);
			crepository.save(category5);
			crepository.save(category6);
			crepository.save(category7);

			brepository.save(new Book("Our Mutual Friend", "Charles Dickens", 1865, "9780140434972", 12.99, category0));
			brepository.save(new Book("Of Mice and Men", "John Steinbeck", 1937, "9780140177398", 9.99, category0));
			brepository.save(new Book("Catch-22", "Joseph Heller", 1961, "9780099496960", 11.99, category5));	
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
