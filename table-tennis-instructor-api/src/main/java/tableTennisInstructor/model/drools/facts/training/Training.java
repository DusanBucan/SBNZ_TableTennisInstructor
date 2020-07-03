package tableTennisInstructor.model.drools.facts.training;

import tableTennisInstructor.model.drools.facts.skill.Skill;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "training")
public class Training {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "trainingLevel")
    public TrainingLevel trainingLevel;

	@Column(name = "timeToExecute")
	public Double timeToExecute;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name="skill_id")
	public Skill skill;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "training_mistake_join",
			joinColumns = @JoinColumn(name = "training_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "mistake_id", referencedColumnName = "id"))
    public List<TrainingMistake> mostCommonMistakes;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "training_drill_join",
			joinColumns = @JoinColumn(name = "training_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "drill_id", referencedColumnName = "id"))
    public Collection<TrainingDrill> drills;
    
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
		return new ArrayList<>(mostCommonMistakes);
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
		return new ArrayList<>(drills);
	}
	public void setDrills(ArrayList<TrainingDrill> drills) {
		this.drills = drills;
	}
    
    
    
}
