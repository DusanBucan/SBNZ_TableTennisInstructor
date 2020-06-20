package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.text.SimpleDateFormat;
import java.util.Date;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("6s")
public class MissEvent {

    private static final long serialVersionUID = 1L;
    public Boolean processed = false;
    public Date executionTime;
    public Long trainingExecutionId;

    public MissEvent(Long trainingExecutionId) {
        this.processed = false;
        this.executionTime = new Date();
        this.trainingExecutionId = trainingExecutionId;

        String desiredStringFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        SimpleDateFormat outputFormat = new SimpleDateFormat(desiredStringFormat);
        System.out.println(outputFormat.format(this.executionTime));
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public Long getTrainingExecutionId() {
        return trainingExecutionId;
    }

    public void setTrainingExecutionId(Long trainingExecutionId) {
        this.trainingExecutionId = trainingExecutionId;
    }
}
