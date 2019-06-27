package kuklinski.spaceflights.repositories;

import kuklinski.spaceflights.domain.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository extends JpaRepository<Tourist, Long> {

}
