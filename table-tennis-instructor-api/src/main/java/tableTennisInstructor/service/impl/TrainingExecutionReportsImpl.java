package tableTennisInstructor.service.impl;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.dto.request.TrainingHistorySearchDTO;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseFact;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.service.KieSessionService;
import tableTennisInstructor.service.TrainingExecutionReports;
import tableTennisInstructor.service.TrainingExecutionService;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingExecutionReportsImpl implements TrainingExecutionReports {

    @Autowired
    private KieSessionService kieSessionService;

    @Autowired
    private TrainingExecutionService trainingExecutionService

    @Override
    public ArrayList<TrainingExecution> makeReport(TrainingHistorySearchDTO searchDTO) throws Exception {


        //@TODO: da se napise fajl sa pravilima
        ArrayList<TrainingExecution> allExecutions = trainingExecutionService.findByUserId(searchDTO.userId);
//        KieSession kieSession = kieSessionService.getKieSessionForReports(allExecutions);
//        kieSession.insert(searchDTO);
//        kieSession.fireAllRules();
//
//        allExecutions = processKieSessionReportResults(kieSession);

        return allExecutions;
    }

    // @TODO: da izdvoji svarno sta treba
    private ArrayList<TrainingExecution> processKieSessionReportResults(KieSession kieSession) {
        ObjectFilter payPassFilter = new ObjectFilter() {
            @Override
            public boolean accept(Object object) {
                if ( TrainingExecution.class.equals(object.getClass())) return true;
                if ( TrainingExecution.class.equals(object.getClass().getSuperclass())) return true;
                return false;
            }
        };
        List<TrainingExecution> facts = new ArrayList<>();
        for (FactHandle handle : kieSession.getFactHandles(payPassFilter)) {
            facts.add((TrainingExecution) kieSession.getObject(handle));
        }
    }
}
