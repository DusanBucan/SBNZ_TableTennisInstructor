package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Role;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
public class RacketAngleCorrectionEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    public String message;
    public Boolean processed = false;
    public String id;

    public RacketAngleCorrectionEvent(){
        this.processed = false;
        this.id = UUID.randomUUID().toString();
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
}
