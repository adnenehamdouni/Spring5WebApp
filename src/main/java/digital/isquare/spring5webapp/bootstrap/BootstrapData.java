package digital.isquare.spring5webapp.bootstrap;

import digital.isquare.spring5webapp.domain.Author;
import digital.isquare.spring5webapp.domain.Book;
import digital.isquare.spring5webapp.repositories.AuthorRepository;
import digital.isquare.spring5webapp.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    private Environment environment;

    @Value("${spring.profiles.active:}")
    private String activeProfiles;

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        getActiveProfilesFromEnvironment();
        getActiveProfiles();

        Book ddd = new Book("Domain Driven Design", "123123");
        Author eric = new Author("Eric", "Evans");
        ddd.getAuthors().add(eric);
        eric.getBooks().add(ddd);

        bookRepository.save(ddd);
        authorRepository.save(eric);

        Book noEJB = new Book("J2EE without EJB", "145145");
        Author rod = new Author("Rod", "Johnson");
        noEJB.getAuthors().add(eric);
        rod.getBooks().add(ddd);

        //bookRepository.save(noEJB);
        //authorRepository.save(rod);

        log.info("Started in BootStrap Data");
        log.info("Number of books = {}", bookRepository.count());

        Long id = 1L;
        Book findBook = bookRepository.getById(id);
        //log.info("book = {}", findBook.toString());

    }

    public void getActiveProfilesFromEnvironment() {
        for (String profileName : environment.getActiveProfiles()) {
            log.info("Currently active profile - {}",profileName);
        }
    }

    public void getActiveProfiles() {
        for (String profileName : activeProfiles.split(",")) {
            log.info("Currently active profile - {}",profileName);
        }
    }
}
