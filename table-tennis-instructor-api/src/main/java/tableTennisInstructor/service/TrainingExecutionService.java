package tableTennisInstructor.service;

import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;

import java.util.ArrayList;

public interface TrainingExecutionService  {

    ArrayList<TrainingExecution> findByUserId(Long userId);

    ArrayList<TrainingExecution> findAllByTraining(Training training);

    void deleteAllByTraining(Training tr);
}
