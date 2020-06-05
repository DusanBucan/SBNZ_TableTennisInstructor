package tableTennisInstructor.service;

import tableTennisInstructor.model.drools.facts.skill.Skill;

import java.util.ArrayList;

public interface SkillService {

    Skill findBySkillId(Long skillId);

    ArrayList<Skill> findAll();

    Skill addSkill(Skill skill);

    void delete(Long id);
}
