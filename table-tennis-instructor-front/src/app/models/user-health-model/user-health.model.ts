
export class UserHealthEntity {
    public id: number;
    public userId: number;
    public heartbeat: number;
    public systolic: number;
    public diastolic: number;


    constructor(id?: number, userId?: number, heartbeat?: number,
                systolic?: number, diastolic?: number) {
        this.id = id;
        this.userId = userId;
        this.heartbeat = heartbeat;
        this.systolic = systolic;
        this.diastolic = diastolic;
    }
}
