package tableTennisInstructor.model.drools.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import tableTennisInstructor.repository.SkillRepository;

import java.io.Serializable;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
@Expires("1h")
public class SkillCorrectionEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    public Long traininExecutionId;
    public String message;

    public SkillCorrectionEvent(Long traininExecutionId, String message) {
        this.traininExecutionId = traininExecutionId;
        this.message = "SkillCorrection: " + message;
    }

}
