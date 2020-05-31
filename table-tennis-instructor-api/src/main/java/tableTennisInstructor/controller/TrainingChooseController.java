package tableTennisInstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tableTennisInstructor.dto.request.TrainingChooseRequestFactDTO;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseFact;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseRequestFact;
import tableTennisInstructor.service.SkillService;
import tableTennisInstructor.service.TrainingPlanService;
import tableTennisInstructor.service.TrainingService;
import tableTennisInstructor.service.Util;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/trainingChoose", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainingChooseController {

    @Autowired
    private TrainingPlanService trainingPlanService;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private SkillService skillService;


    //@TODO: ima neki bug treba videti sto puca u nekim slucajevima

    @PostMapping(path = "/find", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_REGULAR')")
    public ResponseEntity<ArrayList<Training>> chooseTraining(@RequestBody TrainingChooseRequestFactDTO requestFactDTO) {

        TrainingChooseRequestFact requestFact = trainingPlanService.processDTO(requestFactDTO);
        ArrayList<Skill> skills = skillService.findAll();
        TrainingChooseFact trainingChooseFact= trainingPlanService.findTrainingPlan(requestFact, skills);

        ArrayList<Training> trainings =  trainingService.
                findTrainings(trainingChooseFact, requestFact);

        return new ResponseEntity<>(trainings, HttpStatus.OK);
    }
}
