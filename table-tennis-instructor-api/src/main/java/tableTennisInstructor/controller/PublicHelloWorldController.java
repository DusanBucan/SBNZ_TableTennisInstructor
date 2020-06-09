package tableTennisInstructor.controller;

import org.apache.maven.shared.invoker.MavenInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tableTennisInstructor.config.KieContainerConfig;
import tableTennisInstructor.model.User;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseFact;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseRequestFact;
import tableTennisInstructor.service.TrainingMonitorService;
import tableTennisInstructor.service.TrainingPlanService;
import tableTennisInstructor.service.Util;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/public/hello-world")
public class PublicHelloWorldController {

    @Autowired
    private TrainingPlanService trainingPlanService;

    @Autowired
    private TrainingMonitorService trainingMonitorService;

    @Autowired
    private Util util;


    @RequestMapping(value = "/trainingPlan", method = RequestMethod.GET)
    public ResponseEntity<TrainingChooseFact> trainingPlan() {

        User user = new User();
        user.setId(1l);
        ArrayList<Skill> skills = util.mockAllIntermediateSkills();
        TrainingChooseRequestFact trf = new TrainingChooseRequestFact();
        trf.setUserHealth(util.mockGoodUserHealth(user));
        trf.setDesiredSkill(skills.get(0));
        trf.setTrainHistory(util.prepareGoodTrainingHistory(util.prepareAllIntermediate()));
        trf.setUserId(user.getId());
        trf.setTrainingDuration(util.preprareLongTrainingTime());


        return new ResponseEntity<>(trainingPlanService.findTrainingPlan(trf, skills), HttpStatus.OK);
    }

    @RequestMapping(value = "/trainingSimulation", method = RequestMethod.GET)
    public ResponseEntity<String> trainingSimulation() {
        trainingMonitorService.simulateTraining();
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }
    
}
