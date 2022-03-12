package digital.isquare.spring5webapp.repositories;

import digital.isquare.spring5webapp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
