package tableTennisInstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tableTennisInstructor.model.drools.facts.training.TrainingDrill;

@Repository
public interface TrainingDrillRepository extends JpaRepository<TrainingDrill, Long> {
}
