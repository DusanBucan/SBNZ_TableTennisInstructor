package tableTennisInstructor.model.drools.facts.skill;

public class Skill {

	public Long skillId;
	public String name;
	public String execution_description;
	public SkillLevel skillLevel;
	
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
		return execution_description;
	}
	public void setExecution_description(String execution_description) {
		this.execution_description = execution_description;
	}
	public SkillLevel getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(SkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}
	
	
}
