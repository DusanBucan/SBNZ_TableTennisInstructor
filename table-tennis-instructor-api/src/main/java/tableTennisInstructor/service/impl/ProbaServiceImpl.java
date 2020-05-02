package tableTennisInstructor.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.model.drools.facts.Item;
import tableTennisInstructor.model.drools.facts.UserHealth;
import tableTennisInstructor.model.drools.facts.UserHealthState;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.training.*;
import tableTennisInstructor.service.ProbaService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProbaServiceImpl implements ProbaService {

    @Autowired
    private KieContainer kieContainer;

    @Override
    public Item getClassifiedItem(Item i) {

        UserHealth uh = new UserHealth(null, new Date(),
                65, 124, 72, UserHealthState.UNKNOWN);

        Skill skill = new Skill();
        skill.setSkillId(1l);

        Training trening =  new Training();
        trening.setSkill(skill);
        trening.setTrainingLevel(TrainingLevel.INTERMEDIATE);

        TrainingExecution trainingExecution = new TrainingExecution();
        trainingExecution.setTraining(trening);
        trainingExecution.setTrainingMark(TrainingMark.BAD);


        ArrayList<TrainingExecution> trainHistory = new ArrayList<>();
        trainHistory.add(trainingExecution);

        TrainingChooseRequestFact tcReq = new TrainingChooseRequestFact();
        tcReq.setUserId(1l);
        tcReq.setDesiredSkill(skill);
        tcReq.setUserHealth(uh);
        tcReq.setTrainingDuration(4.0);
        tcReq.setTrainHistory(trainHistory);


        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(tcReq);
        kieSession.fireAllRules();
        kieSession.dispose();

        // Find all PayStylePass facts and 1st generation child classes of PayStylePass.
        ObjectFilter payPassFilter = new ObjectFilter() {
            @Override
            public boolean accept(Object object) {
                if ( TrainingChooseFact.class.equals(object.getClass())) return true;
                if ( TrainingChooseFact.class.equals(object.getClass().getSuperclass())) return true;
                return false;
            }
        };

        // printFactsMessage(kieSession);

        List<TrainingChooseFact> facts = new ArrayList<>();
        for (FactHandle handle : kieSession.getFactHandles(payPassFilter)) {
            facts.add((TrainingChooseFact) kieSession.getObject(handle));
        }
        if (facts.size() == 0) {
            System.out.println("nemaaaa");
        }
        // Assumes that the rules will always be generating a single pay pass.
        TrainingChooseFact tfc =  facts.get(0);
        System.out.println(tfc.getChoosenLevel());


        return i;
    }
}
