package tableTennisInstructor.dto.response;

import javax.persistence.Column;

public class UserHealthDTO {

    public Long id;
    public Long userId;
    public Integer heartbeat;
    public Integer systolic;
    public Integer diastolic;

    public UserHealthDTO(){}

    public UserHealthDTO(Long id, Long userId, Integer heartbeat, Integer systolic, Integer diastolic) {
        this.id = id;
        this.userId = userId;
        this.heartbeat = heartbeat;
        this.systolic = systolic;
        this.diastolic = diastolic;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getHeartbeat() {
        return heartbeat;
    }

    public Integer getSystolic() {
        return systolic;
    }

    public Integer getDiastolic() {
        return diastolic;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setHeartbeat(Integer heartbeat) {
        this.heartbeat = heartbeat;
    }

    public void setSystolic(Integer systolic) {
        this.systolic = systolic;
    }

    public void setDiastolic(Integer diastolic) {
        this.diastolic = diastolic;
    }
}
