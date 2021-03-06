package tableTennisInstructor.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.service.KieSessionService;

import java.util.ArrayList;

@Service
public class KieSessionServiceImpl implements KieSessionService {

    @Autowired
    private KieContainer kieContainer;

    @Value("${training.plan.kie.session.name}")
    public String trainingPlanSessionName;

    @Value("${cep.kie.session.name}")
    public String cepKieSession;

    @Value("${training.reports.kie.session.name}")
    public String reportsKieSession;

    public static String SKILLS_GLOBAL = "skills";
    public static String TRAINING_EXECUTIONS_GLOBAL = "trainingExecutions";

    public KieSession getKieSessionForSimulation() {
        return kieContainer.newKieSession(cepKieSession);
    }

    public KieSession getKieSessionForTrainingPlan(ArrayList<Skill> allSkills) {
        KieSession kieSession = kieContainer.newKieSession(trainingPlanSessionName);
        kieSession.setGlobal( SKILLS_GLOBAL, allSkills);
        return kieSession;
    }

    @Override
    public KieSession getKieSessionForReports(ArrayList<TrainingExecution> trainingExecutions) {
        KieSession kieSession = kieContainer.newKieSession(reportsKieSession);
        kieSession.setGlobal( TRAINING_EXECUTIONS_GLOBAL, trainingExecutions);
        return kieSession;
    }
}
