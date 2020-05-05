package tableTennisInstructor.model.drools.events;

import org.drools.core.factmodel.traits.Traitable;
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
    public int id;


    // for rules helper atributes
    public Boolean toMuchSuccesiveMissProcessed = false;
    public Boolean badBodyPositionProcessed = false;
    public Boolean badRacketAngleProcessed = false;


    public SkillExecutionEvent() {
    }

    public SkillExecutionEvent(int id, Boolean result, Boolean rightBodyMovement,
                               Double deltaSpeed, Double deltaAngle, Long trainingExecutionId) {
        this.result = result;
        this.rightBodyMovement = rightBodyMovement;
        this.deltaSpeed = deltaSpeed;
        this.deltaAngle = deltaAngle;
        this.trainingExecutionId = trainingExecutionId;
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setToMuchSuccesiveMissProcessed(Boolean toMuchSuccesiveMissProcessed) {
        this.toMuchSuccesiveMissProcessed = toMuchSuccesiveMissProcessed;
    }

    public void setBadBodyPositionProcessed(Boolean badBodyPositionProcessed) {
        this.badBodyPositionProcessed = badBodyPositionProcessed;
    }

    public Boolean getToMuchSuccesiveMissProcessed() {
        return toMuchSuccesiveMissProcessed;
    }

    public Boolean getBadBodyPositionProcessed() {
        return badBodyPositionProcessed;
    }

    public Boolean getBadRacketAngleProcessed() {
        return badRacketAngleProcessed;
    }

    public void setBadRacketAngleProcessed(Boolean badRacketAngleProcessed) {
        this.badRacketAngleProcessed = badRacketAngleProcessed;
    }
}

