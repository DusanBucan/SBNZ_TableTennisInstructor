package tableTennisInstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tableTennisInstructor.dto.request.SimulateTrainingDTO;
import tableTennisInstructor.model.drools.events.SkillExecutionEvent;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.service.TrainingMonitorService;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/trainingMonitor", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainingMonitorController {

    @Autowired
    private TrainingMonitorService trainingMonitorService;

    @RequestMapping(value = "/trainingSimulation", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_REGULAR')")
    public ResponseEntity<String> trainingSimulation(@RequestBody SimulateTrainingDTO simulateTrainingDTO) {

        TrainingExecution startTrExecution = trainingMonitorService.prepareForSimulation(simulateTrainingDTO);
        ArrayList<SkillExecutionEvent> shots = trainingMonitorService.generateSkillExec(startTrExecution);
        trainingMonitorService.simulateTraining(startTrExecution, shots);
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }


}
