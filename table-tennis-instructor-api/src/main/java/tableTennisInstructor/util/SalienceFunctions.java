package tableTennisInstructor.util;


import tableTennisInstructor.model.drools.facts.training.TrainingChooseRequestFact;

public class SalienceFunctions {

    public static int shortTrainingDurationSalience(TrainingChooseRequestFact fact) {
        if (fact.getTrainingDuration() < 3) {
            return 1;
        }
        return 0;
    }

    public static int intermediateTrainingDurationSalience(TrainingChooseRequestFact fact) {
        if (fact.getTrainingDuration() >= 3 && fact.getTrainingDuration() < 4) {
            return 1;
        }
        return 0;
    }

    public static int longTrainingDurationSalience(TrainingChooseRequestFact fact) {
        if (fact.getTrainingDuration() >= 4) {
            return 1;
        }
        return 0;
    }


}
