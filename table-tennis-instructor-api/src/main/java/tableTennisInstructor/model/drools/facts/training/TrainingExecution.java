package tableTennisInstructor.model.drools.facts.training;


import tableTennisInstructor.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trainingExecution")
public class TrainingExecution {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
    public User user;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="training_id")
    public Training training;

	@Column(name = "date")
    public Date date;

	@Enumerated(EnumType.STRING)
	@Column(name = "trainingMark")
    public TrainingMark trainingMark;
    
    public TrainingExecution() {
    	trainingMark = TrainingMark.UNKNOWN;
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Training getTraining() {
		return training;
	}
	public void setTraining(Training training) {
		this.training = training;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TrainingMark getTrainingMark() {
		return trainingMark;
	}
	public void setTrainingMark(TrainingMark trainingMark) {
		this.trainingMark = trainingMark;
	}
    
    
}
