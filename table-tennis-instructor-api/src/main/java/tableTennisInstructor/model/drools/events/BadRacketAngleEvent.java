package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
@PropertyReactive
@Timestamp("executionTime")
@Expires("6s")
public class BadRacketAngleEvent implements Serializable {

    public Date executionTime;
    public Boolean processed = false;
    public Double angle;
    public String id;
    public Long trainingExecutionId;
    public int duration;

    public  BadRacketAngleEvent(Long trainingExecutionId){
        this.processed = false;
        this.id = UUID.randomUUID().toString();
        this.executionTime = new Date();
        this.trainingExecutionId = trainingExecutionId;
    }

    public  BadRacketAngleEvent(Date time){
        this.processed = false;
        this.id = UUID.randomUUID().toString();
        this.executionTime = time;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public Double getAngle() {
        return angle;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public String getId() {
        return id;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTrainingExecutionId(Long trainingExecutionId) {
        this.trainingExecutionId = trainingExecutionId;
    }

    public Long getTrainingExecutionId() {
        return trainingExecutionId;
    }
}
