package tableTennisInstructor.service;

import org.kie.api.runtime.KieSession;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;

import java.util.ArrayList;

public interface KieSessionService {

    KieSession getKieSessionForSimulation();

    KieSession getKieSessionForTrainingPlan(ArrayList<Skill> allSkills);

    KieSession getKieSessionForReports(ArrayList<TrainingExecution> trainingExecutions);
}
