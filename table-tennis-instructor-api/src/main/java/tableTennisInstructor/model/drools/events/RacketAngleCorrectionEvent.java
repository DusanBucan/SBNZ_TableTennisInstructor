package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("6s")
public class RacketAngleCorrectionEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    public Date executionTime;
    public String message;
    public Boolean processed = false;
    public String id;
    public Long trainigExecutionId;

    public RacketAngleCorrectionEvent(Long trainigExecutionId){
        this.processed = false;
        this.id = UUID.randomUUID().toString();
        this.executionTime = new Date();
        this.trainigExecutionId = trainigExecutionId;
    }

    public RacketAngleCorrectionEvent(Date timeStamp){
        this.processed = false;
        this.id = UUID.randomUUID().toString();
        this.executionTime = timeStamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessage() {
        return message;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public String getId() {
        return id;
    }

    public void setTrainigExecutionId(Long trainigExecutionId) {
        this.trainigExecutionId = trainigExecutionId;
    }

    public Long getTrainigExecutionId() {
        return trainigExecutionId;
    }
}
