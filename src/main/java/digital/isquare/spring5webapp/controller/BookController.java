package digital.isquare.spring5webapp.controller;

import digital.isquare.spring5webapp.domain.Book;
import digital.isquare.spring5webapp.exception.ResourceNotFoundException;
import digital.isquare.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(
            @PathVariable(value = "id") Long bookId) throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found :: " + bookId));
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBooks(
            @PathVariable(value = "id") Long bookId,
            @Valid @RequestBody Book bookDetails) throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found :: " + bookId));

        book.setTitle(bookDetails.getTitle());
        book.setIsbn(bookDetails.getIsbn());
        book.setUpdatedAt(new Date());
        final Book updatedUser = bookRepository.save(book);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/books/{id}")
    public Map<String, Boolean> deleteBook(
            @PathVariable(value = "id") Long bookId) throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found :: " + bookId));

        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("/books/all")
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }
}
