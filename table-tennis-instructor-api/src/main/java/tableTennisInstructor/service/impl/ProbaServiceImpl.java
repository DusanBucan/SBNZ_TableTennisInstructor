package tableTennisInstructor.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tableTennisInstructor.model.facts.Item;
import tableTennisInstructor.service.ProbaService;

@Service
public class ProbaServiceImpl implements ProbaService {

    @Autowired
    private KieContainer kieContainer;

    @Override
    public Item getClassifiedItem(Item i) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(i);
        kieSession.fireAllRules();
        kieSession.dispose();
        return i;
    }
}
