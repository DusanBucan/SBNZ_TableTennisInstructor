package tableTennisInstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tableTennisInstructor.model.drools.facts.training.TrainingMistake;

@Repository
public interface TrainingMistakeRepository extends JpaRepository<TrainingMistake, Long> {
}
