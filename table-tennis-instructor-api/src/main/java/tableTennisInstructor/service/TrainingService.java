package tableTennisInstructor.service;

import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseFact;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseRequestFact;

import java.util.ArrayList;

public interface TrainingService {

    public ArrayList<Training> getAll();

    public Training getById(String id);

    ArrayList<Training> findTrainings(TrainingChooseFact trainingChooseFact,
                                      TrainingChooseRequestFact requestFact);
}
