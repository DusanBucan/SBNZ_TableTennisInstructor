package tableTennisInstructor.model.drools.facts.training;


import tableTennisInstructor.model.User;

import java.util.Date;

//@Entity
//@Table(name = "trainningExecutions")
public class TrainingExecution {

//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public User user;
    public Training training;
    public Date date;
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
