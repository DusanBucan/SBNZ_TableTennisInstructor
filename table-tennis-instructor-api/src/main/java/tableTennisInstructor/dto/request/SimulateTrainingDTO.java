package tableTennisInstructor.dto.request;

public class SimulateTrainingDTO {

    public Long trainingId;
    public Long userId;

    SimulateTrainingDTO() {}

    public SimulateTrainingDTO(Long trainingId, Long userId) {
        this.trainingId = trainingId;
        this.userId = userId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTrainingId() {
        return trainingId;
    }

    public Long getUserId() {
        return userId;
    }
}
