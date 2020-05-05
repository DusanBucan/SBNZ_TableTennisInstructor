package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Role;

import java.io.Serializable;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
public class RacketSpeedCorrectionEvent implements Serializable {
    private static final long serialVersionUID = 1L;

    public String message;
    public Boolean processed = false;

    public RacketSpeedCorrectionEvent() {
        this.processed = false;
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
}
