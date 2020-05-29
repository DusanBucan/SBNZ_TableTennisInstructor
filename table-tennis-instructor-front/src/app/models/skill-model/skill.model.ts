import { SkillLevelType } from './skill-level.enum';

export class SkillEntity {
    public skillId: number;
    public name: string;
    public executionDescription: string;
    public skillLevel: SkillLevelType;
    public skillGroup: number;


    constructor(id?: number, name?: string, description?: string,
                skillGroup?: number, skillLevel?: SkillLevelType) {
        this.skillId = id;
        this.name = name;
        this.executionDescription = description;
        this.skillGroup = skillGroup;
        this.skillLevel = skillLevel;
    }
}