package tableTennisInstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tableTennisInstructor.model.drools.facts.skill.Skill;
import tableTennisInstructor.service.SkillService;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/skill", produces = MediaType.APPLICATION_JSON_VALUE)
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping(path = "getAll")
    public ResponseEntity<ArrayList<Skill>> getAll() {
        return new ResponseEntity<>(skillService.findAll(), HttpStatus.OK);
    }
}
