package tableTennisInstructor.model.drools.facts.training;

import org.kie.api.definition.type.PropertyReactive;
import tableTennisInstructor.dto.request.TrainingHistorySearchDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TrainingReportFact {

    public Long userId;
    public TrainingMark trainingMark;
    public Long skillId;
    public Date beforeDate;
    public ArrayList<TrainingExecution> trExecutionsIdMeetCondition;
    public Boolean processed;


    public TrainingReportFact(){
        trExecutionsIdMeetCondition = new ArrayList<>();
        this.processed = false;
    }

    public TrainingReportFact(Long userId, TrainingMark trainingMark, Long skillId, Date forMonths) {
        this.userId = userId;
        this.trainingMark = trainingMark;
        this.skillId = skillId;
        this.beforeDate = forMonths;
        this.processed = false;
    }

    public TrainingReportFact(TrainingHistorySearchDTO dto) {
        this.userId = dto.userId;
        this.setForMonths(dto.forMonths);
        this.setSkillId(dto.skillId);
        this.trainingMark = dto.trainingMark;
        this.processed =false;
        this.trExecutionsIdMeetCondition = new ArrayList<>();
    }


    public void setForMonths(int forMonths) {
        if(forMonths < 1) {
                forMonths = 2400; // ovo je poslednjih 20 godinas
        }
        Calendar c =Calendar.getInstance();
        c.add(Calendar.MONTH, forMonths*-1);
        this.beforeDate = c.getTime();
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public void setTrExecutionsIdMeetCondition(ArrayList<Object> arrayList) {
        for(Object tr: arrayList) {
            this.trExecutionsIdMeetCondition.add((TrainingExecution)tr);
        }
    }

    public ArrayList<TrainingExecution> getTrExecutionsIdMeetCondition() {
        return trExecutionsIdMeetCondition;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }
}
