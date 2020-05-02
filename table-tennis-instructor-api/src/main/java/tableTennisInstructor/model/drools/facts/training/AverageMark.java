package tableTennisInstructor.model.drools.facts.training;

public class AverageMark {

	public TrainingMark trainingMark;
	public Long userId;
	
	public AverageMark() {}
	
	public TrainingMark getTrainingMark() {
		return trainingMark;
	}
	public void setTrainingMark(TrainingMark trainingMark) {
		this.trainingMark = trainingMark;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
