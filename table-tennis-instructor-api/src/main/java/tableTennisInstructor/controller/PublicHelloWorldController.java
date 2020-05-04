package tableTennisInstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseFact;
import tableTennisInstructor.service.TrainingPlanService;

@RestController
@RequestMapping("/api/public/hello-world/trainingPlan")
public class PublicHelloWorldController {

    @Autowired
    private TrainingPlanService trainingPlanService;

    @GetMapping
    public ResponseEntity<TrainingChooseFact> trainingPlan() {
        return new ResponseEntity<>(trainingPlanService.findTrainingPlan(), HttpStatus.OK);
    }
}
