package tableTennisInstructor.config;

import org.apache.maven.shared.invoker.*;
import org.drools.core.io.impl.ReaderResource;
import org.drools.verifier.Verifier;
import org.drools.verifier.builder.VerifierBuilder;
import org.drools.verifier.builder.VerifierBuilderFactory;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tableTennisInstructor.constants.KieConstants;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;

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
        ArrayList<String> commands = new ArrayList<>();
        commands.add("install");
        commands.add("clean");
        request.setGoals(commands);

        Invoker invoker = new DefaultInvoker();
        // dok ne namestim M2_HOME da radi..
        invoker.setMavenHome(new File(KieConstants.MAVEN_HOME));
        InvocationResult result =  invoker.execute( request );
        if (result.getExitCode() != 0) {
            System.out.println(result.getExecutionException().toString());
            System.out.println(result.getExitCode());
        }
    }

    public static ArrayList<String> verifyDRLFile(String drl) {
        ArrayList<String> errors = new ArrayList<>();
        VerifierBuilder vBuilder = VerifierBuilderFactory.newVerifierBuilder();
        Verifier verifier = vBuilder.newVerifier();
        verifier.addResourcesToVerify(new ReaderResource(new StringReader(drl)), ResourceType.DRL);

        for (int i = 0; i < verifier.getErrors().size(); i++)
        {
            errors.add(verifier.getErrors().get(i).getMessage());
        }
        return errors;
    }

}
