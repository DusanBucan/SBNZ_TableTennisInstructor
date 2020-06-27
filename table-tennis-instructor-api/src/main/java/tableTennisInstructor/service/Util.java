package tableTennisInstructor.service;

import tableTennisInstructor.model.User;
import tableTennisInstructor.model.drools.events.SkillExecutionEvent;
import tableTennisInstructor.model.drools.facts.UserHealth;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingChooseRequestFact;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;

import java.util.ArrayList;

public interface Util {

    ArrayList<Skill> mockAllAdnvancedSkils();
    ArrayList<Skill> mockAllIntermediateSkills();
    ArrayList<Skill> mockAllBeginnerSkils();

    ArrayList<Skill> mockAllBeginnerAndOneIntermediateSkils();
    ArrayList<Skill> mockAllIntermediateAndOneAdvancedSkils();

    ArrayList<TrainingExecution> prepareGoodTrainingHistory(ArrayList<Training> trainings);

    ArrayList<TrainingExecution> preprareNoTrainingHistory();

    Double preprareShortTrainingTime();
    Double preprareMediumTrainingTime();
    Double preprareLongTrainingTime();

    UserHealth mockGoodUserHealth(User user);
    UserHealth mockAverageUserHealth(User user);
    UserHealth mockBadUserHealth(User user);

    Training preprareAdvancedTraining(Skill skill);
    Training preprareIntermediateTraining(Skill skill);
    Training preprareBeginerTraining(Skill skill);

    ArrayList<Training> prepareTwoIntermediateAndOneBeginerTrainingAllBeginerSkills();
    ArrayList<Training> prepareTwoBeginnerAndOneIntermediate();
    ArrayList<Training> prepareTwoIntermediateAndOneAdvandec();
    ArrayList<Training> prepareAllIntermediate();
    ArrayList<Training> prepareAllAdvanced();
    ArrayList<Training> prepareAllBeginer();


    // mock functions for CEP
    ArrayList<SkillExecutionEvent> makeMissSkil(int i, Long executionId);
    ArrayList<SkillExecutionEvent> makeGoodShoots(int i, Long executionId);

    TrainingExecution makeBegginerTrainingExecution();

    ArrayList<SkillExecutionEvent> makeBadRacketAngleShots(int i, double angle, Long id, Boolean bodyPosition);

    ArrayList<SkillExecutionEvent> makeBadRacketSpeedShots(int i, double deltaSpeed, Long id, Boolean bodyPosition);

    TrainingExecution makeIntermediateTrainingExecution();

    TrainingExecution makeAdvancedTrainingExecution();
}
