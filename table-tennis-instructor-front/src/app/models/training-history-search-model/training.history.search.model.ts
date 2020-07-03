
import { TrainingMarkType } from '../training-history-model/training.mark.enum';

export class TrainingHistorySearchEntity {
    public userId: number;
    public skillId: number;
    public trainingMark: TrainingMarkType;
    public forMonths: number;

    constructor(userId: number, skillId: number, trainingMark: TrainingMarkType, forMonths: number) {
        this.userId = userId;
        this.skillId = skillId;
        this.trainingMark = trainingMark;
        this.forMonths = forMonths;
    }
}
