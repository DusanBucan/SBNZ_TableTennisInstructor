package tableTennisInstructor.service;

import org.kie.api.runtime.KieSession;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseFact;

public interface TrainingPlanService {

    TrainingChooseFact findTrainingPlan();

    TrainingChooseFact processKjarResults(KieSession kieSession);
}
