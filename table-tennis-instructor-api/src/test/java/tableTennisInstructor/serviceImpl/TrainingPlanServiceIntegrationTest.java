package tableTennisInstructor.serviceImpl;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import tableTennisInstructor.constants.Constants;
import tableTennisInstructor.model.User;
import tableTennisInstructor.model.drools.facts.UserHealth;
import tableTennisInstructor.model.drools.facts.UserHealthState;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.model.drools.facts.training.*;
import tableTennisInstructor.service.TrainingPlanService;
import tableTennisInstructor.service.Util;
import tableTennisInstructor.service.impl.UtilImpl;

import java.util.ArrayList;
import java.util.Date;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TrainingPlanServiceIntegrationTest {


    @Autowired
    private TrainingPlanService trainingPlanService;

    private static Util util;

    private static User user;

    private static UserHealth goodHealth;
    private static UserHealth averageHealth;
    private static UserHealth badHealth;
    private static Skill desiredSkill;

    private static ArrayList<Skill> allSkills;

    @BeforeClass
    public static void setUp() {
        user = new User();
        user.setId(Constants.USER_ID);

        util = new UtilImpl();

        goodHealth = util.mockGoodUserHealth(user);
        averageHealth = util.mockAverageUserHealth(user);
        badHealth = util.mockBadUserHealth(user);



    }


    /*
        1. cinjenice o userHealt postavljene tako da sistem rezonuje DOBRO ZDRAVLJE
            => to omogucava da se odabere bilo koji nivo treninga

        2. cinjenice o duzini trajanja treninga podesene na DUGO tako da sistem rezonuje DUG TRENING
            => to omogucava da se odabere bilo koji nivo treninga

        3. bez istorije treninga
            => sistem bi trabalo da izrezonuje predhodno znanje POCETNICKO
            => sistem bi trebalo da izrezonuje slicno znanje POCETNICKO

        4. nivo treninga
            => sitem treba da izrezonuje POCETNICKI NIVO zbog uslova:
                a. POCETNICKO predhodno znanje
                b. POCETNICKO slicno znanjes
    */

    @Test
    public void chooseBeginerTrainningPlanWhenNoTrainingHistory() {
        allSkills = util.mockAllBeginnerSkils();
        desiredSkill = allSkills.get(4);

        TrainingChooseRequestFact requestFact = new TrainingChooseRequestFact();
        requestFact.setUserHealth(goodHealth);
        requestFact.setUserId(Constants.USER_ID);
        requestFact.setDesiredSkill(desiredSkill);
        requestFact.setTrainHistory(util.preprareNoTrainingHistory());
        requestFact.setTrainingDuration(util.preprareLongTrainingTime());

        TrainingChooseFact trainingChooseFact = trainingPlanService.findTrainingPlan(requestFact, allSkills);

        assertNotNull(trainingChooseFact);
        assertTrue(trainingChooseFact.getUserHealthState().equals(UserHealthState.GOOD));
        assertTrue(trainingChooseFact.getTrainingDuradtion().equals(TrainingDuration.LONG));
        assertTrue(trainingChooseFact.getPreviousKnowledge().equals(Knowledge.BEGINNER));
        assertTrue(trainingChooseFact.getSimilarKnowledge().equals(Knowledge.BEGINNER));
        assertTrue(trainingChooseFact.getChoosenLevel().equals(TrainingLevel.BEGINNER));


        System.out.println(trainingChooseFact.getChoosenLevel());
    }

     /*
        1. cinjenice o userHealt postavljene tako da sistem rezonuje LOSE ZDRAVLJE
            => to omogucava da se odabere SAMO POCETNICKI nivo treninga

        2. cinjenice o duzini trajanja treninga podesene na DUGO tako da sistem rezonuje DUG TRENING
            => to omogucava da se odabere bilo koji nivo treninga

        3. sistem bi trabalo da izrezonuje predhodno znanje SREDNJE
            jer poznaje jednu tehniku jer je trenirao na pocetnom nivou i dobio dobru ocenu

        5. sistem bi trebalo da izrezonuje slicno znanje SREDNJE jer je poznaje vise
                tehnika POCETNICKOG NIVOA

        4. nivo treninga
            => sitem treba da izrezonuje POCETNICKI NIVO zbog uslova:
                a. SREDNJE predhodno znanje
                b. SREDNJE slicno znanjes
                c. ZDAVLJE JE LOSE
    */

    @Test
    public void chooseBeginerTrainningPlanWhenBadHealth() {

        allSkills = util.mockAllBeginnerSkils();
        desiredSkill = allSkills.get(4);

        TrainingChooseRequestFact requestFact = new TrainingChooseRequestFact();
        requestFact.setUserHealth(badHealth);
        requestFact.setUserId(Constants.USER_ID);
        requestFact.setDesiredSkill(desiredSkill);
        requestFact.setTrainHistory(util.prepareGoodTrainingHistory(util.prepareAllIntermediate()));
        requestFact.setTrainingDuration(util.preprareLongTrainingTime());

        TrainingChooseFact trainingChooseFact = trainingPlanService.findTrainingPlan(requestFact, allSkills);

        assertNotNull(trainingChooseFact);
        assertTrue(trainingChooseFact.getUserHealthState().equals(UserHealthState.BAD));
        assertTrue(trainingChooseFact.getTrainingDuradtion().equals(TrainingDuration.LONG));
        assertTrue(trainingChooseFact.getPreviousKnowledge().equals(Knowledge.INTERMEDIATE));
        assertTrue(trainingChooseFact.getSimilarKnowledge().equals(Knowledge.INTERMEDIATE));
        assertTrue(trainingChooseFact.getChoosenLevel().equals(TrainingLevel.BEGINNER));

        System.out.println(trainingChooseFact.getChoosenLevel());
    }


    /*
        1. cinjenice o userHealt postavljene tako da sistem rezonuje DOBRO ZDRAVLJE
            => to omogucava da se odabere bilo koji nivo trenigna

        2. cinjenice o duzini trajanja treninga podesene na DUGO tako da sistem rezonuje DUG TRENING
            => to omogucava da se odabere bilo koji nivo treninga

        3. sistem bi trabalo da izrezonuje predhodno znanje NAPREDNO
            jer poznaje jednu tehniku jer je trenirao na SREDNJE nivou i dobio DOBRU ocenu

        5. sistem bi trebalo da izrezonuje slicno znanje NAPREDNOs jer je poznaje vise
                tehnika SREDNJEG NIVOA

        4. nivo treninga
            => sitem treba da izrezonuje NAPREDNI NIVO zbog uslova:
                a. NAPREDNO predhodno znanje
                b. NAPREDNO slicno znanjes
                c. DOBRO JE LOSE
    */

    @Test
    public void chooseAdvancedTrainningPlanWhenAllGood() {

        allSkills = util.mockAllAdnvancedSkils();
        desiredSkill = allSkills.get(4);

        TrainingChooseRequestFact requestFact = new TrainingChooseRequestFact();
        requestFact.setUserHealth(goodHealth);
        requestFact.setUserId(Constants.USER_ID);
        requestFact.setDesiredSkill(desiredSkill);
        requestFact.setTrainHistory(util.prepareGoodTrainingHistory(util.prepareAllAdvanced()));
        requestFact.setTrainingDuration(util.preprareLongTrainingTime());

        TrainingChooseFact trainingChooseFact = trainingPlanService.findTrainingPlan(requestFact, allSkills);

        assertNotNull(trainingChooseFact);
        assertTrue(trainingChooseFact.getUserHealthState().equals(UserHealthState.GOOD));
        assertTrue(trainingChooseFact.getTrainingDuradtion().equals(TrainingDuration.LONG));
        assertTrue(trainingChooseFact.getPreviousKnowledge().equals(Knowledge.ADVANCED));
        assertTrue(trainingChooseFact.getSimilarKnowledge().equals(Knowledge.ADVANCED));
        assertTrue(trainingChooseFact.getChoosenLevel().equals(TrainingLevel.ADVANCED));


        System.out.println(trainingChooseFact.getChoosenLevel());
    }


    @Test
    public void chooseIntermediateTrainningPlanWhenPreviousKnowledgeIntermediate() {

        allSkills = util.mockAllIntermediateSkills();
        desiredSkill = allSkills.get(4);

        TrainingChooseRequestFact requestFact = new TrainingChooseRequestFact();
        requestFact.setUserHealth(goodHealth);
        requestFact.setUserId(Constants.USER_ID);
        requestFact.setDesiredSkill(desiredSkill);
        requestFact.setTrainHistory(util.prepareGoodTrainingHistory(util.prepareTwoIntermediateAndOneAdvandec()));
        requestFact.setTrainingDuration(util.preprareLongTrainingTime());

        TrainingChooseFact trainingChooseFact = trainingPlanService.findTrainingPlan(requestFact, allSkills);

        assertNotNull(trainingChooseFact);
        assertTrue(trainingChooseFact.getUserHealthState().equals(UserHealthState.GOOD));
        assertTrue(trainingChooseFact.getTrainingDuradtion().equals(TrainingDuration.LONG));
        assertTrue(trainingChooseFact.getPreviousKnowledge().equals(Knowledge.INTERMEDIATE));
        assertTrue(trainingChooseFact.getSimilarKnowledge().equals(Knowledge.INTERMEDIATE));
        assertTrue(trainingChooseFact.getChoosenLevel().equals(TrainingLevel.INTERMEDIATE));

        System.out.println(trainingChooseFact.getChoosenLevel());
    }





}
