package tableTennisInstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tableTennisInstructor.dto.response.TrainingExecutionDTO;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.service.TrainingExecutionService;
import tableTennisInstructor.service.TrainingService;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/training", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private TrainingExecutionService trainingExecutionService;

    @GetMapping(path = "getAll")
    public ResponseEntity<ArrayList<Training>> getAll() {
        return new ResponseEntity<>(trainingService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "getDetails/{id}")
    public ResponseEntity<Training> getDetails(@PathVariable String id) {
        return new ResponseEntity<>(trainingService.getById(id), HttpStatus.OK);
    }

    @GetMapping(path = "getTrainingHistory/{id}")
    public ResponseEntity<ArrayList<TrainingExecutionDTO>> getTrainingHistory(@PathVariable Long id) {
        ArrayList<TrainingExecutionDTO> trainingExecutions = (ArrayList<TrainingExecutionDTO>)
                trainingExecutionService.findByUserId(id)
                    .stream().map(tre -> new TrainingExecutionDTO(tre)).collect(Collectors.toList());
        return new ResponseEntity<>(trainingExecutions, HttpStatus.OK);
    }


}
