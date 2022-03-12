package digital.isquare.spring5webapp.repositories;

import digital.isquare.spring5webapp.domain.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, Integer>{
}
