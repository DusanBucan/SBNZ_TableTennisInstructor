package tableTennisInstructor.service.impl;

import org.drools.core.time.SessionPseudoClock;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.EntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.model.drools.events.SkillExecutionEvent;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.model.drools.facts.training.TrainingLevel;
import tableTennisInstructor.service.KieSessionService;
import tableTennisInstructor.service.TrainingMonitorService;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Service
public class TrainingMonitorServiceImpl implements TrainingMonitorService {

    @Autowired
    private KieSessionService kieSessionService;

    /*
    *  svake sekunde se kreira event SkillExecutionEvent koji predstavlja da je korisnik
    *  izveo udarac i taj event se dodaje sesiju, broj udaraca zavisi od treninga...
    *  Nakon izvrsavanja svih udaraca simulator se zaustavlja i vraca rezulatete treninga
    *
    * */
    @Override
    public void simulateTraining() {
        KieSession kieSession = kieSessionService.getKieSessionForSimulation();
        SessionPseudoClock clock = kieSession.getSessionClock();

        System.out.println("pocetno vreme sata: " + clock.getCurrentTime());

        ArrayList<SkillExecutionEvent> shots = this.generateSkillExec();
        Training tr = new Training();
        tr.setTrainingLevel(TrainingLevel.ADVANCED);

        TrainingExecution trainingExecution = new TrainingExecution();
        trainingExecution.setId(1l);
        trainingExecution.setTraining(tr);

        kieSession.insert(trainingExecution);

        for (int index = 0; index < shots.size(); index++) {

            kieSession.insert(shots.get(index));
            clock.advanceTime(1, TimeUnit.SECONDS);

            int ruleCount = kieSession.fireAllRules();
            System.out.println("index: " + index);

        }
        //We manually advance time 1 minute, without a heart beat
//        clock.advanceTime(1, TimeUnit.MINUTES);
//        int ruleCount = ksession.fireAllRules();
//        assertThat(ruleCount, equalTo(1));
//        Collection<?> newEvents = ksession.getObjects(new ClassObjectFilter(HeartAttackEvent.class));
//        assertThat(newEvents.size(), equalTo(1));
    }



    private ArrayList<SkillExecutionEvent> generateSkillExec() {

        ArrayList<SkillExecutionEvent> retVal = new ArrayList<>();

        Training tr = new Training();
        tr.setTrainingLevel(TrainingLevel.BEGINNER);

        TrainingExecution trainingExecution = new TrainingExecution();
        trainingExecution.setId(1l);
        trainingExecution.setTraining(tr);


        SkillExecutionEvent sk1 = new SkillExecutionEvent(1, false, false,
                14.0, 10.0, trainingExecution.getId() );
        retVal.add(sk1);
        SkillExecutionEvent sk2 = new SkillExecutionEvent(2, false, false,
                14.0, 10.0, trainingExecution.getId() );
        retVal.add(sk2);

        SkillExecutionEvent sk3 = new SkillExecutionEvent(3, false, true,
                14.0, 10.0, trainingExecution.getId() );
        retVal.add(sk3);
        SkillExecutionEvent sk4 = new SkillExecutionEvent(4, false, true,
                14.0, 10.0, trainingExecution.getId() );
        retVal.add(sk4);
        SkillExecutionEvent sk5 = new SkillExecutionEvent(5, false, true,
                14.0, 10.0, trainingExecution.getId() );
        retVal.add(sk5);
        SkillExecutionEvent sk6 = new SkillExecutionEvent(6, false, true,
                14.0, 10.0, trainingExecution.getId() );
        retVal.add(sk6);
        SkillExecutionEvent sk7 = new SkillExecutionEvent(7, true, false,
                14.0, 10.0, trainingExecution.getId() );
        retVal.add(sk7);
        SkillExecutionEvent sk8 = new SkillExecutionEvent(8, false, false,
                14.0, 10.0, trainingExecution.getId() );
        retVal.add(sk8);
        SkillExecutionEvent sk9 = new SkillExecutionEvent(9, false, false,
                14.0, 10.0, trainingExecution.getId() );
        retVal.add(sk9);
        SkillExecutionEvent sk10 = new SkillExecutionEvent(10, false, true,
                14.0, 10.0, trainingExecution.getId() );
        retVal.add(sk10);

        return  retVal;
    }

}
