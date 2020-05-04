package tableTennisInstructor.service.impl;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.service.KieSessionService;
import tableTennisInstructor.service.TrainingMonitorService;
@Service
public class TrainingMonitorServiceImpl implements TrainingMonitorService {

    @Autowired
    private KieSessionService kieSessionService;

    @Override
    public void simulateTraining() {
        KieSession kieSession = kieSessionService.getKieSessionForSimulation();
    }


}
