package tableTennisInstructor.model.drools.events;

import org.drools.core.factmodel.traits.Traitable;
import org.kie.api.definition.type.Duration;
import org.kie.api.definition.type.PropertyReactive;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
@Timestamp("executionTime")
@PropertyReactive
public class SkillExecutionEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    public Boolean result;
    public Boolean rightBodyMovement;
    public Double deltaSpeed;
    public Double deltaAngle;
    public Long trainingExecutionId;
    public int id;
    public Date executionTime;



    // for rules helper atributes
    public Boolean missProcessed = false;
    public Boolean badBodyPositionProcessed = false;
    public Boolean badRacketAngleProcessed = false;
    public Boolean badRacketSpeedProcessed = false;


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

    public void setMissProcessed(Boolean missProcessed) {
        this.missProcessed = missProcessed;
    }

    public void setBadBodyPositionProcessed(Boolean badBodyPositionProcessed) {
        this.badBodyPositionProcessed = badBodyPositionProcessed;
    }

    public Boolean getMissProcessed() {
        return missProcessed;
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

    public Boolean getBadRacketSpeedProcessed() {
        return badRacketSpeedProcessed;
    }

    public void setBadRacketSpeedProcessed(Boolean badRacketSpeedProcessed) {
        this.badRacketSpeedProcessed = badRacketSpeedProcessed;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }
    public Date getExecutionTime() {
        return executionTime;
    }
}

