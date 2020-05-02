package tableTennisInstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tableTennisInstructor.model.drools.facts.Item;
import tableTennisInstructor.service.ProbaService;

@RestController
@RequestMapping("/api/public/hello-world")
public class PublicHelloWorldController {

    @Autowired
    private ProbaService probaService;

    @GetMapping
    public ResponseEntity<Item> helloWorld() {
        Item newItem = new Item(Long.parseLong("1"), "item1", 200.0, 120.0);
        Item i2 = probaService.getClassifiedItem(newItem);
        return new ResponseEntity<>(i2, HttpStatus.OK);

//        return new ResponseEntity<>("Hello World from PUBLIC controller!", HttpStatus.OK);
    }
}
