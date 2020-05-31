export class TrainingDrillEntity {
    public id: number;
    public description: string;
    public repetitons: string;

    constructor(id?: number, description?: string, repetitons?: string) {
        this.id = id;
        this.repetitons = repetitons;
        this.description = description;
    }
}