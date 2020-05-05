package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Role;

import java.io.Serializable;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
public class BadRacketSpeedEvent  implements Serializable {

    public Boolean processed = false;
    public Double speed;

    public BadRacketSpeedEvent(){
        this.processed = false;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public Double getSpeed() {
        return speed;
    }
}
