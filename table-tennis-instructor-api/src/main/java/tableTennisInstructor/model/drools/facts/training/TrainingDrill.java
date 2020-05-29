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
}
