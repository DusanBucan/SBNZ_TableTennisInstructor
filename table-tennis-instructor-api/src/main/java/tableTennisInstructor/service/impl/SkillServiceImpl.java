package tableTennisInstructor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.exception.exceptions.ApiRequestException;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.repository.SkillRepository;
import tableTennisInstructor.service.SkillService;
import tableTennisInstructor.service.TrainingExecutionService;
import tableTennisInstructor.service.TrainingService;

import java.util.ArrayList;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private TrainingExecutionService trainingExecutionService;

    @Override
    public Skill findBySkillId(Long skillId) {
        return skillRepository.findBySkillId(skillId)
                .orElseThrow(()-> new ApiRequestException("No skill with id" + skillId));
    }

    @Override
    public ArrayList<Skill> findAll() {
        return (ArrayList<Skill>) skillRepository.findAll();
    }

    @Override
    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public void delete(Long id) {
        Skill skill = this.findBySkillId(id);
        ArrayList<Training> toDeleteTrainings = this.trainingService.findAllBySkill(skill);
        for(Training tr : toDeleteTrainings) {
            this.trainingExecutionService.deleteAllByTraining(tr);
        }
        this.trainingService.deleteAll(toDeleteTrainings);
        skillRepository.delete(skill);
    }
}
