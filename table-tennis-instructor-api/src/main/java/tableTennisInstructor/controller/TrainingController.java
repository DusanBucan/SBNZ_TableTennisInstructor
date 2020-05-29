package tableTennisInstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.service.TrainingService;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/training", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping(path = "getAll")
    public ResponseEntity<ArrayList<Training>> getAll() {
        return new ResponseEntity<>(trainingService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "getDetails/{id}")
    public ResponseEntity<Training> getDetails(@PathVariable String id) {
        System.out.println(id);
        return new ResponseEntity<>(trainingService.getById(id), HttpStatus.OK);
    }

}
