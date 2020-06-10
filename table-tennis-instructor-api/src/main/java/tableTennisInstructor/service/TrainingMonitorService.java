package tableTennisInstructor.service;

import tableTennisInstructor.dto.request.SimulateTrainingDTO;
import tableTennisInstructor.model.drools.events.SkillExecutionEvent;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;

import java.util.ArrayList;

public interface TrainingMonitorService {

    void simulateTraining(TrainingExecution trainingExecution, ArrayList<SkillExecutionEvent> shots);
    TrainingExecution prepareForSimulation(SimulateTrainingDTO simulateTrainingDTO);
    ArrayList<SkillExecutionEvent> generateSkillExec(TrainingExecution trainingExecution);
}
