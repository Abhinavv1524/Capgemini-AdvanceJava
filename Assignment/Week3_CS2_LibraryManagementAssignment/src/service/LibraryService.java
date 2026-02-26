package service;

import model.Book;
import model.Member;

public class LibraryService {
	private BookService bookService;
    private MemberService memberService;

    public LibraryService(BookService bookService, MemberService memberService) {
        this.bookService = bookService;
        this.memberService = memberService;
    }

    public void issueBook(Long memberId, Long bookId) {

        Member member = memberService.getMemberById(memberId);
        Book book = bookService.getBookById(bookId);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (book == null || !book.isAvailable()) {
            System.out.println("Book not available.");
            return;
        }

        book.setAvailable(false);
        System.out.println("Book issued successfully.");
    }

    public void returnBook(Long memberId, Long bookId) {

        Book book = bookService.getBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        book.setAvailable(true);
        System.out.println("Book returned successfully.");
    }
}
