package tableTennisInstructor.model.drools.facts.training;

import tableTennisInstructor.model.drools.facts.UserHealth;
import tableTennisInstructor.model.drools.facts.skill.Skill;

import java.util.List;

/**
 * @author dusan
 *
 */
public class TrainingChooseRequestFact {
	
	public Long userId;
	public Skill desiredSkill;
	public double trainingDuration;
	public UserHealth userHealth;
	public List<TrainingExecution> trainHistory;
	
	public TrainingChooseRequestFact() {}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public double getTrainingDuration() {
		return trainingDuration;
	}

	public void setTrainingDuration(double trainingDuration) {
		this.trainingDuration = trainingDuration;
	}

	public UserHealth getUserHealth() {
		return userHealth;
	}

	public void setUserHealth(UserHealth userHealth) {
		this.userHealth = userHealth;
	}

	public Skill getDesiredSkill() {
		return desiredSkill;
	}

	public void setDesiredSkill(Skill desiredSkill) {
		this.desiredSkill = desiredSkill;
	}

	public List<TrainingExecution> getTrainHistory() {
		return trainHistory;
	}

	public void setTrainHistory(List<TrainingExecution> trainHistory) {
		this.trainHistory = trainHistory;
	}
	

}
