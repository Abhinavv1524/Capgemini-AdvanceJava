package resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import repository.BookRepository;
import repository.MemberRepository;
import service.BookService;
import service.LibraryService;
import service.MemberService;

@Configuration
public class AppConfig {
	@Bean
    public BookRepository bookRepository() {
       return new BookRepository();
    }

    @Bean
    public MemberRepository memberRepository() {
       return new MemberRepository();
    }

    @Bean
    public BookService bookService() {
       return new BookService(bookRepository());
    }

    @Bean
    public MemberService memberService() {
       return new MemberService(memberRepository());
    }

    @Bean
    public LibraryService libraryService() {
       return new LibraryService(bookService(), memberService());
    }

}
