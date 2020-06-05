package tableTennisInstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tableTennisInstructor.dto.response.UserDTO;
import tableTennisInstructor.dto.response.UserHealthDTO;
import tableTennisInstructor.model.User;
import tableTennisInstructor.model.drools.facts.UserHealth;
import tableTennisInstructor.model.drools.facts.training.Training;
import tableTennisInstructor.service.UserHealthService;
import tableTennisInstructor.service.UserService;

import java.security.Principal;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/userHealth", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserHealthCotroller {


    @Autowired
    private UserHealthService userHealthService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserHealthDTO> findByUserId(@PathVariable Long userId) {

        UserHealth uh = userHealthService.findUserHealthByUserId(userId);
        UserHealthDTO userHealthDTO = new UserHealthDTO(uh.getId(), uh.getUser().getId(),
                uh.getHeartbeat(), uh.getSystolic(), uh.getDiastolic());

        return new ResponseEntity<>(userHealthDTO, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<UserHealthDTO> update(@RequestBody UserHealthDTO userHealthDTO) {
        UserHealth updatedUh = userHealthService.updateUserHealth(userHealthDTO);
        UserHealthDTO updatedUserHealthDTO = new UserHealthDTO(updatedUh.getId(), updatedUh.getUser().getId(),
                updatedUh.getHeartbeat(), updatedUh.getSystolic(), updatedUh.getDiastolic());

        return new ResponseEntity<>(updatedUserHealthDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserHealthDTO> add(@RequestBody UserHealthDTO userHealthDTO, Principal principal) {
        User user = this.userService.getByUsername(principal.getName());
        UserHealth addedUh = userHealthService.add(userHealthDTO, user);
        UserHealthDTO updatedUserHealthDTO = new UserHealthDTO(addedUh.getId(), addedUh.getUser().getId(),
                addedUh.getHeartbeat(), addedUh.getSystolic(), addedUh.getDiastolic());
        return new ResponseEntity<>(updatedUserHealthDTO, HttpStatus.OK);
    }
}
