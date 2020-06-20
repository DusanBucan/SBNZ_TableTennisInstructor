package tableTennisInstructor.service.impl;

import org.apache.maven.shared.invoker.*;
import org.drools.core.time.SessionPseudoClock;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.EntryPoint;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.time.SessionClock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.dto.request.SimulateTrainingDTO;
import tableTennisInstructor.model.User;
import tableTennisInstructor.model.drools.events.*;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseFact;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.model.drools.facts.training.TrainingLevel;
import tableTennisInstructor.service.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TrainingMonitorServiceImpl implements TrainingMonitorService {

    @Autowired
    private KieSessionService kieSessionService;

    @Autowired
    private UserService userService;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private TrainingExecutionService trainingExecutionService;

    /*
    *  svake sekunde se kreira event SkillExecutionEvent koji predstavlja da je korisnik
    *  izveo udarac i taj event se dodaje sesiju, broj udaraca zavisi od treninga...
    *  Nakon izvrsavanja svih udaraca simulator se zaustavlja i vraca rezulatete treninga
    *
    * */
    @Override
    public void simulateTraining(TrainingExecution trainingExecution, ArrayList<SkillExecutionEvent> shots) {
        KieSession kieSession = kieSessionService.getKieSessionForSimulation();
//        SessionPseudoClock clock = kieSession.getSessionClock();
//        SessionClock clock = kieSession.getSessionClock();


        Thread t = new Thread() {
            @Override
            public void run() {
                kieSession.insert(trainingExecution);
                for (int index = 0; index < shots.size(); index++) {
                    SkillExecutionEvent executionEvent = shots.get(index);
                    executionEvent.setExecutionTime(new Date());
//                    clock.advanceTime(1, TimeUnit.SECONDS);
                    kieSession.insert(executionEvent);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //do nothing
                    }
                }
                // doda event za kraj i treba da se pozove halt
//                clock.advanceTime(1, TimeUnit.SECONDS);
                kieSession.insert(new EndTrainingEvent());
            }
        };
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            //do nothing
        }
        kieSession.fireUntilHalt();

        // ispise ga u konzolu i update u bazi izvrsenje treninga nakon zavrsetka simulacije
        // podesi koja je konacna odluka.
        System.out.println(trainingExecution.getTrainingMark());
        trainingExecutionService.saveTrainingExecution(trainingExecution);




//
//
//        System.out.println("pocetno vreme sata: " + clock.getCurrentTime());
//
//
//
//        for (int index = 0; index < shots.size(); index++) {
//
//
//            SkillExecutionEvent e = shots.get(index);
//            e.setExecutionTime(clock.getCurrentTime());
//            kieSession.insert(e);
//            clock.advanceTime(1, TimeUnit.SECONDS);
//
//            int ruleCount = kieSession.fireAllRules();
//            System.out.println("index: " + index + " broj pravila " + ruleCount );
//
//
//            ObjectFilter payPassFilter = new ObjectFilter() {
//                @Override
//                public boolean accept(Object object) {
//                    if ( BadRacketSpeedEvent.class.equals(object.getClass())) return true;
//                    if ( BadRacketSpeedEvent.class.equals(object.getClass().getSuperclass())) return true;
//                    return false;
//                }
//            };
//
//            List<BadRacketSpeedEvent> facts = new ArrayList<>();
//            for (FactHandle handle : kieSession.getFactHandles(payPassFilter)) {
//                facts.add((BadRacketSpeedEvent) kieSession.getObject(handle));
//            }
//
////            System.out.println("svi koji su trenutno u sesiji");
////            System.out.println(facts);
//
//        }
//
//        ObjectFilter payPassFilter1 = new ObjectFilter() {
//            @Override
//            public boolean accept(Object object) {
//                if ( RacketSpeedCorrectionEvent.class.equals(object.getClass())) return true;
//                if ( RacketSpeedCorrectionEvent.class.equals(object.getClass().getSuperclass())) return true;
//                return false;
//            }
//        };
//
//        List<RacketSpeedCorrectionEvent> facts = new ArrayList<>();
//        for (FactHandle handle : kieSession.getFactHandles(payPassFilter1)) {
//            facts.add((RacketSpeedCorrectionEvent) kieSession.getObject(handle));
//        }





        //We manually advance time 1 minute, without a heart beat
//        clock.advanceTime(1, TimeUnit.MINUTES);
//        int ruleCount = ksession.fireAllRules();
//        assertThat(ruleCount, equalTo(1));
//        Collection<?> newEvents = ksession.getObjects(new ClassObjectFilter(HeartAttackEvent.class));
//        assertThat(newEvents.size(), equalTo(1));
    }

    @Override
    public TrainingExecution prepareForSimulation(SimulateTrainingDTO simulateTrainingDTO) {
        User user = userService.getById(simulateTrainingDTO.getUserId());
        Training training = trainingService.getById(simulateTrainingDTO.getTrainingId().toString());
        TrainingExecution trainingExecution = trainingExecutionService.startTraining(training, user);
        return trainingExecution;
    }

    @Override
    public ArrayList<SkillExecutionEvent> generateSkillExec(TrainingExecution trainingExecution) {
        ArrayList<SkillExecutionEvent> retVal = new ArrayList<>();

        SkillExecutionEvent sk1 = new SkillExecutionEvent(1, false, true,
                10.0, 0.0, trainingExecution.getId() );
        retVal.add(sk1);
        SkillExecutionEvent sk2 = new SkillExecutionEvent(2, false, true,
                10.0, 0.0, trainingExecution.getId() );
        retVal.add(sk2);

        SkillExecutionEvent sk3 = new SkillExecutionEvent(3, true, true,
                0.0, 0.0, trainingExecution.getId() );
        retVal.add(sk3);
        SkillExecutionEvent sk4 = new SkillExecutionEvent(4, true, true,
                0.0, 0.0, trainingExecution.getId() );
        retVal.add(sk4);
        SkillExecutionEvent sk5 = new SkillExecutionEvent(5, true, true,
                0.0, 0.0, trainingExecution.getId() );
        retVal.add(sk5);
        SkillExecutionEvent sk6 = new SkillExecutionEvent(6, true, true,
                0.0, 0.0, trainingExecution.getId() );
        retVal.add(sk6);
        SkillExecutionEvent sk7 = new SkillExecutionEvent(7, true, true,
                0.0, 0.0, trainingExecution.getId() );
        retVal.add(sk7);
        SkillExecutionEvent sk8 = new SkillExecutionEvent(8, true, true,
                0.0, 0.0, trainingExecution.getId() );
        retVal.add(sk8);
//        SkillExecutionEvent sk9 = new SkillExecutionEvent(9, false, false,
//                0.0, -15.0, trainingExecution.getId() );
//        retVal.add(sk9);
//        SkillExecutionEvent sk10 = new SkillExecutionEvent(10, true, true,
//                0.0, 10.0, trainingExecution.getId() );
//        retVal.add(sk10);

        return  retVal;
    }

}
