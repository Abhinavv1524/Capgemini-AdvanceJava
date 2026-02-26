package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.Book;
import repository.BookRepository;

public class BookService {
	
	 private BookRepository bookRepository;
	    private Long idCounter = 1L;

	    public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }

	    public void addBook(String title, String author) {
	        Book book = new Book(idCounter++, title, author);
	        bookRepository.save(book);
	        System.out.println("Book added successfully.");
	    }

	    public List<Book> getAvailableBooks() {
	        return bookRepository.findAll();
	    }

	    public Book getBookById(Long id) {
	        return bookRepository.findById(id);
	    }
}
