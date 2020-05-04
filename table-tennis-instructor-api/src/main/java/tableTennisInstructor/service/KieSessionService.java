package tableTennisInstructor.service;

import org.kie.api.runtime.KieSession;
import tableTennisInstructor.model.drools.facts.skill.Skill;

import java.util.ArrayList;

public interface KieSessionService {

    KieSession getKieSessionForSimulation();

    KieSession getKieSessionForTrainingPlan(ArrayList<Skill> allSkills);
}
