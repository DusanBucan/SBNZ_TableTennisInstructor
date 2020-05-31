package tableTennisInstructor.service;

import tableTennisInstructor.model.drools.facts.training.TrainingExecution;

import java.util.ArrayList;

public interface TrainingExecutionService  {

    ArrayList<TrainingExecution> findByUserId(Long userId);
}
