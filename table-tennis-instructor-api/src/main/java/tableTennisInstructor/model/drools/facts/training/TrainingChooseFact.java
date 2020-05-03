package tableTennisInstructor.model.drools.facts.training;

import org.kie.api.definition.type.PropertyReactive;
import tableTennisInstructor.model.drools.facts.UserHealthState;

@PropertyReactive
public class TrainingChooseFact {

	public Long userId;
	public TrainingLevel choosenLevel;
	public UserHealthState userHealthState;
	public TrainingDuration trainingDuradtion;
	public Knowledge previousKnowledge;
	public Knowledge similarKnowledge;
	
	public TrainingChooseFact() {
		this.similarKnowledge = Knowledge.UNKNOWN;
		this.previousKnowledge = Knowledge.UNKNOWN;
		this.choosenLevel = TrainingLevel.UNKNOWN;
		this.userHealthState = UserHealthState.UNKNOWN;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public TrainingLevel getChoosenLevel() {
		return choosenLevel;
	}
	public void setChoosenLevel(TrainingLevel choosenLevel) {
		this.choosenLevel = choosenLevel;
	}
	public UserHealthState getUserHealthState() {
		return userHealthState;
	}
	public void setUserHealthState(UserHealthState userHealthState) {
		this.userHealthState = userHealthState;
	}
	public TrainingDuration getTrainingDuradtion() {
		return trainingDuradtion;
	}
	public void setTrainingDuradtion(TrainingDuration trainingDuradtion) {
		this.trainingDuradtion = trainingDuradtion;
	}
	public Knowledge getPreviousKnowledge() {
		return previousKnowledge;
	}
	public void setPreviousKnowledge(Knowledge previousKnowledge) {
		this.previousKnowledge = previousKnowledge;
	}

	public Knowledge getSimilarKnowledge() {
		return similarKnowledge;
	}

	public void setSimilarKnowledge(Knowledge similarKnowledge) {
		this.similarKnowledge = similarKnowledge;
	}
	

	
}
