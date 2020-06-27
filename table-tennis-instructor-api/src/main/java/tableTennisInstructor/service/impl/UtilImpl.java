package tableTennisInstructor.service.impl;

import org.springframework.stereotype.Service;
import tableTennisInstructor.model.User;
import tableTennisInstructor.model.drools.events.SkillExecutionEvent;
import tableTennisInstructor.model.drools.facts.UserHealth;
import tableTennisInstructor.model.drools.facts.UserHealthState;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.skill.SkillLevel;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.model.drools.facts.training.TrainingLevel;
import tableTennisInstructor.model.drools.facts.training.TrainingMark;
import tableTennisInstructor.service.Util;

import java.util.ArrayList;
import java.util.Date;

@Service
public class UtilImpl implements Util {


    @Override
    public ArrayList<Skill> mockAllBeginnerSkils() {
        ArrayList<Skill> allSkills = new ArrayList<>();

        Skill skill = new Skill();
        skill.setSkillId(1l);
        skill.setSkillLevel(SkillLevel.BEGINER);
        skill.setSkillGroup(1);

        Skill skill1 = new Skill();
        skill1.setSkillId(2l);
        skill1.setSkillLevel(SkillLevel.BEGINER);
        skill1.setSkillGroup(1);

        Skill skill2 = new Skill();
        skill2.setSkillId(3l);
        skill2.setSkillLevel(SkillLevel.BEGINER);
        skill2.setSkillGroup(1);

        Skill skill4 = new Skill();
        skill4.setSkillId(4l);
        skill4.setSkillLevel(SkillLevel.BEGINER);
        skill4.setSkillGroup(1);

        Skill skill5 = new Skill();
        skill5.setSkillId(1l);
        skill5.setSkillGroup(1);

        allSkills.add(skill);
        allSkills.add(skill1);
        allSkills.add(skill2);
        allSkills.add(skill4);
        allSkills.add(skill5);

        return allSkills;
    }

    @Override
    public ArrayList<Skill> mockAllIntermediateSkills() {
        ArrayList<Skill> allSkills = new ArrayList<>();

        Skill skill = new Skill();
        skill.setSkillId(1l);
        skill.setSkillLevel(SkillLevel.INTERMEDIATE);
        skill.setSkillGroup(1);

        Skill skill1 = new Skill();
        skill1.setSkillId(2l);
        skill1.setSkillLevel(SkillLevel.INTERMEDIATE);
        skill1.setSkillGroup(1);

        Skill skill2 = new Skill();
        skill2.setSkillId(3l);
        skill2.setSkillLevel(SkillLevel.INTERMEDIATE);
        skill2.setSkillGroup(1);

        Skill skill4 = new Skill();
        skill4.setSkillId(4l);
        skill4.setSkillLevel(SkillLevel.INTERMEDIATE);
        skill4.setSkillGroup(1);

        Skill skill5 = new Skill();
        skill5.setSkillId(2l);
        skill5.setSkillGroup(1);

        allSkills.add(skill);
        allSkills.add(skill1);
        allSkills.add(skill2);
        allSkills.add(skill4);
        allSkills.add(skill5);
        return allSkills;
    }

    @Override
    public ArrayList<Skill> mockAllAdnvancedSkils() {
        ArrayList<Skill> allSkills = new ArrayList<>();

        Skill skill = new Skill();
        skill.setSkillId(1l);
        skill.setSkillGroup(1);

        Skill skill2 = new Skill();
        skill2.setSkillId(2l);
        skill2.setSkillLevel(SkillLevel.ADVANCED);
        skill2.setSkillGroup(1);

        Skill skill3 = new Skill();
        skill3.setSkillId(3l);
        skill3.setSkillLevel(SkillLevel.ADVANCED);
        skill3.setSkillGroup(1);

        Skill skill4 = new Skill();
        skill4.setSkillId(4l);
        skill4.setSkillLevel(SkillLevel.ADVANCED);
        skill4.setSkillGroup(1);

        Skill skill5 = new Skill();
        skill5.setSkillId(2l);
        skill5.setSkillGroup(1);

        allSkills.add(skill);
        allSkills.add(skill2);
        allSkills.add(skill3);
        allSkills.add(skill4);
        allSkills.add(skill5);

        return allSkills;
    }

    @Override
    public ArrayList<Skill> mockAllBeginnerAndOneIntermediateSkils() {
        ArrayList<Skill> allSkills = new ArrayList<>();

        Skill skill = new Skill();
        skill.setSkillId(1l);
        skill.setSkillGroup(1);

        Skill skill2 = new Skill();
        skill2.setSkillId(2l);
        skill2.setSkillLevel(SkillLevel.BEGINER);
        skill2.setSkillGroup(1);

        Skill skill3 = new Skill();
        skill3.setSkillId(3l);
        skill3.setSkillLevel(SkillLevel.INTERMEDIATE);
        skill3.setSkillGroup(1);

        Skill skill4 = new Skill();
        skill4.setSkillId(4l);
        skill4.setSkillLevel(SkillLevel.BEGINER);
        skill4.setSkillGroup(1);

        Skill skill5 = new Skill();
        skill5.setSkillId(5l);
        skill5.setSkillGroup(1);

        allSkills.add(skill);
        allSkills.add(skill2);
        allSkills.add(skill3);
        allSkills.add(skill4);
        allSkills.add(skill5);

        return allSkills;
    }

