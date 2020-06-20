package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.PropertyReactive;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.io.Serializable;
import java.util.Date;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("6s")
@PropertyReactive
public class ToMuchSuccessiveMiss implements Serializable {

    private static final long serialVersionUID = 1L;
    public String message = "";
    public Boolean processed = false;
    public Date executionTime;
    public Long trainingId;


    public ToMuchSuccessiveMiss(Long trainingId) {
        this.processed = false;
        this.executionTime = new Date();
        this.trainingId = trainingId;
    }

    public ToMuchSuccessiveMiss(String message, Long trainingId) {
        this.message = message;
        this.processed = false;
        this.executionTime = new Date();
        this.trainingId = trainingId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public Long getTrainingId() {
        return trainingId;
    }

    public Date getExecutionTime() {
        return executionTime;
    }
}
