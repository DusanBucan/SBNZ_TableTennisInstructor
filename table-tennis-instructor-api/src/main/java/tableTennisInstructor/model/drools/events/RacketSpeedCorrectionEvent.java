package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.io.Serializable;
import java.util.Date;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("6s")
public class RacketSpeedCorrectionEvent implements Serializable {
    private static final long serialVersionUID = 1L;

    public Date executionTime;
    public String message;
    public Boolean processed = false;
    public Long trainigExecutionId;

    public RacketSpeedCorrectionEvent(Long trainigExecutionId) {
        this.processed = false;
        this.executionTime = new Date();
        this.trainigExecutionId = trainigExecutionId;
    }

    public RacketSpeedCorrectionEvent(Date time) {
        this.processed = false;
        this.executionTime = time;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setTrainigExecutionId(Long trainigExecutionId) {
        this.trainigExecutionId = trainigExecutionId;
    }

    public Long getTrainigExecutionId() {
        return trainigExecutionId;
    }
}
