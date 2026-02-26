package repository;

import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookRepository {
	private List<Book> books = new ArrayList<>();
	
	public void save(Book book) {
		books.add(book);
	}

    public List<Book> findAll() {
        return books;
    }

    public Book findById(Long id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }	
}
