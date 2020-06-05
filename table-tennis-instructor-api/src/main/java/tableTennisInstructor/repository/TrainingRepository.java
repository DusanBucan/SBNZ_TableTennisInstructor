package tableTennisInstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingLevel;

import java.util.Collection;
import java.util.Optional;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    Optional<Collection<Training>> findAllBySkillAndTrainingLevel(Skill skill, TrainingLevel trainingLevel);

    Optional<Collection<Training>> findAllBySkill(Skill skill);
 }
