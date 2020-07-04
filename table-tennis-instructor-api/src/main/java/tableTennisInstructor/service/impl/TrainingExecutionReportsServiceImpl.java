package tableTennisInstructor.service.impl;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.api.runtime.rule.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.dto.request.TrainingHistorySearchDTO;
import tableTennisInstructor.model.User;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.model.drools.facts.training.TrainingMark;
import tableTennisInstructor.model.drools.facts.training.TrainingReportFact;
import tableTennisInstructor.service.KieSessionService;
import tableTennisInstructor.service.TrainingExecutionReportsService;
import tableTennisInstructor.service.TrainingExecutionService;
import java.util.ArrayList;

@Service
public class TrainingExecutionReportsServiceImpl implements TrainingExecutionReportsService {

    @Autowired
    private KieSessionService kieSessionService;

    @Autowired
    private TrainingExecutionService trainingExecutionService;

    @Override
    public ArrayList<TrainingExecution> makeReport(TrainingHistorySearchDTO searchDTO) throws Exception {

        TrainingReportFact trainingReportFact = new TrainingReportFact(searchDTO);
        ArrayList<TrainingExecution> allExecutions = trainingExecutionService.findByUserId(searchDTO.userId);
        KieSession kieSession = kieSessionService.getKieSessionForReports(allExecutions);

        kieSession.insert(trainingReportFact);
        kieSession.fireAllRules();
        return trainingReportFact.getTrExecutionsIdMeetCondition();
    }
}
