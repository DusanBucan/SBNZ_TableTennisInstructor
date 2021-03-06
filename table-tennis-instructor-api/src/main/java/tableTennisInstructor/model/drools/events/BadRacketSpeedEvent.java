package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.io.Serializable;
import java.util.Date;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("6s")
public class BadRacketSpeedEvent  implements Serializable {

    public Date executionTime;
    public Boolean processed = false;
    public Double speed;
    public Long trainingExecutionId;

    public BadRacketSpeedEvent(Long trainingExecutionId){
        this.processed = false;
        this.executionTime = new Date();
        this.trainingExecutionId = trainingExecutionId;
    }

    public BadRacketSpeedEvent(Date time){
        this.processed = false;
        this.executionTime = time;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setTrainingExecutionId(Long trainingExecutionId) {
        this.trainingExecutionId = trainingExecutionId;
    }

    public Long getTrainingExecutionId() {
        return trainingExecutionId;
    }
}
