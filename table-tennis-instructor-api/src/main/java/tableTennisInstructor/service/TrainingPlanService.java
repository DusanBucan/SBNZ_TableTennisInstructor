package tableTennisInstructor.service;

import org.kie.api.runtime.KieSession;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseFact;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseRequestFact;

import java.util.ArrayList;

public interface TrainingPlanService {

    TrainingChooseFact findTrainingPlan(TrainingChooseRequestFact requestFact, ArrayList<Skill> skills);

    TrainingChooseFact processKjarResults(KieSession kieSession);
}
