package tableTennisInstructor.model.drools.facts.skill;

import java.util.ArrayList;
import java.util.List;

public class SimilarSkillFact {

    public Skill skill;
    public List<Long> similarSkills;

    public SimilarSkillFact() {
        similarSkills = new ArrayList<>();
    }

    public Skill getSkill() {
        return skill;
    }
    public void setSkill(Skill skill) {
        this.skill = skill;
    }
    public List<Long> getSimilarSkills() {
        return similarSkills;
    }
    public void setSimilarSkills(ArrayList<Long> similarSkills) {
        this.similarSkills = similarSkills;
    }
    public void addSimilarSkill(Skill similarSkill) {
        this.similarSkills.add(similarSkill.getSkillId());
    }


}
