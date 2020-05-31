package tableTennisInstructor.dto.request;

import tableTennisInstructor.model.drools.facts.UserHealth;

public class TrainingChooseRequestFactDTO {

    public Long userId;
    public Long desiredSkillId;
    public UserHealth userHealth;
    public double trainingDuration;

    public TrainingChooseRequestFactDTO(){}

    public TrainingChooseRequestFactDTO(Long userId, Long desiredSkillId, UserHealth userHealth, double trainingDuration) {
        this.userId = userId;
        this.desiredSkillId = desiredSkillId;
        this.userHealth = userHealth;
        this.trainingDuration = trainingDuration;
    }
}
