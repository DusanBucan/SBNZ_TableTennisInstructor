package tableTennisInstructor.service;

import tableTennisInstructor.dto.request.TrainingHistorySearchDTO;
import tableTennisInstructor.model.User;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.model.drools.facts.training.TrainingMistake;

import java.util.ArrayList;

public interface TrainingExecutionService  {

    ArrayList<TrainingExecution> findByUserId(Long userId);

    ArrayList<TrainingExecution> findAllByTraining(Training training);

    void deleteAllByTraining(Training tr);

    TrainingExecution startTraining(Training tr, User user);

    TrainingExecution saveTrainingExecution(TrainingExecution trainingExecution);

}
