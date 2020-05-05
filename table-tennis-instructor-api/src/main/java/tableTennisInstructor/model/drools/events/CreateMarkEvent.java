package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Role;

import java.io.Serializable;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
public class CreateMarkEvent implements Serializable {
    private static final long serialVersionUID = 1L;

    public Boolean processed;
    public CreateMarkEvent(){
        this.processed =false;
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
