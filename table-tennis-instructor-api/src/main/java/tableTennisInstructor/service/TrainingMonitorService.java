package tableTennisInstructor.service;

import org.springframework.web.multipart.MultipartFile;
import tableTennisInstructor.dto.request.SimulateTrainingDTO;
import tableTennisInstructor.model.drools.events.SkillExecutionEvent;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;

import java.security.Principal;
import java.util.ArrayList;

public interface TrainingMonitorService {

    TrainingExecution simulateTraining(TrainingExecution trainingExecution, ArrayList<SkillExecutionEvent> shots);
    TrainingExecution processTrainingData(TrainingExecution trainingExecution, MultipartFile q) throws Exception;
    TrainingExecution prepareForSimulation(SimulateTrainingDTO simulateTrainingDTO);
    TrainingExecution prepareForSimulation(Principal principal, Long trainingId);
    ArrayList<SkillExecutionEvent> generateSkillExec(TrainingExecution trainingExecution);
}
