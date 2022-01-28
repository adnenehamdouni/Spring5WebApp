package digital.isquare.spring5webapp.repositories;

import digital.isquare.spring5webapp.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("authorRepository")
public interface AuthorRepository extends JpaRepository<Author, Long> {


}
