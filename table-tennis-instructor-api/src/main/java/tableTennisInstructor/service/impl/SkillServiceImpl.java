package tableTennisInstructor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.exception.exceptions.ApiRequestException;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.repository.SkillRepository;
import tableTennisInstructor.service.SkillService;

import java.util.ArrayList;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public Skill findBySkillId(Long skillId) {
        return skillRepository.findBySkillId(skillId)
                .orElseThrow(()-> new ApiRequestException("No skill with id" + skillId));
    }

    @Override
    public ArrayList<Skill> findAll() {
        return (ArrayList<Skill>) skillRepository.findAll();
    }
}
