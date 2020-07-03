package tableTennisInstructor.service.impl;

import org.kie.api.runtime.KieContainer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tableTennisInstructor.config.KieContainerConfig;
import tableTennisInstructor.constants.KieConstants;
import tableTennisInstructor.service.AddRuleService;
import tableTennisInstructor.util.MyFile;

import java.util.ArrayList;

@Service
public class AddRuleServiceImpl implements AddRuleService {


    @Override
    public ArrayList<String> addRuleService(MultipartFile rules) throws Exception {
        String drl = MyFile.readFile(rules);
        ArrayList<String> errors = KieContainerConfig.verifyDRLFile(drl);
        if (errors.size() < 1) {
            MyFile.writeToKjarFile(drl);
            KieContainerConfig.installKjar();
        }
        return errors;
    }
}
