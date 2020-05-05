package tableTennisInstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseFact;
import tableTennisInstructor.service.TrainingMonitorService;
import tableTennisInstructor.service.TrainingPlanService;

@RestController
@RequestMapping("/api/public/hello-world")
public class PublicHelloWorldController {

    @Autowired
    private TrainingPlanService trainingPlanService;

    @Autowired
    private TrainingMonitorService trainingMonitorService;

    @RequestMapping(value = "/trainingPlan", method = RequestMethod.GET)
    public ResponseEntity<TrainingChooseFact> trainingPlan() {
        return new ResponseEntity<>(trainingPlanService.findTrainingPlan(), HttpStatus.OK);
    }

    @RequestMapping(value = "/trainingSimulation", method = RequestMethod.GET)
    public ResponseEntity<String> trainingSimulation() {
        trainingMonitorService.simulateTraining();
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }
}
