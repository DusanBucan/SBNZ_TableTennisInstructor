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
import org.springframework.web.multipart.MultipartFile;
import tableTennisInstructor.dto.request.SimulateTrainingDTO;
import tableTennisInstructor.model.User;
import tableTennisInstructor.model.drools.events.*;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseFact;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.model.drools.facts.training.TrainingLevel;
import tableTennisInstructor.service.*;
import tableTennisInstructor.util.MyFile;

import java.io.File;
import java.security.Principal;
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
    public TrainingExecution simulateTraining(TrainingExecution trainingExecution, ArrayList<SkillExecutionEvent> shots) {
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

        System.out.println(trainingExecution.getTrainingMark());
        return trainingExecution;
    }

    @Override
    public TrainingExecution processTrainingData(TrainingExecution trainingExecution, MultipartFile q) throws Exception{
        ArrayList<SkillExecutionEvent> skillExecutionEvents = MyFile.readSkilleExecutionsFromJsonFile(q);
        for(SkillExecutionEvent sk: skillExecutionEvents) {
            sk.setTrainingExecutionId(trainingExecution.getId());
        }
        return simulateTraining(trainingExecution, skillExecutionEvents);
    }

    @Override
    public TrainingExecution prepareForSimulation(SimulateTrainingDTO simulateTrainingDTO) {
        User user = userService.getById(simulateTrainingDTO.getUserId());
        Training training = trainingService.getById(simulateTrainingDTO.getTrainingId().toString());
        TrainingExecution trainingExecution = trainingExecutionService.startTraining(training, user);
        return trainingExecution;
    }

    @Override
    public TrainingExecution prepareForSimulation(Principal principal, Long trainingId) {
        User user = userService.getByUsername(principal.getName());
        Training training = trainingService.getById(trainingId.toString());
        TrainingExecution trainingExecution = trainingExecutionService.startTraining(training, user);
        return trainingExecution;
    }


    @Override
    public ArrayList<SkillExecutionEvent> generateSkillExec(TrainingExecution trainingExecution) {
        ArrayList<SkillExecutionEvent> retVal = new ArrayList<>();

        SkillExecutionEvent sk1 = new SkillExecutionEvent(1, false, true,
                0.0, 0.0, trainingExecution.getId() );
        retVal.add(sk1);
        SkillExecutionEvent sk2 = new SkillExecutionEvent(2, false, true,
                0.0, 0.0, trainingExecution.getId() );
        retVal.add(sk2);

        SkillExecutionEvent sk3 = new SkillExecutionEvent(3, false, false,
                0.0, 0.0, trainingExecution.getId() );
        retVal.add(sk3);
        SkillExecutionEvent sk4 = new SkillExecutionEvent(4, false, false,
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
