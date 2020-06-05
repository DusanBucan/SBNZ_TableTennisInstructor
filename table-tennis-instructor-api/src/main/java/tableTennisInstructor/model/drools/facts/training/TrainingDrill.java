package tableTennisInstructor.model.drools.facts.training;

import javax.persistence.*;

@Entity
@Table(name = "trainingDrill")
public class TrainingDrill {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String description;
    private Integer repetitons;

    public TrainingDrill() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRepetitons(Integer repetitons) {
        this.repetitons = repetitons;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Integer getRepetitons() {
        return repetitons;
    }
}
