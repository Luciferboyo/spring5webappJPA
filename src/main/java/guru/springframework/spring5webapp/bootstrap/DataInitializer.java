package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author boyo
 */
@Profile({"local","default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse",null);

        System.out.println("Id:" + bookDDD.getId());

        Book saveDDD = bookRepository.save(bookDDD);

        System.out.println("Id:" + saveDDD.getId());

        Book bookSIA = new Book("spring In Action", "2345689", "Oriely",null);
        Book saveSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Title:" + book.getId());
            System.out.println("Book Title:" + book.getTitle());
        });
    }
}
