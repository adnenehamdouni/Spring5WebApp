package digital.isquare.spring5webapp.repositories;

import digital.isquare.spring5webapp.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer>{
}
