package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Role;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
public class EndTrainingEvent {

    private static final long serialVersionUID = 1L;

    public Boolean processed;

    public EndTrainingEvent() {
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
}
