package tableTennisInstructor.service;

import tableTennisInstructor.dto.request.TrainingHistorySearchDTO;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;

import java.util.ArrayList;

public interface TrainingExecutionReportsService {

    ArrayList<TrainingExecution> makeReport(TrainingHistorySearchDTO searchDTO) throws Exception;

}
