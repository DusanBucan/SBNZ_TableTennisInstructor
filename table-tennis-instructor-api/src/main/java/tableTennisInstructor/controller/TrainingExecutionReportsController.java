package tableTennisInstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tableTennisInstructor.dto.request.TrainingHistorySearchDTO;
import tableTennisInstructor.dto.response.TrainingExecutionDTO;
import tableTennisInstructor.service.TrainingExecutionService;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/trainingReports", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainingExecutionReportsController {

    @Autowired
    private TrainingExecutionService trainingExecutionService;

    @PostMapping(path = "getTrainingHistory")
    public ResponseEntity<ArrayList<TrainingExecutionDTO>> getTrainingHistory(
            @RequestBody TrainingHistorySearchDTO searchParam) {
        ArrayList<TrainingExecutionDTO> trainingExecutions = (ArrayList<TrainingExecutionDTO>)
                trainingExecutionService.reports(searchParam)
                        .stream().map(tre -> new TrainingExecutionDTO(tre)).collect(Collectors.toList());
        return new ResponseEntity<>(trainingExecutions, HttpStatus.OK);
    }
}
