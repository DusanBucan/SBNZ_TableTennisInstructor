package tableTennisInstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tableTennisInstructor.dto.request.SimulateTrainingDTO;
import tableTennisInstructor.dto.response.TrainingExecutionDTO;
import tableTennisInstructor.model.drools.events.SkillExecutionEvent;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.service.TrainingExecutionService;
import tableTennisInstructor.service.TrainingMonitorService;

import java.security.Principal;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/trainingMonitor", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainingMonitorController {

    @Autowired
    private TrainingMonitorService trainingMonitorService;

    @Autowired
    private TrainingExecutionService trainingExecutionService;

    @RequestMapping(value = "/trainingSimulation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_REGULAR')")
    public ResponseEntity<TrainingExecutionDTO> trainingSimulation(@RequestBody SimulateTrainingDTO simulateTrainingDTO) {

        TrainingExecution startTrExecution = trainingMonitorService.prepareForSimulation(simulateTrainingDTO);
        ArrayList<SkillExecutionEvent> shots = trainingMonitorService.generateSkillExec(startTrExecution);
        TrainingExecution result = trainingMonitorService.simulateTraining(startTrExecution, shots);

        trainingExecutionService.saveTrainingExecution(result);
        return new ResponseEntity<>(new TrainingExecutionDTO(result), HttpStatus.OK);
    }

    @RequestMapping(value = "/processTrainingData/{trainigId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_REGULAR')")
    public ResponseEntity<TrainingExecutionDTO>
                    processTrainingData(@RequestParam(("file")) MultipartFile q,
                                        @PathVariable("trainigId") Long trainingId, Principal principal) throws Exception{

        TrainingExecution startTrExecution = trainingMonitorService.prepareForSimulation(principal, trainingId);
        TrainingExecution result = trainingMonitorService.processTrainingData(startTrExecution, q);

        trainingExecutionService.saveTrainingExecution(result);
        return new ResponseEntity<>(new TrainingExecutionDTO(result), HttpStatus.OK);
    }

}
