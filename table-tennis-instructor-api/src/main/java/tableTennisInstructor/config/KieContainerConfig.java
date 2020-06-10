package tableTennisInstructor.config;

import org.apache.maven.shared.invoker.*;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tableTennisInstructor.constants.KieConstants;

import java.io.File;
import java.util.Collections;

@Configuration
public class KieContainerConfig {

    @Bean
    public KieContainer kieContainer() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = null;
        try {
            kContainer = ks.newKieContainer(ks.newReleaseId(KieConstants.NEW_RELEASE_ID_VAR1,
                    KieConstants.NEW_RELEASE_ID_VAR2, KieConstants.NEW_RELEASE_ID_VAR3));
        } catch (Exception e) {
            KieContainerConfig.installKjar();
            kContainer = ks.newKieContainer(ks.newReleaseId(KieConstants.NEW_RELEASE_ID_VAR1,
                    KieConstants.NEW_RELEASE_ID_VAR2, KieConstants.NEW_RELEASE_ID_VAR3));
        }
        finally {
            KieScanner kScanner = ks.newKieScanner(kContainer);
            kScanner.start(10_000);
            return kContainer;
        }

    }


    public static void installKjar() throws MavenInvocationException {
        InvocationRequest request = new DefaultInvocationRequest();
        File f = new File(KieConstants.KJAR_POM_PATH );
        request.setPomFile(f);
        request.setGoals(Collections.singletonList( "install" ));

        Invoker invoker = new DefaultInvoker();
        // dok ne namestim M2_HOME da radi..
        invoker.setMavenHome(new File(KieConstants.MAVEN_HOME));
        InvocationResult result =  invoker.execute( request );
        if (result.getExitCode() != 0) {
            System.out.println(result.getExecutionException().toString());
            System.out.println(result.getExitCode());
        }
    }

}
