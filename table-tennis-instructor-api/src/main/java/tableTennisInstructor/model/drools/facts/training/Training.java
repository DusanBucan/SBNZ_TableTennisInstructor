package tableTennisInstructor.model.drools.facts.training;

import tableTennisInstructor.model.drools.facts.skill.Skill;
import java.util.ArrayList;

public class Training {

    public TrainingLevel trainingLevel;
    public Skill skill;
    public ArrayList<TrainingMistake> mostCommonMistakes;
    public Double timeToExecute;
    public ArrayList<TrainingDrill> drills;
    
    public Training() {}
    
	public TrainingLevel getTrainingLevel() {
		return trainingLevel;
	}
	public void setTrainingLevel(TrainingLevel trainingLevel) {
		this.trainingLevel = trainingLevel;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public ArrayList<TrainingMistake> getMostCommonMistakes() {
		return mostCommonMistakes;
	}
	public void setMostCommonMistakes(ArrayList<TrainingMistake> mostCommonMistakes) {
		this.mostCommonMistakes = mostCommonMistakes;
	}
	public Double getTimeToExecute() {
		return timeToExecute;
	}
	public void setTimeToExecute(Double timeToExecute) {
		this.timeToExecute = timeToExecute;
	}
	public ArrayList<TrainingDrill> getDrills() {
		return drills;
	}
	public void setDrills(ArrayList<TrainingDrill> drills) {
		this.drills = drills;
	}
    
    
    
}