    @Override
    public ArrayList<Skill> mockAllIntermediateAndOneAdvancedSkils() {
        ArrayList<Skill> allSkills = new ArrayList<>();

        Skill skill = new Skill();
        skill.setSkillId(1l);
        skill.setSkillGroup(1);

        Skill skill1 = new Skill();
        skill1.setSkillId(2l);
        skill1.setSkillLevel(SkillLevel.INTERMEDIATE);
        skill1.setSkillGroup(1);

        Skill skill2 = new Skill();
        skill2.setSkillId(3l);
        skill2.setSkillLevel(SkillLevel.ADVANCED);
        skill2.setSkillGroup(1);

        Skill skill4 = new Skill();
        skill4.setSkillId(4l);
        skill4.setSkillLevel(SkillLevel.INTERMEDIATE);
        skill4.setSkillGroup(1);

        Skill skill5 = new Skill();
        skill5.setSkillId(5l);
        skill5.setSkillGroup(1);

        allSkills.add(skill);
        allSkills.add(skill1);
        allSkills.add(skill2);
        allSkills.add(skill4);
        allSkills.add(skill5);
        return allSkills;
    }




    @Override
    public Double preprareShortTrainingTime() {
        return 1.5;
    }

    @Override
    public Double preprareMediumTrainingTime() {
        return 3.0;
    }

    @Override
    public Double preprareLongTrainingTime() {
        return 4.5;
    }

    @Override
    public UserHealth mockGoodUserHealth(User user) {
        return new UserHealth(user,new Date(), 65, 124, 72, UserHealthState.UNKNOWN);
    }

    @Override
    public UserHealth mockAverageUserHealth(User user) {
        return new UserHealth(user,new Date(), 75, 124, 72, UserHealthState.UNKNOWN);
    }

    @Override
    public UserHealth mockBadUserHealth(User user) {
        return new UserHealth(user,new Date(), 85, 124, 72, UserHealthState.UNKNOWN);
    }

    @Override
    public Training preprareAdvancedTraining(Skill skill) {
        Training trening =  new Training();
        trening.setSkill(skill);
        trening.setTrainingLevel(TrainingLevel.ADVANCED);
        return trening;
    }

    @Override
    public Training preprareIntermediateTraining(Skill skill) {
        Training trening =  new Training();
        trening.setSkill(skill);
        trening.setTrainingLevel(TrainingLevel.INTERMEDIATE);
        return trening;
    }

    @Override
    public Training preprareBeginerTraining(Skill skill) {
        Training trening =  new Training();
        trening.setSkill(skill);
        trening.setTrainingLevel(TrainingLevel.BEGINNER);
        return trening;
    }

    @Override
    public ArrayList<Training> prepareTwoIntermediateAndOneBeginerTrainingAllBeginerSkills() {
        ArrayList<Skill> skills = this.mockAllIntermediateSkills();
        ArrayList<Training> trainings = new ArrayList<>();

        trainings.add(preprareIntermediateTraining(skills.get(0)));
        trainings.add(preprareIntermediateTraining(skills.get(1)));
        trainings.add(preprareBeginerTraining(skills.get(2)));
        return trainings;
    }

    @Override
    public ArrayList<Training> prepareTwoBeginnerAndOneIntermediate() {
        ArrayList<Skill> skills = this.mockAllBeginnerSkils();
        ArrayList<Training> trainings = new ArrayList<>();

        trainings.add(preprareIntermediateTraining(skills.get(0)));
        trainings.add(preprareBeginerTraining(skills.get(1)));
        trainings.add(preprareBeginerTraining(skills.get(2)));
        return trainings;
    }

    @Override
    public ArrayList<Training> prepareTwoIntermediateAndOneAdvandec() {
        ArrayList<Skill> skills = this.mockAllBeginnerSkils();
        ArrayList<Training> trainings = new ArrayList<>();

        trainings.add(preprareIntermediateTraining(skills.get(0)));
        trainings.add(preprareIntermediateTraining(skills.get(1)));
        trainings.add(preprareAdvancedTraining(skills.get(2)));
        return trainings;
    }

    @Override
    public ArrayList<Training> prepareAllIntermediate() {
        ArrayList<Skill> skills = this.mockAllBeginnerSkils();
        ArrayList<Training> trainings = new ArrayList<>();

        trainings.add(preprareIntermediateTraining(skills.get(0)));
        trainings.add(preprareIntermediateTraining(skills.get(1)));
        trainings.add(preprareIntermediateTraining(skills.get(2)));
        return trainings;
    }

