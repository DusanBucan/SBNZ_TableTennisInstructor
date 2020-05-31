import { SkillEntity } from '../skill-model/skill.model';

export class TrainingSearchEntity {
    public trainingDuration: number;
    public userHealth: any;
    public userId: number;
    public desiredSkillId: number;
    
    constructor(userId: number, userHealth: any, desiredSkillId: number, duration: number) {
        this.userId = userId;
        this.userHealth = userHealth;
        this.desiredSkillId = desiredSkillId;
        this.trainingDuration = duration;
    }
}
