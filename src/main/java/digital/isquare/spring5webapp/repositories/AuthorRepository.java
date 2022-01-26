package digital.isquare.spring5webapp.repositories;

import digital.isquare.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