    @Override
    public ArrayList<Training> prepareAllAdvanced() {
        ArrayList<Skill> skills = this.mockAllAdnvancedSkils();
        ArrayList<Training> trainings = new ArrayList<>();

        trainings.add(preprareAdvancedTraining(skills.get(0)));
        trainings.add(preprareAdvancedTraining(skills.get(1)));
        trainings.add(preprareAdvancedTraining(skills.get(2)));
        return trainings;
    }

    @Override
    public ArrayList<Training> prepareAllBeginer() {
        ArrayList<Skill> skills = this.mockAllBeginnerSkils();
        ArrayList<Training> trainings = new ArrayList<>();
        trainings.add(preprareBeginerTraining(skills.get(0)));
        trainings.add(preprareBeginerTraining(skills.get(1)));
        trainings.add(preprareBeginerTraining(skills.get(2)));
        return trainings;
    }

    @Override
    public ArrayList<TrainingExecution> prepareGoodTrainingHistory(ArrayList<Training> trainings) {
        ArrayList<TrainingExecution> trainHistory = new ArrayList<>();
        for(Training training: trainings) {
            TrainingExecution trainingExecution = new TrainingExecution();
            trainingExecution.setTraining(training);
            trainingExecution.setTrainingMark(TrainingMark.GOOD);
            trainHistory.add(trainingExecution);
        }
        return trainHistory;
    }

    @Override
    public ArrayList<TrainingExecution> preprareNoTrainingHistory() {
        return new ArrayList<>();
    }



    // CEP MOCK FUNCTION
    @Override
    public ArrayList<SkillExecutionEvent> makeMissSkil(int i, Long executionId) {
        ArrayList<SkillExecutionEvent> retVal = new ArrayList<>();
        for(int j=0; j< i; j++) {
            SkillExecutionEvent e = new SkillExecutionEvent(1, false, true,
                    0.0, 0.0, executionId);
            retVal.add(e);
        }
        return retVal;
    }

    @Override
    public ArrayList<SkillExecutionEvent> makeGoodShoots(int i, Long executionId) {
        ArrayList<SkillExecutionEvent> retVal = new ArrayList<>();
        for(int j=0; j< i; j++) {
            SkillExecutionEvent e = new SkillExecutionEvent(1, true, true,
                    0.0, 0.0, executionId);
            retVal.add(e);
        }
        return retVal;
    }

    @Override
    public TrainingExecution makeBegginerTrainingExecution() {
        ArrayList<Skill> beginerSkills = mockAllBeginnerSkils();
        Training training = preprareBeginerTraining(beginerSkills.get(0));
        TrainingExecution trainingExecution = new TrainingExecution();
        trainingExecution.setId(1l);
        trainingExecution.setDate(new Date());
        trainingExecution.setTraining(training);

        return trainingExecution;
    }

    @Override
    public TrainingExecution makeIntermediateTrainingExecution() {
        ArrayList<Skill> beginerSkills = mockAllIntermediateSkills();
        Training training = preprareIntermediateTraining(beginerSkills.get(0));
        TrainingExecution trainingExecution = new TrainingExecution();
        trainingExecution.setId(1l);
        trainingExecution.setDate(new Date());
        trainingExecution.setTraining(training);

        return trainingExecution;
    }

    @Override
    public TrainingExecution makeAdvancedTrainingExecution() {
        ArrayList<Skill> beginerSkills = mockAllAdnvancedSkils();
        Training training = preprareAdvancedTraining(beginerSkills.get(0));
        TrainingExecution trainingExecution = new TrainingExecution();
        trainingExecution.setId(1l);
        trainingExecution.setDate(new Date());
        trainingExecution.setTraining(training);
        return trainingExecution;
    }

    @Override
    public ArrayList<SkillExecutionEvent> makeBadRacketAngleShots(int i, double angle, Long id, Boolean bodyPosition) {
        ArrayList<SkillExecutionEvent> retVal = new ArrayList<>();
        for(int j=0; j< i; j++) {
            SkillExecutionEvent e = new SkillExecutionEvent(1, true, bodyPosition,
                    0.0, angle, id);
            retVal.add(e);
        }
        return retVal;
    }

    @Override
    public ArrayList<SkillExecutionEvent> makeBadRacketSpeedShots(int i, double deltaSpeed, Long id, Boolean bodyPosition) {
        ArrayList<SkillExecutionEvent> retVal = new ArrayList<>();
        for(int j=0; j< i; j++) {
            SkillExecutionEvent e = new SkillExecutionEvent(1, true, bodyPosition,
                    deltaSpeed, 0.0, id);
            retVal.add(e);
        }
        return retVal;
    }
}
