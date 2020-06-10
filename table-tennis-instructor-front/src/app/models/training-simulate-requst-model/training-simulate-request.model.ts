export class SimulateTrainingEntity {

    trainingId: number;
    userId: number;

    constructor(trainingId?: number, userId?: number) {
        this.trainingId = trainingId;
        this.userId = userId;
    }

}