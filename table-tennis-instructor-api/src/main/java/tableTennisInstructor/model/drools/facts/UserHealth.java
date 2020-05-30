package tableTennisInstructor.model.drools.facts;

import tableTennisInstructor.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "userHealth")
public class UserHealth {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "date")
    private Date date;

    @Column(name = "heartbeat")
    private Integer heartbeat;

    @Column(name = "systolic")
    private Integer systolic;

    @Column(name = "diastolic")
    private Integer diastolic;

    @Enumerated(EnumType.STRING)
    @Column(name = "userHealthState")
    private UserHealthState userHealthState;

    public UserHealth() {
    }

    public UserHealth(User user, Date date, Integer heartbeat,
                      Integer systolic, Integer diastolic,
                      UserHealthState userHealthState) {
        this.user = user;
        this.date = date;
        this.heartbeat = heartbeat;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.userHealthState = userHealthState;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSystolic(Integer systolic) {
        this.systolic = systolic;
    }

    public void setDiastolic(Integer diastolic) {
        this.diastolic = diastolic;
    }

    public void setHeartbeat(Integer heartbeat) {
        this.heartbeat = heartbeat;
    }

    public void setUserHealthState(UserHealthState userHealthState) {
        this.userHealthState = userHealthState;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public Long getId() {
        return id;
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

    public UserHealthState getUserHealthState() {
        return userHealthState;
    }

}
