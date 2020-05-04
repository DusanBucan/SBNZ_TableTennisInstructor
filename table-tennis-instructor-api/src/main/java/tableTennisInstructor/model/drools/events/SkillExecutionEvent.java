package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Role;

import java.io.Serializable;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
public class SkillExecutionEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    public Boolean result;
    public Boolean rightBodyMovement;
    public Double deltaSpeed;
    public Double deltaAngle;
    public Long trainingExecutionId;

    public SkillExecutionEvent() {
    }

    public SkillExecutionEvent(Boolean result, Boolean rightBodyMovement, Double deltaSpeed, Double deltaAngle, Long trainingExecutionId) {
        this.result = result;
        this.rightBodyMovement = rightBodyMovement;
        this.deltaSpeed = deltaSpeed;
        this.deltaAngle = deltaAngle;
        this.trainingExecutionId = trainingExecutionId;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public void setRightBodyMovement(Boolean rightBodyMovement) {
        this.rightBodyMovement = rightBodyMovement;
    }

    public void setDeltaSpeed(Double deltaSpeed) {
        this.deltaSpeed = deltaSpeed;
    }

    public void setDeltaAngle(Double deltaAngle) {
        this.deltaAngle = deltaAngle;
    }

    public void setTrainingExecutionId(Long trainingExecutionId) {
        this.trainingExecutionId = trainingExecutionId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Boolean getResult() {
        return result;
    }

    public Boolean getRightBodyMovement() {
        return rightBodyMovement;
    }

    public Double getDeltaSpeed() {
        return deltaSpeed;
    }

    public Double getDeltaAngle() {
        return deltaAngle;
    }

    public Long getTrainingExecutionId() {
        return trainingExecutionId;
    }
}
