package model;

public class Book {
	private long id;
	private String title;
	private String author;
	private boolean available;
	
	public Book(long id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.available = true;
	}
	
	public Long getId() { 
		return id;
	}
	public String getTitle() { 
		return title;
	}
	public String getAuthor() { 
		return author;
	}

	public boolean isAvailable() { 
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available; 
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", available=" + available + "]";
	}
	
	
}
