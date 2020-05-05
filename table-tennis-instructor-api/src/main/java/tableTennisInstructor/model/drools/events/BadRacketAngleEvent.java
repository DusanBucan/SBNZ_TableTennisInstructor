package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Role;

import java.io.Serializable;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
public class BadRacketAngleEvent implements Serializable {


    public Boolean processed = false;
    public Double angle;

    public  BadRacketAngleEvent(){
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public Double getAngle() {
        return angle;
    }
}
