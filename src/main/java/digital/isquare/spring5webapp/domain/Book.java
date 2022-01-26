package digital.isquare.spring5webapp.domain;

import java.util.Set;

public class Book {

    private String title;
    private String isbn;
    private Set<Author> authors;

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, String isbn, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
