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
}
