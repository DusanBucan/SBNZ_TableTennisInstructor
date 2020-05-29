package tableTennisInstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tableTennisInstructor.model.drools.facts.skill.Skill;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    Optional<Skill> findBySkillId(Long skillId);
}
