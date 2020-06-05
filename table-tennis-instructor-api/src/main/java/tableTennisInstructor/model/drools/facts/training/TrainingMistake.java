package tableTennisInstructor.model.drools.facts.training;

import javax.persistence.*;

@Entity
@Table(name = "trainingMistake")
public class TrainingMistake {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String description;
    private String solution;

    public TrainingMistake(){super();}

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getSolution() {
        return solution;
    }
}
