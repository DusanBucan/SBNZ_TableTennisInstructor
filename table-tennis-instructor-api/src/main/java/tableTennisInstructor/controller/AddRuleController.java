package tableTennisInstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tableTennisInstructor.service.AddRuleService;
import tableTennisInstructor.util.MyFile;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/rules", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddRuleController {

    @Autowired
    private AddRuleService addRuleService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ArrayList<String>> addSkill(@RequestParam(("file")) MultipartFile q) throws Exception {
        ArrayList<String> errors = addRuleService.addRuleService(q);
        return new ResponseEntity<>(errors, HttpStatus.OK);
    }
}
