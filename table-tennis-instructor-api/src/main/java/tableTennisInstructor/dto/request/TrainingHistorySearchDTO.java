package tableTennisInstructor.dto.request;

import tableTennisInstructor.model.drools.facts.training.TrainingMark;

public class TrainingHistorySearchDTO {

    public Long userId;
    public TrainingMark trainingMark;
    public Long skillId;
    public int forMonths;

    public TrainingHistorySearchDTO(){}
}
