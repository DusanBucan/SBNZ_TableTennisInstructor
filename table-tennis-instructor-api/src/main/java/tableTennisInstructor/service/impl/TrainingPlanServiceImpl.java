package tableTennisInstructor.service.impl;

import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.model.drools.facts.UserHealth;
import tableTennisInstructor.model.drools.facts.UserHealthState;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.skill.SkillLevel;
import tableTennisInstructor.model.drools.facts.training.*;
import tableTennisInstructor.service.KieSessionService;
import tableTennisInstructor.service.TrainingPlanService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrainingPlanServiceImpl implements TrainingPlanService {

    @Autowired
    private KieSessionService kieSessionService;

    @Override
    public TrainingChooseFact findTrainingPlan(TrainingChooseRequestFact tcReq, ArrayList<Skill> allSkills) {
        KieSession kieSession =  kieSessionService.getKieSessionForTrainingPlan(allSkills);
        kieSession.insert(tcReq);

        kieSession.fireAllRules();
        kieSession.dispose();

        TrainingChooseFact tfc =this.processKjarResults(kieSession);
        return tfc;

    }

    @Override
    public TrainingChooseFact processKjarResults(KieSession kieSession) {

        // Find all PayStylePass facts and 1st generation child classes of PayStylePass.
        ObjectFilter payPassFilter = new ObjectFilter() {
            @Override
            public boolean accept(Object object) {
                if ( TrainingChooseFact.class.equals(object.getClass())) return true;
                if ( TrainingChooseFact.class.equals(object.getClass().getSuperclass())) return true;
                return false;
            }
        };

        List<TrainingChooseFact> facts = new ArrayList<>();
        for (FactHandle handle : kieSession.getFactHandles(payPassFilter)) {
            facts.add((TrainingChooseFact) kieSession.getObject(handle));
        }
        if (facts.size() == 0) {
            System.out.println("No Kjar Results");
        }
        TrainingChooseFact tfc =  facts.get(0);
        return tfc;
    }

}