package tableTennisInstructor.model.drools.facts.skill;

import javax.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "skillId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long skillId;

	@Column(name = "name")
	public String name;

	@Column(name = "executionDescription")
	public String executionDescription;

	@Enumerated(EnumType.STRING)
	@Column(name = "skillLevel")
	public SkillLevel skillLevel;

	@Column(name = "skillGroup")
	public int skillGroup;

	public Skill() {}

	public Long getSkillId() {
		return skillId;
	}
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getExecution_description() {
		return executionDescription;
	}
	public void setExecution_description(String execution_description) {
		this.executionDescription = execution_description;
	}
	public SkillLevel getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(SkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}

	public int getSkillGroup() {
		return skillGroup;
	}

	public void setSkillGroup(int skillGroup) {
		this.skillGroup = skillGroup;
	}
	
	
}
