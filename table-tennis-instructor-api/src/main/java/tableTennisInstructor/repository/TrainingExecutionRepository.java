package tableTennisInstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;

import java.util.Collection;
import java.util.Optional;

public interface TrainingExecutionRepository extends JpaRepository<TrainingExecution, Long> {

    Optional<Collection<TrainingExecution>> findAllByUserId(Long userId);

    Collection<TrainingExecution> findAllByTraining(Training training);
}
