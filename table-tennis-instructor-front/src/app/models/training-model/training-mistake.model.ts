export class TrainingMistakeEntity {
    public id: number;
    public description: string;
    public solution: string;

    constructor(id?: number, description?: string, solution?: string) {
        this.id = id;
        this.solution = solution;
        this.description = description;
    }
}