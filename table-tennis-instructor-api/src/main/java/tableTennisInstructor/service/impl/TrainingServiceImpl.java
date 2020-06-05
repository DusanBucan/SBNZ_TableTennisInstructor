package tableTennisInstructor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.exception.exceptions.ApiRequestException;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.training.*;
import tableTennisInstructor.repository.TrainingDrillRepository;
import tableTennisInstructor.repository.TrainingMistakeRepository;
import tableTennisInstructor.repository.TrainingRepository;
import tableTennisInstructor.service.TrainingExecutionService;
import tableTennisInstructor.service.TrainingService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private TrainingExecutionService trainingExecutionService;

    @Autowired
    private TrainingDrillRepository trainingDrillRepository;

    @Autowired
    private TrainingMistakeRepository  trainingMistakeRepository;

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

    @Override
    public ArrayList<Training> findAllBySkill(Skill skill) {
        ArrayList<Training> retVal = new ArrayList<>();
        Optional<Collection<Training>> opt = this.trainingRepository.findAllBySkill(skill);
        if (opt.isPresent()) {
            retVal = (ArrayList<Training>) opt.get();
        }
        return retVal;
    }

    @Override
    public void deleteAll(ArrayList<Training> toDeleteTrainings) {
        this.trainingRepository.deleteAll(toDeleteTrainings);
    }

    @Override
    public void deleteById(Long id) {
        this.trainingRepository.deleteById(id);
    }

    @Override
    public void delete(Training tr) {
        this.trainingExecutionService.deleteAllByTraining(tr);
        this.trainingRepository.delete(tr);
    }

    @Override
    public Training add(Training training) {
        for(int i=0; i < training.getDrills().size(); i++) {
            TrainingDrill savedDrill = this.trainingDrillRepository.save(training.getDrills().get(i));
            training.getDrills().set(i, savedDrill);
        }
        for(int i=0; i < training.getMostCommonMistakes().size(); i++) {
            TrainingMistake savedMistake = this.trainingMistakeRepository.save(training.getMostCommonMistakes().get(i));
            training.getMostCommonMistakes().set(i, savedMistake);
        }
        return this.trainingRepository.save(training);
    }


}
