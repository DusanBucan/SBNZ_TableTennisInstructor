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
import tableTennisInstructor.model.drools.facts.skill.SkillLevel;
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



        KieSession kieSession = kieContainer.newKieSession();
        TrainingChooseRequestFact tcReq = prepareReq(kieSession);
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


    public TrainingChooseRequestFact prepareReq(KieSession kSession) {

        UserHealth uh = new UserHealth(null, new Date(),
                65, 124, 72, UserHealthState.UNKNOWN);

        Skill skill = new Skill();
        skill.setSkillId(1l);
        skill.setSkillGroup(1);

        Skill skill2 = new Skill();
        skill2.setSkillId(3l);
        skill2.setSkillLevel(SkillLevel.INTERMEDIATE);
        skill2.setSkillGroup(1);

        Skill skill4 = new Skill();
        skill4.setSkillId(4l);
        skill4.setSkillLevel(SkillLevel.BEGINER);
        skill4.setSkillGroup(1);

        Skill skill1 = new Skill();
        skill1.setSkillId(2l);
        skill1.setSkillLevel(SkillLevel.BEGINER);
        skill1.setSkillGroup(1);


        Training trening =  new Training();
        trening.setSkill(skill);
        trening.setTrainingLevel(TrainingLevel.INTERMEDIATE);

        Training trening2 =  new Training();
        trening2.setSkill(skill1);
        trening2.setTrainingLevel(TrainingLevel.INTERMEDIATE);

        Training trening3 =  new Training();
        trening3.setSkill(skill2);
        trening3.setTrainingLevel(TrainingLevel.INTERMEDIATE);

        Training trening4 =  new Training();
        trening4.setSkill(skill4);
        trening4.setTrainingLevel(TrainingLevel.INTERMEDIATE);


        TrainingExecution trainingExecution = new TrainingExecution();
        trainingExecution.setTraining(trening);
        trainingExecution.setTrainingMark(TrainingMark.EXCELLENT);

        TrainingExecution trainingExecution2 = new TrainingExecution();
        trainingExecution2.setTraining(trening2);
        trainingExecution2.setTrainingMark(TrainingMark.GOOD);

        TrainingExecution trainingExecution3 = new TrainingExecution();
        trainingExecution3.setTraining(trening3);
        trainingExecution3.setTrainingMark(TrainingMark.GOOD);

        TrainingExecution trainingExecution4 = new TrainingExecution();
        trainingExecution4.setTraining(trening4);
        trainingExecution4.setTrainingMark(TrainingMark.GOOD);

        ArrayList<TrainingExecution> trainHistory = new ArrayList<>();
        trainHistory.add(trainingExecution);
        trainHistory.add(trainingExecution2);
        trainHistory.add(trainingExecution3);
        trainHistory.add(trainingExecution4);

        TrainingChooseRequestFact tcReq = new TrainingChooseRequestFact();
        tcReq.setUserId(1l);
        tcReq.setDesiredSkill(skill);
        tcReq.setUserHealth(uh);
        tcReq.setTrainingDuration(4.0);
        tcReq.setTrainHistory(trainHistory);

        ArrayList<Skill> allSkills = new ArrayList<>();
        allSkills.add(skill);
        allSkills.add(skill1);
        allSkills.add(skill2);
        allSkills.add(skill4);


        kSession.setGlobal("skills", allSkills);

        return tcReq;
    }
}
