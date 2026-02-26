package main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import resources.AppConfig;
import service.BookService;
import service.LibraryService;
import service.MemberService;

public class LibraryApplication {
	public static void main(String[] args) {
	
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		BookService bookService = context.getBean(BookService.class);
		MemberService memberService = context.getBean(MemberService.class);
		LibraryService libraryService = context.getBean(LibraryService.class);
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
		
			System.out.println("\n1.Register Member");
			System.out.println("2.Add Book");
			System.out.println("3.Issue Book");
			System.out.println("4.Return Book");
			System.out.println("5.View Books");
			System.out.println("6.Exit");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			
				case 1:
					System.out.print("Name: ");
					String name = sc.nextLine();
					System.out.print("Email: ");
					String email = sc.nextLine();
					memberService.registerMember(name, email);
					break;
				
				case 2:
					System.out.print("Title: ");
					String title = sc.nextLine();
					System.out.print("Author: ");
					String author = sc.nextLine();
					bookService.addBook(title, author);
					break;
				
				case 3:
					System.out.print("Member ID: ");
					Long mId = sc.nextLong();
					System.out.print("Book ID: ");
					Long bId = sc.nextLong();
					libraryService.issueBook(mId, bId);
					break;
				
				case 4:
					System.out.print("Member ID: ");
					Long mId2 = sc.nextLong();
					System.out.print("Book ID: ");
					Long bId2 = sc.nextLong();
					libraryService.returnBook(mId2, bId2);
					break;
				
				case 6:
					System.out.println("Thank You");
					System.exit(0);
			}
		}
	}
}
