package tableTennisInstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tableTennisInstructor.model.drools.facts.UserHealth;

import java.util.Optional;

@Repository
public interface UserHealthRepository extends JpaRepository<UserHealth, Long> {

    Optional<UserHealth> findUserHealthByUserId(Long userId);
}
