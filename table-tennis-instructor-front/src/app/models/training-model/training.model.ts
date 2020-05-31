import { SkillEntity } from '../skill-model/skill.model';
import { TrainingLevelType } from './training-level.enum';
import { TrainingDrillEntity } from './training-drill.model';
import { TrainingMistakeEntity } from './training-mistake.model';

export class TrainingEntity {
    public id: number;
    public skill: SkillEntity;
    public trainingLevel: TrainingLevelType;
    public timeToExecute: number;
    public drills: TrainingDrillEntity[];
    public mostCommonMistakes: TrainingMistakeEntity[];

    constructor(id: number, skill: SkillEntity, trainingLevel: TrainingLevelType,
                timeToExecute: number, drills: TrainingDrillEntity[], mostCommonMistakes: TrainingMistakeEntity[] ) {
        this.id = id;
        this.skill = skill;
        this.trainingLevel = trainingLevel;
        this.timeToExecute = timeToExecute;
        this.drills = drills;
        this.mostCommonMistakes = mostCommonMistakes;
    }
}
