package tableTennisInstructor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.exception.exceptions.ApiRequestException;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseFact;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseRequestFact;
import tableTennisInstructor.model.drools.facts.training.TrainingLevel;
import tableTennisInstructor.repository.TrainingRepository;
import tableTennisInstructor.service.TrainingService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public ArrayList<Training> getAll()
    {
        return (ArrayList<Training>) this.trainingRepository.findAll();
    }

    @Override
    public Training getById(String id)
    {
        return this.trainingRepository.findById(Long.parseLong(id))
                .orElseThrow(()-> new ApiRequestException("training with doesn't exists with id: " + id ));
    }

    @Override
    public ArrayList<Training> findTrainings(TrainingChooseFact trainingChooseFact,
                                             TrainingChooseRequestFact requestFact) {

        ArrayList<Training> retVal = new ArrayList<>();
        TrainingLevel level = trainingChooseFact.getChoosenLevel();
        Skill skill = requestFact.getDesiredSkill();
        Optional<Collection<Training>> opt = this.trainingRepository.findAllBySkillAndTrainingLevel(skill, level);
        if (opt.isPresent()) {
            retVal = (ArrayList<Training>) opt.get();
        }
        return retVal;
    }
}
