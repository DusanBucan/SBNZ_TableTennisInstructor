package tableTennisInstructor.serviceImpl;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tableTennisInstructor.constants.Constants;
import tableTennisInstructor.model.drools.events.SkillExecutionEvent;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.model.drools.facts.training.TrainingMark;
import tableTennisInstructor.service.TrainingMonitorService;
import tableTennisInstructor.service.Util;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TrainingMonitorServiceIntegrationTest {

    @Autowired
    private TrainingMonitorService trainingMonitorService;

    @Autowired
    private Util util;


    /*
    *  da bi se kreirao event previse promasaja za POCETNICKI nivo treba da bude vise od 35% promasaja
    *  test je podesen tako da imam:
    *
    *   4 dobra izvodjenja
    *   8 losih izdodjenja sto je vise nego 40% od ukupnog broja izvodjenja
    * */

    @Test
//    @Ignore
    public void makeBadMark_When_ToMuchMiss_Begginer_level() {
        TrainingExecution beginerTrainingExecution = util.makeBegginerTrainingExecution();
        ArrayList<SkillExecutionEvent> executions = util.makeGoodShoots(2, beginerTrainingExecution.getId());
        executions.addAll(util.makeMissSkil(4, beginerTrainingExecution.getId()));
        executions.addAll(util.makeGoodShoots(2, beginerTrainingExecution.getId()));
        executions.addAll(util.makeMissSkil(4, beginerTrainingExecution.getId()));

        trainingMonitorService.simulateTraining(beginerTrainingExecution, executions);

        assertTrue(beginerTrainingExecution.getTrainingMark().equals(TrainingMark.BAD));
    }

    /*
    *  potrenbo je da postoji vise od 7 SkillCorrection eventa da bi se dobila lose ocena na pocetnickom nivou
    *
    *   2 uzastopna losa ugla reketa sa losim polozajem tela na kreirace se SkillCorrection: podesiti telo i ugao reketa
    *   2 uzastopna losa brzina reketa sa losim polozajem tela na kreirace se SkillCorrection: podesiti telo i brzinu reketa
    *
    *   ako stavimo u sistem:
    *       - 8 losih uglova reketa + bad body position ---> dobicemo 4 skillCorrection
    *       - 8 losih brzina reketa + bad body postion ---> dobicemo 4 skillCorrection
    *
    *   -- ukupno 8 SkillCorrection sto je dovoljno da se na pocetnickom nivou dobije LOSA OCENA
    *            zbog preveise SkillCorrection eventa
    *
    *   -- izmedju losih izvodjenja je ubaceno i po koje dobro kako scenario bio realniji
    *
    * */

    @Test
//    @Ignore
    public void makeBadMark_When_ToMuchSkillCorrections_Begginer_level() {

        TrainingExecution beginerTrainingExecution = util.makeBegginerTrainingExecution();
        ArrayList<SkillExecutionEvent> executions = util.makeGoodShoots(2, beginerTrainingExecution.getId());

        executions.addAll(util.makeBadRacketAngleShots(4, Constants.BAD_RACKET_ANGLE_BEGINER_LVL, beginerTrainingExecution.getId(), false));
        executions.addAll(util.makeBadRacketSpeedShots(4, Constants.BAD_RACKET_DELTA_SPEED_BEGINER_LVL, beginerTrainingExecution.getId(), false));

        executions.addAll(util.makeGoodShoots(2, beginerTrainingExecution.getId()));
        executions.addAll(util.makeBadRacketAngleShots(2, Constants.BAD_RACKET_ANGLE_BEGINER_LVL, beginerTrainingExecution.getId(), false));
        executions.addAll(util.makeBadRacketSpeedShots(4, Constants.BAD_RACKET_DELTA_SPEED_BEGINER_LVL, beginerTrainingExecution.getId(), false));

        executions.addAll(util.makeGoodShoots(2, beginerTrainingExecution.getId()));
        executions.addAll(util.makeBadRacketAngleShots(2, Constants.BAD_RACKET_ANGLE_BEGINER_LVL, beginerTrainingExecution.getId(), false));


        trainingMonitorService.simulateTraining(beginerTrainingExecution, executions);

        assertTrue(beginerTrainingExecution.getTrainingMark().equals(TrainingMark.BAD));
    }

    /*
     *  potrenbo je da postoji vise od 6 a manje od 8 SkillCorrection eventa da bi se dobila Dobra ocena na pocetnickom nivou
     *  i da nema previse promasaja(vise od 40%)
     *
     *   2 uzastopna losa ugla reketa sa losim polozajem tela na kreirace se SkillCorrection: podesiti telo i ugao reketa
     *   2 uzastopna losa brzina reketa sa losim polozajem tela na kreirace se SkillCorrection: podesiti telo i brzinu reketa
     *
     *   ako stavimo u sistem:
     *       - 6 losih uglova reketa + bad body position ---> dobicemo 3 skillCorrection
     *       - 8 losih brzina reketa + bad body postion ---> dobicemo 4 skillCorrection
     *
     *   -- ukupno 7 SkillCorrection sto je dovoljno da se na pocetnickom nivou NE dobije ODLICNA OCENA
     *            zbog previse SkillCorrection eventa, ali nije ni za LOSU ocenu, pa se dobija SREDNJA OCENA
     *
     *   -- izmedju losih izvodjenja je ubaceno i po koje dobro kako scenario bio realniji
     *
     * */


    @Test
//    @Ignore
    public void makeGoodMark_When_Begginer_level() {
        TrainingExecution beginerTrainingExecution = util.makeBegginerTrainingExecution();
        ArrayList<SkillExecutionEvent> executions = util.makeGoodShoots(2, beginerTrainingExecution.getId());

        executions.addAll(util.makeBadRacketAngleShots(2, Constants.BAD_RACKET_ANGLE_BEGINER_LVL, beginerTrainingExecution.getId(), false));
        executions.addAll(util.makeBadRacketSpeedShots(4, Constants.BAD_RACKET_DELTA_SPEED_BEGINER_LVL, beginerTrainingExecution.getId(), false));

        executions.addAll(util.makeGoodShoots(2, beginerTrainingExecution.getId()));
        executions.addAll(util.makeBadRacketAngleShots(2, Constants.BAD_RACKET_ANGLE_BEGINER_LVL, beginerTrainingExecution.getId(), false));
        executions.addAll(util.makeBadRacketSpeedShots(4, Constants.BAD_RACKET_DELTA_SPEED_BEGINER_LVL, beginerTrainingExecution.getId(), false));

        executions.addAll(util.makeGoodShoots(2, beginerTrainingExecution.getId()));
        executions.addAll(util.makeBadRacketAngleShots(2, Constants.BAD_RACKET_ANGLE_BEGINER_LVL, beginerTrainingExecution.getId(), false));


        trainingMonitorService.simulateTraining(beginerTrainingExecution, executions);

        assertTrue(beginerTrainingExecution.getTrainingMark().equals(TrainingMark.GOOD));
    }

    /*
    *   da bi se dobila ODLICNA OCENA na pocetnickom nivou potreno je da:
    *       1. nema previse promasaja
    *       2. da nema vise od 6 ispravki tehnike
    *
    *   -- u test su izmedju uspesnih izvodjenja dodata i losa izvodjenja kako bi scenario bio realniji
    * */
    @Test
//    @Ignore
    public void makeExcelentMark_When_Begginer_level() {

        TrainingExecution beginerTrainingExecution = util.makeBegginerTrainingExecution();
        ArrayList<SkillExecutionEvent> executions = util.makeGoodShoots(2, beginerTrainingExecution.getId());

        executions.addAll(util.makeBadRacketAngleShots(2, Constants.BAD_RACKET_ANGLE_BEGINER_LVL, beginerTrainingExecution.getId(), false));
        executions.addAll(util.makeGoodShoots(4, beginerTrainingExecution.getId()));
        executions.addAll(util.makeBadRacketSpeedShots(4, Constants.BAD_RACKET_DELTA_SPEED_BEGINER_LVL, beginerTrainingExecution.getId(), false));
        executions.addAll(util.makeGoodShoots(6, beginerTrainingExecution.getId()));

        trainingMonitorService.simulateTraining(beginerTrainingExecution, executions);

        assertTrue(beginerTrainingExecution.getTrainingMark().equals(TrainingMark.EXCELLENT));
    }


    /*
     *  da bi se kreirao event previse promasaja za SREDNJI nivo treba da bude vise od 35% promasaja
     *  test je podesen tako da imam:
     *
     *   4 dobra izvodjenja
     *   4 losih izdodjenja sto je vise nego 30% od ukupnog broja izvodjenja
     * */

    @Test
//    @Ignore
    public void makeBadMark_When_ToMuchMiss_Intermediate_Level() {
        TrainingExecution trainingExecution = util.makeIntermediateTrainingExecution();
        ArrayList<SkillExecutionEvent> executions = util.makeGoodShoots(2, trainingExecution.getId());
        executions.addAll(util.makeMissSkil(2, trainingExecution.getId() ));
        executions.addAll(util.makeGoodShoots(2, trainingExecution.getId() ));
        executions.addAll(util.makeMissSkil(2, trainingExecution.getId() ));

        trainingMonitorService.simulateTraining(trainingExecution, executions);

        assertTrue(trainingExecution.getTrainingMark().equals(TrainingMark.BAD));
    }


    /*
    *   Korisnik koji trenira trening srendjeg nivoa ce dobiti losu ocenu kao ima vise od 5 SkillCorrection-a
    *   eventa (upozorenja da popravi tehniku) za vreme treninga
    *
    *   -- u test bi trebalo da se kreira 6 eventa SkillCorrection, pa bi konacna ocena trebala da bude BAD.
    * */
    @Test
//    @Ignore
    public void makeBadMark_When_ToMuchSkillCorrections_Intermediate_level() {
        TrainingExecution trainingExecution = util.makeIntermediateTrainingExecution();
        ArrayList<SkillExecutionEvent> executions = util.makeGoodShoots(2, trainingExecution.getId());
        executions.addAll(util.makeMissSkil(2, trainingExecution.getId() ));
        executions.addAll(util.makeGoodShoots(2, trainingExecution.getId() ));
        executions.addAll(util.makeMissSkil(1, trainingExecution.getId() ));


        executions.addAll(util.makeBadRacketAngleShots(2, Constants.BAD_RACKET_ANGLE_INTERMEDIATE_LVL, trainingExecution.getId(), false));
        executions.addAll(util.makeBadRacketSpeedShots(4, Constants.BAD_RACKET_DELTA_SPEED_INTERMEDIATE_LVL, trainingExecution.getId(), false));
        executions.addAll(util.makeGoodShoots(2, trainingExecution.getId() ));
        executions.addAll(util.makeBadRacketAngleShots(4, Constants.BAD_RACKET_ANGLE_INTERMEDIATE_LVL, trainingExecution.getId(), false));
        executions.addAll(util.makeBadRacketSpeedShots(2, Constants.BAD_RACKET_DELTA_SPEED_INTERMEDIATE_LVL, trainingExecution.getId(), false));

        trainingMonitorService.simulateTraining(trainingExecution, executions);
        assertTrue(trainingExecution.getTrainingMark().equals(TrainingMark.BAD));
    }

    /*
    *   Korisnik ce dobiti ODLICNU ocenu na treningu srednjeg nivoa ako nema VISE od 5 SKillCorrection-a i
    *   ako nema UKUPNO PREVISE PROMASAJAs
    *
    * */
    @Test
//    @Ignore
    public void makeExcelentMark_When_Intermediate_level() {
        TrainingExecution trainingExecution = util.makeIntermediateTrainingExecution();
        ArrayList<SkillExecutionEvent> executions = util.makeGoodShoots(2, trainingExecution.getId());
        executions.addAll(util.makeMissSkil(3, trainingExecution.getId() ));
        executions.addAll(util.makeGoodShoots(2, trainingExecution.getId() ));
        executions.addAll(util.makeMissSkil(1, trainingExecution.getId() ));
        executions.addAll(util.makeGoodShoots(8, trainingExecution.getId() ));
        executions.addAll(util.makeBadRacketSpeedShots(2, Constants.BAD_RACKET_DELTA_SPEED_INTERMEDIATE_LVL, trainingExecution.getId(), false));
        executions.addAll(util.makeGoodShoots(2, trainingExecution.getId() ));

        trainingMonitorService.simulateTraining(trainingExecution, executions);
        assertTrue(trainingExecution.getTrainingMark().equals(TrainingMark.EXCELLENT));
    }

    @Test
//    @Ignore
    public void makeBadMark_When_ToMuchMiss_Advance_Level() {
        TrainingExecution trainingExecution = util.makeAdvancedTrainingExecution();
        Long trainingExecutionId = trainingExecution.getId();
        ArrayList<SkillExecutionEvent> executions = util.makeGoodShoots(5, trainingExecutionId);
        executions.addAll(util.makeMissSkil(3, trainingExecutionId));
        trainingMonitorService.simulateTraining(trainingExecution, executions);
        assertTrue(trainingExecution.getTrainingMark().equals(TrainingMark.BAD));

    }

    /*
    * na ADVANCED NIVOU ako Korisnik napravi dobije vise od 3 SkillCorrection upozorenja
    *
    *   u testu korisnik ce 4 puta biti upozoren da ispravi tehniku i zbog toga se ocekuje da dobije losu ocenus
    *
    * */
    @Test
//    @Ignore
    public void makeBadMark_When_ToMuchSkillCorrections_Advance_level() {
        TrainingExecution trainingExecution = util.makeAdvancedTrainingExecution();
        Long trainingExecutionId = trainingExecution.getId();
        ArrayList<SkillExecutionEvent> executions = util.makeGoodShoots(2, trainingExecutionId);

        executions.addAll(util.makeBadRacketSpeedShots(2, Constants.BAD_RACKET_DELTA_SPEED_ADVANCED_LVL, trainingExecution.getId(), false));
        executions.addAll(util.makeBadRacketSpeedShots(2, Constants.BAD_RACKET_DELTA_SPEED_ADVANCED_LVL, trainingExecution.getId(), false));
        executions.addAll(util.makeBadRacketAngleShots(4, Constants.BAD_RACKET_ANGLE_ADVANCED_LVL, trainingExecutionId, false));

        trainingMonitorService.simulateTraining(trainingExecution, executions);
        assertTrue(trainingExecution.getTrainingMark().equals(TrainingMark.BAD));
    }

    /*
    *   Korisnik ce Dobiti GOOD ocenu jer je upozoren jednom da ispravi tehniku (postoji SkillCorrectionEvent)
    *   pa ne moze dobiti EXCELENT ocenu, a nije za BAD ocenu.
    *  */
    @Test
//    @Ignore
    public void makeGoodMark_When_Advance_level() {
        TrainingExecution trainingExecution = util.makeAdvancedTrainingExecution();
        Long trainingExecutionId = trainingExecution.getId();
        ArrayList<SkillExecutionEvent> executions = util.makeGoodShoots(2, trainingExecutionId);

        executions.addAll(util.makeBadRacketSpeedShots(2, Constants.BAD_RACKET_DELTA_SPEED_ADVANCED_LVL, trainingExecution.getId(), false));
        executions.addAll(util.makeGoodShoots(2, trainingExecutionId));

        trainingMonitorService.simulateTraining(trainingExecution, executions);
        assertTrue(trainingExecution.getTrainingMark().equals(TrainingMark.GOOD));

    }

    @Test
//    @Ignore
    public void makeExcellentMark_When_Advance_level() {
        TrainingExecution trainingExecution = util.makeAdvancedTrainingExecution();
        Long trainingExecutionId = trainingExecution.getId();
        ArrayList<SkillExecutionEvent> executions = util.makeGoodShoots(2, trainingExecutionId);
        executions.addAll(util.makeGoodShoots(2, trainingExecutionId));
        executions.addAll(util.makeMissSkil(1, trainingExecutionId));

        trainingMonitorService.simulateTraining(trainingExecution, executions);
        assertTrue(trainingExecution.getTrainingMark().equals(TrainingMark.EXCELLENT));

    }


}
