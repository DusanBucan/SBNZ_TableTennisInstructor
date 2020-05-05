package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Role;

import java.io.Serializable;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
public class ToMuchSuccessiveMiss implements Serializable {

    private static final long serialVersionUID = 1L;
    public String message = "";
    public Boolean processed = false;


    public ToMuchSuccessiveMiss() {
        this.processed = false;
    }

    public ToMuchSuccessiveMiss(String message) {
        this.message = message;
        this.processed = false;
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

}
