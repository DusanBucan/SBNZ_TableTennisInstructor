package tableTennisInstructor.service.impl;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.dto.request.TrainingHistorySearchDTO;
import tableTennisInstructor.exception.exceptions.ApiRequestException;
import tableTennisInstructor.model.User;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.model.drools.facts.training.TrainingMark;
import tableTennisInstructor.repository.TrainingExecutionRepository;
import tableTennisInstructor.service.KieSessionService;
import tableTennisInstructor.service.TrainingExecutionService;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TrainingExecutionServiceImpl implements TrainingExecutionService {


    @Autowired
    private TrainingExecutionRepository trainingExecutionRepository;

    @Override
    public ArrayList<TrainingExecution> findByUserId(Long userId) {
        return (ArrayList<TrainingExecution>) trainingExecutionRepository.findAllByUserId(userId)
                .orElseThrow(()-> new ApiRequestException("No Training history for user with id: " + userId));
    }

    @Override
    public ArrayList<TrainingExecution> findAllByTraining(Training training) {
        return (ArrayList<TrainingExecution>) trainingExecutionRepository.findAllByTraining(training);
    }

    @Override
    public void deleteAllByTraining(Training tr) {
        ArrayList<TrainingExecution> toDeleteExecutions = this.findAllByTraining(tr);
        this.trainingExecutionRepository.deleteAll(toDeleteExecutions);
    }

    @Override
    public TrainingExecution startTraining(Training tr, User user) {
        TrainingExecution trainingExecution = new TrainingExecution();
        trainingExecution.setTrainingMark(TrainingMark.UNKNOWN);
        trainingExecution.setTraining(tr);
        trainingExecution.setDate(new Date());
        trainingExecution.setUser(user);
        return  this.trainingExecutionRepository.save(trainingExecution);
    }

    @Override
    public TrainingExecution saveTrainingExecution(TrainingExecution trainingExecution) {
        return this.trainingExecutionRepository.save(trainingExecution);
    }
}
