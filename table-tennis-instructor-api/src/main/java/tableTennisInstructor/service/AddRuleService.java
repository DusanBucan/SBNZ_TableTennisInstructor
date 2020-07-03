package tableTennisInstructor.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface AddRuleService {

    public ArrayList<String> addRuleService(MultipartFile rule) throws Exception;
}
