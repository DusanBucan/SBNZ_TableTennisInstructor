package tableTennisInstructor.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tableTennisInstructor.service.AddRuleService;
import tableTennisInstructor.util.MyFile;

@Service
public class AddRuleServiceImpl implements AddRuleService {


    @Override
    public void addRuleService(MultipartFile rules) throws Exception {
        MyFile.writeToFile(rules);
    }
}
