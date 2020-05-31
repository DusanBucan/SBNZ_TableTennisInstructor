package tableTennisInstructor.dto.response;

import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.model.drools.facts.training.TrainingMark;

import java.util.Date;

public class TrainingExecutionDTO {
    public Long id;
    public Training training;
    public Date date;
    public TrainingMark trainingMark;

    public TrainingExecutionDTO() {}

    public TrainingExecutionDTO(Long id, Training training, Date date, TrainingMark trainingMark) {
        this.id = id;
        this.training = training;
        this.date = date;
        this.trainingMark = trainingMark;
    }

    public TrainingExecutionDTO(TrainingExecution tre) {
        this.id = tre.getId();
        this.training = tre.getTraining();
        this.date = tre.getDate();
        this.trainingMark = tre.getTrainingMark();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTrainingMark(TrainingMark trainingMark) {
        this.trainingMark = trainingMark;
    }

    public Long getId() {
        return id;
    }

    public Training getTraining() {
        return training;
    }

    public Date getDate() {
        return date;
    }

    public TrainingMark getTrainingMark() {
        return trainingMark;
    }
}
