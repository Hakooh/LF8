package LF8.application.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestivalEntityRepository extends JpaRepository<FestivalEntity, Long> {

}
