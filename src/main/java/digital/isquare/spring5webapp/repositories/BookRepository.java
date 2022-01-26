package digital.isquare.spring5webapp.repositories;

import digital.isquare.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
