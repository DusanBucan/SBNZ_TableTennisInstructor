package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.io.Serializable;
import java.util.Date;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
@Timestamp("executionTime")
public class BadBodyPositionEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    public Boolean processed = false;
    public Long traininExecutionId;
    public Date executionTime;
    public String message;

    public BadBodyPositionEvent(Long traininExecutionId){
        this.processed = false;
        this.traininExecutionId = traininExecutionId;
        this.executionTime = new Date();
        this.message = "UZASTUPNI LOSI POLOZAJI TELA";
    }

    public BadBodyPositionEvent() {
        this.processed = false;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setTraininExecutionId(Long traininExecutionId) {
        this.traininExecutionId = traininExecutionId;
    }

    public Long getTraininExecutionId() {
        return traininExecutionId;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public Date getExecutionTime() {
        return executionTime;
    }
}
