import { TrainingMarkType } from './training.mark.enum';
import {TrainingEntity} from '../training-model/training.model';

export class TrainingHistoryEntity {
    public id: number;
    public training: TrainingEntity;
    public date: Date;
    public trainingMark: TrainingMarkType;

    constructor(id?: number, training?: TrainingEntity, date?: Date, trainingMark?: TrainingMarkType ) {
        this.id = id;
        this.training = training;
        this.date = date;
        this.trainingMark = trainingMark;
    }
}
