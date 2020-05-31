package tableTennisInstructor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.repository.TrainingExecutionRepository;
import tableTennisInstructor.service.TrainingExecutionService;

import java.util.ArrayList;

@Service
public class TrainingExecutionServiceImpl implements TrainingExecutionService {

    @Autowired
    private TrainingExecutionRepository trainingExecutionRepository;

    @Override
    public ArrayList<TrainingExecution> findByUserId(Long userId) {
        return (ArrayList<TrainingExecution>) trainingExecutionRepository.findAllByUserId(userId).get();
    }
}
